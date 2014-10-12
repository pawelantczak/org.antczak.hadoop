package org.antczak.hadoop.holidays.jobs;

import org.antczak.hadoop.holidays.Countries;
import org.antczak.hadoop.holidays.tweet.Tweet;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.util.StringTokenizer;

public class TweetToWords {

    private static final Log log = LogFactory.getLog(TweetToWords.class);


    public static class TokenizerMapper
        extends Mapper<Object, Text, LongWritable, Text> {

        ObjectMapper mapper = new ObjectMapper();

        private Text line = new Text();
        private LongWritable id;

        public void map(Object key, Text value, Context context
        ) throws IOException, InterruptedException {

            try {
                // JSON to Tweet
                Tweet tweet = mapper.readValue(value.toString(), Tweet.class);

                // id
                id = new LongWritable(tweet.getId().longValue());

                // Country?
                String countries = "";
                for (String country : Countries.names) {
                    if (tweet.getText().indexOf(country) >= 0) {
                        if (countries.length() > 0) {
                            countries = countries.concat(",").concat(country);
                        } else {
                            countries = countries.concat(country);
                        }
                    }
                }


                if (countries.length() > 0) {
                    // Keep Time zone
                    String timeZone = tweet.getUser().getTime_zone();

                    // Word by word
                    StringTokenizer itr = new StringTokenizer(tweet.getText());
                    StringBuilder stringBuilder;
                    String token;
                    while (itr.hasMoreTokens()) {
                        token = itr.nextToken();
                        stringBuilder = new StringBuilder();
                        stringBuilder.append(token.replaceAll("[^a-zA-Z ]", ""))
                            .append("\t")
                            .append(countries)
                            .append("\t")
                            .append(timeZone);
                        line.set(stringBuilder.toString());
                        context.write(id, line);
                    }
                }
            } catch (Exception ex) {
                log.error(ex);
            }

        }
    }

    public static class DummyReducer
        extends Reducer<LongWritable, Text, LongWritable, Text> {

        public void reduce(LongWritable id, Iterable<Text> values,
            Context context
        ) throws IOException, InterruptedException {
            for (Text value : values) {
                context.write(id, value);
            }
        }
    }

}
