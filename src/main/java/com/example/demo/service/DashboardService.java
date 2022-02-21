package com.example.demo.service;

import java.util.HashMap;
import java.util.List;

import com.example.demo.entity.CompanyRevenue;
import com.example.demo.entity.*;

public interface DashboardService {
	HashMap<String, Object> getTodayRevenueDash();
	HashMap<String, Object> getBestCategoryDash();
	HashMap<String, Object> getOrdersReceivedDash();
	List<ProductCategory> getBestCategory();
	List<OrderRecieved> getAllOrderRecieved();
	List<OrderCollectionStatus> getOrderCollection();
	List<EmployeeInformation> getAllEmployee();
	EmployeeInformation getEmployeeById(final Long id);
	EmployeeInformation addEmployee(EmployeeInformation employeeInformation);
	EmployeeInformation updateEmployee(EmployeeInformation employeeInformation);
	void deleteEmployee(EmployeeInformation employeeInformation);
}
