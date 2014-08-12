
package org.antczak.hadoop.holidays.tweet;

import java.util.List;

public class Hashtags{
   	private List<String> indices;
   	private String text;

 	public List<String> getIndices(){
		return this.indices;
	}
	public void setIndices(List<String> indices){
		this.indices = indices;
	}
 	public String getText(){
		return this.text;
	}
	public void setText(String text){
		this.text = text;
	}
}
