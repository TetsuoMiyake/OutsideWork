package com.example.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Team;
import com.example.demo.mapper.TeamMapper;

@Service
public class GetAllTeamsService {
	@Autowired
	private TeamMapper mapper;

	@Transactional
	public List<Team> getAllTeams() {
		return mapper.findAll();
	}

}
