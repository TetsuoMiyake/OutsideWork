package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Hit;
import com.example.demo.form.CreateHitForm;
import com.example.demo.mapper.HitMapper;

@Service
public class CreateHitService {

	@Autowired
	private HitMapper mapper;

	@Transactional
	public int create(CreateHitForm form) {
		Hit entity = new Hit();
		entity.setContent(form.getContent());
		entity.setActive(form.getActive());
		entity.setBat(form.getBat());

		return mapper.create(entity);
	}

}
