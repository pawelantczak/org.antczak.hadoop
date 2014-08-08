package org.antczak.hadoop.holidays.jobs;

import org.antczak.hadoop.holidays.tweet.Media;
import org.antczak.hadoop.holidays.tweet.Tweet;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

public class TweetToUrl {

    private static final Log log = LogFactory.getLog(TweetToUrl.class);

    public static class TokenizerMapper
            extends Mapper<Object, Text, Text, Text> {

        ObjectMapper mapper = new ObjectMapper();

        private Text url = new Text();
        private Text type = new Text();

        public void map(Object key, Text value, Context context
        ) throws IOException, InterruptedException {
            log.debug("key:" + key);
            log.debug("value:" + value);
            try {
                Tweet tweet = mapper.readValue(value.toString(), Tweet.class);
                for (Media media : tweet.getEntities().getMedia()) {
                    url.set(media.getMedia_url());
                    type.set(media.getType());
                    context.write(type, url);
                }
            } catch (Exception ex) {

            }
        }
    }

    public static class IntSumReducer
            extends Reducer<Text, Text, Text, Text> {
        private Text result = new Text();

        public void reduce(Text key, Iterable<Text> values,
                           Context context
        ) throws IOException, InterruptedException {
            //if (key.toString().equals("photo"))
                for (Text val : values) {
                    result.set(val);
                    context.write(key, result);

                }
        }
    }

}