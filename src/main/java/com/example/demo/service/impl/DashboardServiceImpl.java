package com.example.demo.service.impl;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.*;
import com.example.demo.repositories.*;
import com.example.demo.service.DashboardService;

@Service
public class DashboardServiceImpl implements DashboardService {
	@Autowired private CompanyRevenueRepository companyRevenueRepository;
	
	@Autowired private EmployeeInformationRepository employeeInformationRepository;
	
	@Autowired private OrderCollectionStatusRepository orderCollectionStatusRepository;
	
	@Autowired private OrderRecievedRepository orderRecievedRepository;
	
	@Autowired private ProductCategoryRepository productCategoryRepository;
	
	@Override
	public HashMap<String, Object> getTodayRevenueDash() {
		HashMap<String, Object> populateCompanyRevenue = new HashMap<>();
		List<CompanyRevenue> companyRevenueList = companyRevenueRepository.findAll();
		
		/**
		 * Build labels and revenue
		 */
		List<String> label = new ArrayList<>();
		List<String> _revenue = new ArrayList<>();
		double totalMargin = 0;
		double totalExpense = 0;
		double totalRevenue = 0;
		
		Locale locale = new Locale("en", "US");
		NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
		
		for (CompanyRevenue companyRevenue : companyRevenueList ) {
			label.add(companyRevenue.get_month());
			_revenue.add(String.valueOf(companyRevenue.getRevenue()));
			totalExpense += companyRevenue.getExpense();
			totalMargin += companyRevenue.getMargins();
			totalRevenue += companyRevenue.getRevenue(); 
		}
		
		populateCompanyRevenue.put("crLabels", label.toString());
		populateCompanyRevenue.put("crRevenue", _revenue.toString());
		populateCompanyRevenue.put("totalExpense", currencyFormatter.format(totalExpense));
		populateCompanyRevenue.put("totalMargin", currencyFormatter.format(totalMargin));
		populateCompanyRevenue.put("totalRevenue", currencyFormatter.format(totalRevenue));
		
		
		return populateCompanyRevenue;
	}

	@Override
	public HashMap<String, Object> getBestCategoryDash() {
		HashMap<String, Object> populateBestCategoryDash = new HashMap<>();
		List<ProductCategory> productCategoryList = productCategoryRepository.findByBestCategory(true);
		
		List<String> label = new ArrayList<>();
		List<String> _percentage = new ArrayList<>();
		
		for (ProductCategory productCategory : productCategoryList ) {
			label.add(productCategory.getCategoryName());
			_percentage.add(String.valueOf(productCategory.getPercentage()));
		}
		
		populateBestCategoryDash.put("bcLabels", label.toString());
		populateBestCategoryDash.put("bcPercentage", _percentage.toString());
		return populateBestCategoryDash;
	}
	
	
	@Override
	public HashMap<String, Object> getOrdersReceivedDash() {
		HashMap<String, Object> orderRecievedDash = new HashMap<>();
		List<OrderRecieved> OrdersRecieved = orderRecievedRepository.findAll();
		
		List<String> label = new ArrayList<>();
		List<String> _ordersReceived = new ArrayList<>();
		
		for (OrderRecieved orderRecieved : OrdersRecieved ) {
			label.add(orderRecieved.getDateReceived());
			_ordersReceived.add(String.valueOf(orderRecieved.getOrderReceived()));
		}
		
		orderRecievedDash.put("orLabels", label.toString());
		orderRecievedDash.put("orOrders", _ordersReceived.toString());
		return orderRecievedDash;
	}
	
	@Override
	public List<ProductCategory> getBestCategory() {
		return productCategoryRepository.findByBestCategory(true);
	}
	
	@Override
	public List<OrderRecieved> getAllOrderRecieved() {
		return orderRecievedRepository.findAll() ;
	}

	@Override
	public List<OrderCollectionStatus> getOrderCollection() {
		// TODO Auto-generated method stub
		return orderCollectionStatusRepository.findAll();
	}

	@Override
	public List<EmployeeInformation> getAllEmployee() {
		// TODO Auto-generated method stub
		return employeeInformationRepository.findAll();
	}

	@Override
	public EmployeeInformation addEmployee(EmployeeInformation employeeInformation) {
		return employeeInformationRepository.save(employeeInformation);
	}

	@Override
	public EmployeeInformation updateEmployee(EmployeeInformation employeeInformation) {
		return employeeInformationRepository.save(employeeInformation) ;
	}

	@Override
	public void deleteEmployee(EmployeeInformation employeeInformation) {
		employeeInformationRepository.delete(employeeInformation);
	}

	@Override
	public EmployeeInformation getEmployeeById(Long id) {
		return employeeInformationRepository.getById(id) ;
	}

}
