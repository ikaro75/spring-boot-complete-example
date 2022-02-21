package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Id;

public class KeyEntity {

	@Id
	@Column(name = "PK", unique=true)
	private String pk;

	public String getPk() {
		return pk;
	}

	public void setPk(String pk) {
		this.pk = pk;
	}

	
}
