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
    private static final String COUNTRY = "token:country:";
    private static final String TIMEZONE = "token:timeZone:";

    public static class TokenizerMapper
            extends Mapper<Object, Text, LongWritable, Text> {

        ObjectMapper mapper = new ObjectMapper();

        private Text word = new Text();
        private LongWritable id;
        private boolean countryPresent;

        public void map(Object key, Text value, Context context
        ) throws IOException, InterruptedException {

            try {
                // JSON to Tweet
                Tweet tweet = mapper.readValue(value.toString(), Tweet.class);

                // id
                id = new LongWritable(tweet.getId().longValue());

                // Country?
                countryPresent = false;
                for (String country : Countries.names) {
                    if (tweet.getText().indexOf(country) >= 0) {
                        countryPresent = true;
                        word.set(COUNTRY + country);
                        context.write(id, word);
                    }
                }

                if (countryPresent) {
                    // Keep Time zone
                    word.set(TIMEZONE + tweet.getUser().getTime_zone());
                    context.write(id, word);

                    // Word by word
                    StringTokenizer itr = new StringTokenizer(tweet.getText());
                    while (itr.hasMoreTokens()) {
                        String token = itr.nextToken();
                        word.set(token.replaceAll("[^a-zA-Z ]", ""));
                        context.write(id, word);
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