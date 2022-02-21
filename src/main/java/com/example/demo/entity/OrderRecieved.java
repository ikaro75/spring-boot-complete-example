package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="OrderRecieved", schema ="ecomDashApp")

public class OrderRecieved {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native",strategy="native")
	private Long id;
	
	private int orderReceived;
	private String dateReceived;
	
	public int getOrderReceived() {
		return orderReceived;
	}
	public void setOrderReceived(int orderReceived) {
		this.orderReceived = orderReceived;
	}
	public String getDateReceived() {
		return dateReceived;
	}
	public void setDateReceived(String dateReceived) {
		this.dateReceived = dateReceived;
	}
	
	
}
