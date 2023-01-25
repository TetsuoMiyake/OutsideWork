package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.MemberRegistrationEntity;

@Mapper
public interface RegisterMemberMapper{
	public void insertMemberInfo(MemberRegistrationEntity entity);
}