package com.example.demo.domain;

public class Hotel {

	/**ID*/
	private Integer id;
	/**エリア*/
	private String areaName;
	/**ホテルネーム*/
	private String hotelName;
	/**住所*/
	private String aderss;
	/**最寄駅*/
	private String nearestStation;
	/**値段*/
	private Integer price;
	/**パーキング*/
	private String parking;

	public Hotel() {}

	public Hotel(Integer id, String areaName, String hotelName, String aderss, String nearestStation, Integer price,
			String parking) {
		super();
		this.id = id;
		this.areaName = areaName;
		this.hotelName = hotelName;
		this.aderss = aderss;
		this.nearestStation = nearestStation;
		this.price = price;
		this.parking = parking;
	}

	@Override
	public String toString() {
		return "Hotel [id=" + id + ", areaName=" + areaName + ", hotelName=" + hotelName + ", aderss=" + aderss
				+ ", nearestStation=" + nearestStation + ", price=" + price + ", parking=" + parking + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getAderss() {
		return aderss;
	}

	public void setAderss(String aderss) {
		this.aderss = aderss;
	}

	public String getNearestStation() {
		return nearestStation;
	}

	public void setNearestStation(String nearestStation) {
		this.nearestStation = nearestStation;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getParking() {
		return parking;
	}

	public void setParking(String parking) {
		this.parking = parking;
	}
	
	
	
	

}
