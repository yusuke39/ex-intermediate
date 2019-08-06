package com.example.demo.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.Hotel;
import com.example.demo.form.HotelSerchForm;
import com.example.demo.service.HotelService;


/**
 * ホテル検索を操作するコントローラー.
 * 
 * @author hiranoyuusuke
 *
 */
@Controller
@RequestMapping("/hotel")
public class HtoelController {
	
	@Autowired
	private HotelService service;
	
	@ModelAttribute
	public HotelSerchForm setUp() {
		return new HotelSerchForm();
		}
	
	
	/**
	 * ホテル検索画面の表示.
	 * 
	 * @return
	 */
	@RequestMapping("")
	public String hotelSerch() {
		return "hotelSerch";
	}
	
	@RequestMapping("/serch")
	public String serch(HotelSerchForm form, Model model) {
		List<Hotel> hotelList = service.findHotelName(form.getPrice());
		model.addAttribute("hotelList", hotelList);
		return "/hotelSerch";
	}
	
	

}
