package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.Cloth;
import com.example.demo.form.ClothForm;
import com.example.demo.service.ClothService;

/**
 * 服を検索するコントローラー.
 * 
 * @author hiranoyuusuke
 *
 */
@Controller
@RequestMapping("/cloth")
public class ClothController {
	
	@Autowired
	private ClothService service;
	
	@ModelAttribute
	public ClothForm setUp(ClothForm form) {
		return new ClothForm();
	}
	
	/**
	 * TOP画面表示
	 * 
	 * @return　検索TOP画面表示
	 */
	@RequestMapping("")
	public String cloth() {
		return "cloth";
	}
	
	/**
	 * 洋服を検索して、画面に結果表示.
	 * 
	 * @param form 受け取ったリクエストパラメーター.
	 * @param model リクエストスコープ
	 * @return TOP画面
	 */
	@RequestMapping("/clothSearch")
	public String clothSearch(ClothForm form, Model model) {
		Cloth cloth = new Cloth();
		cloth.setGender(Integer.parseInt(form.getGender()));
		cloth.setColor(form.getColor());
		List<Cloth> clothList = service.findCloth(cloth);
		model.addAttribute("clothList" , clothList);
		return "/cloth";
	}

}
