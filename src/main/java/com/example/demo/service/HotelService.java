package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.Hotel;
import com.example.demo.repository.HotelRepository;

/**
 * 検索するリポジトリーのメソッドを呼ぶ.
 * 
 * @author hiranoyuusuke
 *
 */
@Service
@Transactional
public class HotelService {
	
	@Autowired
	private HotelRepository repository;
	
	/**
	 * ホテル検索.
	 * 
	 * @param hopePrice　希望の値段
	 * @return ホテル情報
	 */
	public List<Hotel> findHotelName(String hopePrice){
		
		if(hopePrice.equals("")) {
			return repository.findAllHotel();
		} else {
			int hopeHotelPrice = Integer.parseInt(hopePrice);
			return repository.findBypriceLessThanPrice(hopeHotelPrice);
		}
	}

}
