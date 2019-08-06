package com.example.demo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Cloth;

/**
 * 洋服を検索するリポジトリー.
 * 
 * @author hiranoyuusuke
 *
 */
@Repository
public class ClothRrepository {
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	private static final RowMapper<Cloth> CLOTH_ROW_MAPPER = (rs,i) -> {
		Cloth cloth = new Cloth();
		cloth.setId(rs.getInt("id"));
		cloth.setCategory(rs.getString("category"));
		cloth.setGenre(rs.getString("genre"));
		cloth.setGender(rs.getInt("gender"));
		cloth.setColor(rs.getString("color"));
		cloth.setPrice(rs.getInt("price"));
		cloth.setSize(rs.getString("size"));
		return cloth;
	};
	
	/**
	 * 洋服を検索する.
	 * 
	 * @param cloth 洋服のオブジェクト（性別と色）
	 * @return　洋服の検索結果
	 */
	public List<Cloth> findByCloth(Cloth cloth){
		String sql = "SELECT id,category,genre,gender,color,price,size FROM clothes WHERE gender = :gender AND color = :color";
		
		SqlParameterSource param = new MapSqlParameterSource().addValue("gender", cloth.getGender()).addValue("color", cloth.getColor());
		
		List<Cloth> clothList = template.query(sql, param, CLOTH_ROW_MAPPER);
		
		return clothList;
	}

}
