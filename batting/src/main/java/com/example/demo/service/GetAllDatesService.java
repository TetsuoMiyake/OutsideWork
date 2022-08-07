package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.MatchSchedule;
import com.example.demo.mapper.DateMapper;

@Service
public class GetAllDatesService {

	@Autowired
	private DateMapper mapper;

	@Transactional
	public List<MatchSchedule> getAllDates() {
		return mapper.allDate();
	}
}
