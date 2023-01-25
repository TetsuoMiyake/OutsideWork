package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.MemberRegistrationEntity;
import com.example.demo.mapper.RegisterMemberMapper;

@Service
@Transactional
public class RegisterMemberService {

	@Autowired
	RegisterMemberMapper registerMemberMapper;

	@Autowired
	PasswordEncoder passwordEncoder;

	/**
	 * 会員情報をDBに登録。
	 */
	public void registerMember(MemberRegistrationEntity entity) {

		//パスワードをハッシュ化して、insertする時の引数にセット。
		entity.setPassword(passwordEncoder.encode(entity.getPassword()));

		//会員情報をUSERテーブルにinsert。
		registerMemberMapper.insertMemberInfo(entity);
	}
}

