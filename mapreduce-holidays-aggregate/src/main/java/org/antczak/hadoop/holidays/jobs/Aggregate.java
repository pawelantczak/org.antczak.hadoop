package org.antczak.hadoop.holidays.jobs;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class Aggregate {

    private static final Log log = LogFactory.getLog(Aggregate.class);


    public static class TokenizerMapper
        extends Mapper<Object, Text, Text, IntWritable> {

        private Text line = new Text();
        private StringBuilder sb;

        public void map(Object key, Text value, Context context
        ) throws IOException, InterruptedException {

            String[] columns = value.toString().split("\001");
            String[] countries = columns[1].split(",");
            String from = columns.length == 4 ? columns[3] : "UNKNOWN";

            for (String country : countries) {
                sb = new StringBuilder();
                sb.append(from)
                    .append(" -> ")
                    .append(country);
                line.set(sb.toString());
                context.write(line, new IntWritable(Integer.valueOf(columns[2])));
            }

        }
    }


    public static class DummyReducer
        extends Reducer<Text, IntWritable, Text, Text> {

        private Text result = new Text();
        private StringBuilder sb;

        public void reduce(Text key, Iterable<IntWritable> values,
            Context context
        ) throws IOException, InterruptedException {
            int sum = 0;
            int pos = 0;
            int neg = 0;
            sb = new StringBuilder();

            for (IntWritable val : values) {
                if (val.get() > 0) {
                    pos++;
                }
                if (val.get() < 0) {
                    neg++;
                }
                sum++;
            }

            sb.append("All: ").
                append(sum)
                .append(", positive: ")
                .append(pos)
                .append(", negative: ")
                .append(neg);
            result.set(sb.toString());
            context.write(key, result);
        }
    }

}
