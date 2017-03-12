package com.binay.taskproject.model;

public class Projections{
	private String p25;
	private String p50;
	private String p75;

	public void setP25(String p25){
		this.p25 = p25;
	}

	public String getP25(){
		return p25;
	}

	public void setP50(String p50){
		this.p50 = p50;
	}

	public String getP50(){
		return p50;
	}

	public void setP75(String p75){
		this.p75 = p75;
	}

	public String getP75(){
		return p75;
	}

	@Override
 	public String toString(){
		return 
			"Projections{" + 
			"p25 = '" + p25 + '\'' + 
			",p50 = '" + p50 + '\'' + 
			",p75 = '" + p75 + '\'' + 
			"}";
		}
}
