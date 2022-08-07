package com.example.demo.form;

import java.io.Serializable;
import java.util.Date;

public class CreateMatchScheduleForm implements Serializable {
	private Date dt;
	private int team_id;

	public Date getDt() {
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
