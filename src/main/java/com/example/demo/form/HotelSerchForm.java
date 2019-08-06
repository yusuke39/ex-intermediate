package com.example.demo.form;

/**
 * リクエストパラメーターを受け取る.
 * 
 * @author hiranoyuusuke
 *
 */
public class HotelSerchForm {
	
	/**値段*/
	private String price;

	@Override
	public String toString() {
		return "HotelSerchForm [price=" + price + "]";
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	
}
