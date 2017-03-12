package com.binay.taskproject.model;

public class Investment{
	private Message msg;
	private int code;
	private String status;

	public void setMsg(Message msg){
		this.msg = msg;
	}

	public Message getMsg(){
		return msg;
	}

	public void setCode(int code){
		this.code = code;
	}

	public int getCode(){
		return code;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"Investment{" + 
			"msg = '" + msg + '\'' + 
			",code = '" + code + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}
