package org.antczak.hadoop.wordcount;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class WordCount {

    private static final Log log = LogFactory.getLog(WordCount.class);

    public static class TokenizerMapper extends Mapper<Object, Text, Text, IntWritable> {

        private Text word = new Text();

        public void map(Object key, Text value, Context context) throws IOException, InterruptedException {

            String[] tokens = value.toString().split(" ");

            for (String token : tokens) {
                word.set(token);
                context.write(word, new IntWritable(1));
            }
        }
    }

    public static class IntSumReducer extends Reducer<Text, IntWritable, Text, IntWritable> {
        private IntWritable result = new IntWritable();

        public void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException,
                InterruptedException {

            int sum = 0;

            for (IntWritable val : values) {
                sum += val.get();

            }

            result.set(sum);
            context.write(key, result);
        }
    }

}