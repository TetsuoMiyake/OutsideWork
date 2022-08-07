package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Hit;
import com.example.demo.form.UpdateHitForm;
import com.example.demo.mapper.HitMapper;

@Service
public class EditHitService {

	@Autowired
	private HitMapper mapper;

	@Transactional
	public Hit editId(Long id) {
		return mapper.editId(id);
	}

	@Transactional
	public UpdateHitForm setForm(Hit hit) {
		UpdateHitForm updateForm = new UpdateHitForm();
		updateForm.setId(hit.getId());
		updateForm.setContent(hit.getContent());
		updateForm.setActive(hit.getActive());
		updateForm.setBat(hit.getBat());
		updateForm.setMatch_id(hit.getMatch_id());

		return updateForm;
	}

	@Transactional
	public int update(UpdateHitForm form) {
		Hit entity = new Hit();
		entity.setId(form.getId());
		entity.setContent(form.getContent());
		entity.setActive(form.getActive());
		entity.setBat(form.getBat());
		entity.setMatch_id(form.getMatch_id());

		return mapper.update(entity);
	}

}
