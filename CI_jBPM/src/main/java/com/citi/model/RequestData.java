package com.citi.model;

import java.io.Serializable;

public class RequestData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	
	private  String application;
	
	
	public String getApplication() {
		return application;
	}
	public void setApplication(String application) {
		this.application = application;
	}
	
	
	public RequestData(String application) {
		// TODO Auto-generated constructor stub
		this.application = application;
	}
	
	public RequestData() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
