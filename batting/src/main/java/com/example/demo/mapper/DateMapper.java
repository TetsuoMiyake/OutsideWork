package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.MatchSchedule;
import com.example.demo.entity.Hit;



@Mapper
public interface DateMapper {
	List<MatchSchedule>  allDate();

	MatchSchedule findById(Long id);

	List<Hit> allHit(Long id);

	int create(MatchSchedule entity);
}
