package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="CompanyRevenue", schema ="ecomDashApp")
public class CompanyRevenue {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native",strategy="native")
	private Long id;
	
	@Column(name="Revenue_Month", nullable = false)
	private String _month;
	
	@Column(name="revenue", nullable = false)
	private double revenue;
	
	@Column(name="expense")
	private double expense;
	
	@Column(name="margins")
	private double margins;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String get_month() {
		return _month;
	}
	public void set_month(String _month) {
		this._month = _month;
	}
	public double getRevenue() {
		return revenue;
	}
	public void setRevenue(double revenue) {
		this.revenue = revenue;
	}
	public double getExpense() {
		return expense;
	}
	public void setExpense(double expense) {
		this.expense = expense;
	}
	public double getMargins() {
		return margins;
	}
	public void setMargins(double margins) {
		this.margins = margins;
	}
	
	
}
