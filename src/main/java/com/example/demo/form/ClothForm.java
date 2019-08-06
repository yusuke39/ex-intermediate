package com.example.demo.form;

/**
 * 送られてきたリクエストパラメーターを受け取る.
 * 
 * @author hiranoyuusuke
 *
 */
public class ClothForm {

	/** 性別 */
	private String gender;
	/** 色 */
	private String color;

	public ClothForm() {}

	public ClothForm(String gender, String color) {
		super();
		this.gender = gender;
		this.color = color;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	

}
