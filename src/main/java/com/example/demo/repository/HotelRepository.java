package com.example.demo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Hotel;

/**
 * ホテルを検索するリポジトリー.
 * 
 * @author hiranoyuusuke
 *
 */
@Repository
public class HotelRepository {
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	private static final RowMapper<Hotel> HOTEL_ROW_MAPPER = (rs, i) -> {
		Hotel hotel = new Hotel();
		hotel.setId(rs.getInt("id"));
		hotel.setAreaName(rs.getString("area_name"));
		hotel.setHotelName(rs.getString("hotel_name"));
		hotel.setAderss(rs.getString("address"));
		hotel.setNearestStation(rs.getString("nearest_station"));
		hotel.setPrice(rs.getInt("price"));
		hotel.setParking(rs.getString("parking"));
		return hotel;
	};
	
	/**
	 * リクエストパラメーターで渡ってきたprice以下のホテルを検索.
	 * 
	 * @param hopePrice ホテルの値段
	 * @return　price <= :price のホテル名
	 */
	public List<Hotel> findBypriceLessThanPrice(Integer hopePrice){
		
		System.out.println(hopePrice);
		String sql = "SELECT id,area_name,hotel_name,address,nearest_station,price,parking FROM hotels WHERE price <= :price";
		
		SqlParameterSource param = new MapSqlParameterSource().addValue("price", hopePrice);		
		
		List<Hotel> hotelList =  template.query(sql, param, HOTEL_ROW_MAPPER);
		
		return hotelList;
		
	}
	
	public List<Hotel> findAllHotel() {
		String sql = "SELECT id,area_name,hotel_name,address,nearest_station,price,parking FROM hotels";
		
		  List<Hotel> hotelAllList =  template.query(sql, HOTEL_ROW_MAPPER);
		
		return hotelAllList;
		
	}
	
	
}
