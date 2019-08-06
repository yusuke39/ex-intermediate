package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.Cloth;
import com.example.demo.repository.ClothRrepository;

/**
 * 洋服を検索する.
 * 
 * @author hiranoyuusuke
 *
 */
@Service
@Transactional
public class ClothService {
	
	@Autowired
	private ClothRrepository repository;
	
	/**
	 * 洋服を検索する.
	 * 
	 * @param cloth 洋服のオブジェクト（性別と色）
	 * @return 洋服の検索結果
	 */
	public List<Cloth> findCloth(Cloth cloth){
		return repository.findByCloth(cloth);
	}

}
