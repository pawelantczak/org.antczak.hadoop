
package org.antczak.hadoop.wordcount.tweet;

import java.util.List;

public class Entities{
   	private List<Hashtags> hashtags;
   	private List<Symbols> symbols;
   	private List<Trends> trends;
   	private List<Urls> urls;
   	private List<User_mentions> user_mentions;

 	public List<Hashtags> getHashtags(){
		return this.hashtags;
	}
	public void setHashtags(List<Hashtags> hashtags){
		this.hashtags = hashtags;
	}
 	public List<Symbols> getSymbols(){
		return this.symbols;
	}
	public void setSymbols(List<Symbols> symbols){
		this.symbols = symbols;
	}
 	public List<Trends> getTrends(){
		return this.trends;
	}
	public void setTrends(List<Trends> trends){
		this.trends = trends;
	}
 	public List<Urls> getUrls(){
		return this.urls;
	}
	public void setUrls(List<Urls> urls){
		this.urls = urls;
	}
 	public List<User_mentions> getUser_mentions(){
		return this.user_mentions;
	}
	public void setUser_mentions(List<User_mentions> user_mentions){
		this.user_mentions = user_mentions;
	}
}
