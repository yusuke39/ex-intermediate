package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.Team;
import com.example.demo.repository.TeamRepository;

@Service
@Transactional
public class TeamService {
	
	@Autowired
	private TeamRepository repository;
	
	
	/**
	 * チーム情報全件検索.
	 * 
	 * @return　全チーム情報
	 */
	public List<Team> findAllTeam() {
		return repository.findAll();
	}
	
	/**
	 * チーム情報１件検索.
	 * 
	 * @param id チームID
	 * @return　チーム情報
	 */
	public Team findTeam(Integer id) {
		return repository.load(id);
	}

}
