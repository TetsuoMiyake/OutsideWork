package com.example.demo.form;

import java.io.Serializable;

public class CreateHitForm implements Serializable {
	private String content;
	private byte active;
	private byte bat;

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
