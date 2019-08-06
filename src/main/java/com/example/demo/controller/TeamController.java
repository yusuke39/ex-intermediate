package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.Team;
import com.example.demo.service.TeamService;



@Controller
@RequestMapping("")
public class TeamController {
	
	@Autowired
	private TeamService service;
	
	@Autowired
	private HttpSession session;

	
	@RequestMapping("")
	public String allTeam() {
		List<Team> teamList = service.findAllTeam();
		
		
		session.setAttribute("teamList", teamList);
		
		return "allTeam";
	}
	
	@RequestMapping("/teamDetail")
	public String detail(Integer id, Model model) {
		Team team = service.findTeam(id);
		model.addAttribute("team", team);
		return "teamDetail";
	}
	
	
}
