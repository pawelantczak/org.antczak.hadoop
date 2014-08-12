
package org.antczak.hadoop.holidays.tweet;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Entities {
    private List<Hashtags> hashtags;
    private List<Media> media;
    private List<String> symbols;
    private List<String> trends;
    private List<Urls> urls;
    private List<String> user_mentions;

    public List<Hashtags> getHashtags() {
        return this.hashtags;
    }

    public void setHashtags(List<Hashtags> hashtags) {
        this.hashtags = hashtags;
    }

    public List<Media> getMedia() {
        return this.media;
    }

    public void setMedia(List<Media> media) {
        this.media = media;
    }

    public List<String> getSymbols() {
        return this.symbols;
    }

    public void setSymbols(List<String> symbols) {
        this.symbols = symbols;
    }

    public List<String> getTrends() {
        return this.trends;
    }

    public void setTrends(List<String> trends) {
        this.trends = trends;
    }

    public List<Urls> getUrls() {
        return this.urls;
    }

    public void setUrls(List<Urls> urls) {
        this.urls = urls;
    }

    public List<String> getUser_mentions() {
        return this.user_mentions;
    }

    public void setUser_mentions(List<String> user_mentions) {
        this.user_mentions = user_mentions;
    }
}
