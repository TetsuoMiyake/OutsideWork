package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.Account;

@Mapper
public interface LoginMapper {

	//USERテーブルからユーザ名とパスワードを取得。
	public Account findAccount(String name);
}
