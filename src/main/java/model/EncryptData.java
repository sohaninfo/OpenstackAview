package model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EncryptData  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@JsonProperty("data")
	private String data;

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	
}
