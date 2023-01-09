package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class MatchSchedule {
	private Long id;

	@DateTimeFormat(pattern="yyyy/MM/dd")
	@JsonFormat(pattern="yyyy/MM/dd")
	private Date dt;

	private int team_id;
	private String name;

	public Long id() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date dt() {
		return dt;
	}

	public void setDt(Date dt) {
		this.dt = dt;
	}

	public int getTeam_id() {
		return team_id;
	}

	public void setTeam_id(int team_id) {
		this.team_id = team_id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
