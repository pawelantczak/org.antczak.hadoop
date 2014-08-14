
package org.antczak.hadoop.holidays.tweet;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Thumb{
   	private Number h;
   	private String resize;
   	private Number w;

 	public Number getH(){
		return this.h;
	}
	public void setH(Number h){
		this.h = h;
	}
 	public String getResize(){
		return this.resize;
	}
	public void setResize(String resize){
		this.resize = resize;
	}
 	public Number getW(){
		return this.w;
	}
	public void setW(Number w){
		this.w = w;
	}
}
