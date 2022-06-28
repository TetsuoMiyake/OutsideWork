package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Hit;
import com.example.demo.mapper.HitMapper;

@Service
public class GetAllHitsService {

	@Autowired
	private HitMapper mapper;

	@Transactional
	public List<Hit> getAllHits() {
		return mapper.findAll();
	}

	@Transactional
	public int getAllCount() {
		return mapper.allCount();
	}

	@Transactional
	public int getBatCount() {
		return mapper.batCount();
	}

	@Transactional
	public int getActiveCount() {
		return mapper.activeCount();
	}
}
