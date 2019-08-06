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
	
	
	public List<Team> findAllTeam() {
		return repository.findAll();
	}
	
	public Team findTeam(Integer id) {
		return repository.load(id);
	}

}
