package com.example.demo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Team;

/**
 * チーム情報を検索するrepository
 * 
 * @author hiranoyuusuke
 *
 */
@Repository
public class TeamRepository {
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	
	private static final RowMapper<Team> TEAM_ROW_MAPPER = (rs, i) -> {
		Team team = new Team();
		team.setId(rs.getInt("id"));
		team.setLeagueName(rs.getString("league_name"));
		team.setTeamName(rs.getString("team_name"));
		team.setHeadquarters(rs.getString("headquarters"));
		team.setInauguration(rs.getString("inauguration"));
		team.setHistory(rs.getString("history"));
		return team;
	};
	
	/**
	 * チーム情報全件検索.
	 * 
	 * @return 全件のチーム情報
	 */
	public List<Team> findAll(){
		String findAllSql = "SELECT id, league_name, team_name, headquarters, inauguration, history FROM teams";
		
		List<Team> teamList = template.query(findAllSql, TEAM_ROW_MAPPER);
		
		return teamList;
		
	}
	
	/**
	 * 各チームの情報取得（１件分）
	 * 
	 * @param id チームID
	 * @return　チーム情報（１件分）
	 */
	public Team load(Integer id) {
		String sql = "SELECT id, league_name, team_name, headquarters, inauguration, history FROM teams WHERE id = :id";
		
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
		
		Team team = template.queryForObject(sql, param, TEAM_ROW_MAPPER);
		
		return team;
	}
}
