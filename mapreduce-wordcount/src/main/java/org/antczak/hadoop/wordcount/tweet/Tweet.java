
package org.antczak.hadoop.wordcount.tweet;

import java.util.List;

public class Tweet{
   	private String contributors;
   	private String coordinates;
   	private String created_at;
   	private Entities entities;
   	private Number favorite_count;
   	private boolean favorited;
   	private String filter_level;
   	private String geo;
   	private Number id;
   	private String id_str;
   	private String in_reply_to_screen_name;
   	private String in_reply_to_status_id;
   	private String in_reply_to_status_id_str;
   	private String in_reply_to_user_id;
   	private String in_reply_to_user_id_str;
   	private String lang;
   	private String place;
   	private boolean possibly_sensitive;
   	private Number retweet_count;
   	private boolean retweeted;
   	private String source;
   	private String text;
   	private boolean truncated;
   	private User user;

 	public String getContributors(){
		return this.contributors;
	}
	public void setContributors(String contributors){
		this.contributors = contributors;
	}
 	public String getCoordinates(){
		return this.coordinates;
	}
	public void setCoordinates(String coordinates){
		this.coordinates = coordinates;
	}
 	public String getCreated_at(){
		return this.created_at;
	}
	public void setCreated_at(String created_at){
		this.created_at = created_at;
	}
 	public Entities getEntities(){
		return this.entities;
	}
	public void setEntities(Entities entities){
		this.entities = entities;
	}
 	public Number getFavorite_count(){
		return this.favorite_count;
	}
	public void setFavorite_count(Number favorite_count){
		this.favorite_count = favorite_count;
	}
 	public boolean getFavorited(){
		return this.favorited;
	}
	public void setFavorited(boolean favorited){
		this.favorited = favorited;
	}
 	public String getFilter_level(){
		return this.filter_level;
	}
	public void setFilter_level(String filter_level){
		this.filter_level = filter_level;
	}
 	public String getGeo(){
		return this.geo;
	}
	public void setGeo(String geo){
		this.geo = geo;
	}
 	public Number getId(){
		return this.id;
	}
	public void setId(Number id){
		this.id = id;
	}
 	public String getId_str(){
		return this.id_str;
	}
	public void setId_str(String id_str){
		this.id_str = id_str;
	}
 	public String getIn_reply_to_screen_name(){
		return this.in_reply_to_screen_name;
	}
	public void setIn_reply_to_screen_name(String in_reply_to_screen_name){
		this.in_reply_to_screen_name = in_reply_to_screen_name;
	}
 	public String getIn_reply_to_status_id(){
		return this.in_reply_to_status_id;
	}
	public void setIn_reply_to_status_id(String in_reply_to_status_id){
		this.in_reply_to_status_id = in_reply_to_status_id;
	}
 	public String getIn_reply_to_status_id_str(){
		return this.in_reply_to_status_id_str;
	}
	public void setIn_reply_to_status_id_str(String in_reply_to_status_id_str){
		this.in_reply_to_status_id_str = in_reply_to_status_id_str;
	}
 	public String getIn_reply_to_user_id(){
		return this.in_reply_to_user_id;
	}
	public void setIn_reply_to_user_id(String in_reply_to_user_id){
		this.in_reply_to_user_id = in_reply_to_user_id;
	}
 	public String getIn_reply_to_user_id_str(){
		return this.in_reply_to_user_id_str;
	}
	public void setIn_reply_to_user_id_str(String in_reply_to_user_id_str){
		this.in_reply_to_user_id_str = in_reply_to_user_id_str;
	}
 	public String getLang(){
		return this.lang;
	}
	public void setLang(String lang){
		this.lang = lang;
	}
 	public String getPlace(){
		return this.place;
	}
	public void setPlace(String place){
		this.place = place;
	}
 	public boolean getPossibly_sensitive(){
		return this.possibly_sensitive;
	}
	public void setPossibly_sensitive(boolean possibly_sensitive){
		this.possibly_sensitive = possibly_sensitive;
	}
 	public Number getRetweet_count(){
		return this.retweet_count;
	}
	public void setRetweet_count(Number retweet_count){
		this.retweet_count = retweet_count;
	}
 	public boolean getRetweeted(){
		return this.retweeted;
	}
	public void setRetweeted(boolean retweeted){
		this.retweeted = retweeted;
	}
 	public String getSource(){
		return this.source;
	}
	public void setSource(String source){
		this.source = source;
	}
 	public String getText(){
		return this.text;
	}
	public void setText(String text){
		this.text = text;
	}
 	public boolean getTruncated(){
		return this.truncated;
	}
	public void setTruncated(boolean truncated){
		this.truncated = truncated;
	}
 	public User getUser(){
		return this.user;
	}
	public void setUser(User user){
		this.user = user;
	}
}
