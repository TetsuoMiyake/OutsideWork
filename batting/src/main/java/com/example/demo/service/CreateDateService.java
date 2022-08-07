package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.MatchSchedule;
import com.example.demo.form.CreateDateForm;
import com.example.demo.mapper.DateMapper;

@Service
public class CreateDateService {

	@Autowired
	private DateMapper mapper;

	@Transactional
	public int create(CreateDateForm form) {
		MatchSchedule entity = new MatchSchedule();
		entity.setDt(form.getDt());
		entity.setTeam_id(form.getTeam_id());

		return mapper.create(entity);
	}

}
