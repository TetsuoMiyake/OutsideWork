package com.example.demo.form;

import java.io.Serializable;

public class UpdateHitForm implements Serializable {
	private Long id;

	private String content;

	private byte bat;

	private byte active;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public byte getActive() {
		return active;
	}

	public void setActive(byte active) {
		this.active = active;
	}

	public byte getBat() {
		return bat;
	}

	public void setBat(byte bat) {
		this.bat = bat;
	}

}
