package com.example.demo.entity;

import java.util.Date;

public class MatchSchedule {
	private Long id;
	private Date dt;
	private int team_id;

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

}
