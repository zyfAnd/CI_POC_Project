package com.citi.model;

import java.io.Serializable;

/**
 * 需要序列化 
 * @author yanfu
 *
 */
public class InputData  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String applicationId;
	private String stage;
	
	
	
	public InputData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getApplicationId() {
		return applicationId;
	}
	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}
	public String getStage() {
		return stage;
	}
	public void setStage(String stage) {
		this.stage = stage;
	}
	public InputData(String applicationId, String stage) {
		super();
		this.applicationId = applicationId;
		this.stage = stage;
	}
	@Override
	public String toString() {
		return "InputData [applicationId=" + applicationId + ", stage=" + stage + "]";
	}
	
	
	
	
	
}
