
package org.antczak.hadoop.wordcount.tweet;

import java.util.List;

public class Hashtags{
   	private List<Indices> indices;
   	private String text;

 	public List<Indices> getIndices(){
		return this.indices;
	}
	public void setIndices(List<Indices> indices){
		this.indices = indices;
	}
 	public String getText(){
		return this.text;
	}
	public void setText(String text){
		this.text = text;
	}
}
