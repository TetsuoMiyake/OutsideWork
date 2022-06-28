package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.Hit;

@Mapper
public interface HitMapper {
	List<Hit> findAll();

	int create(Hit entity);

	Hit editId(Long id);

	int allCount();

	int batCount();

	int activeCount();

	int update(Hit entity);

}
