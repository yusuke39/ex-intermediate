package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.Team;
import com.example.demo.service.TeamService;



/**
 * チームを表示検索するコントローラー．
 * 
 * @author hiranoyuusuke
 *
 */
@Controller
@RequestMapping("")
public class TeamController {
	
	@Autowired
	private TeamService service;

	
	/**
	 * チーム情報を全権取得.
	 * 
	 * @return チーム名一覧表示
	 */
	@RequestMapping("")
	public String allTeam(Model model) {
		List<Team> teamList = service.findAllTeam();
		
		
		model.addAttribute("teamList", teamList);
		
		return "allTeam";
	}
	
	/**
	 * チーム情報を１件取得.
	 * 
	 * @param id チームID
	 * @param model リクエストパラメーター
	 * @return　チーム詳細表示
	 */
	@RequestMapping("/teamDetail")
	public String detail(Integer id, Model model) {
		Team team = service.findTeam(id);
		model.addAttribute("team", team);
		return "teamDetail";
	}
	
	
}
