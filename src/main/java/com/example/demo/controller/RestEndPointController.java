package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.EmployeeInformation;
import com.example.demo.service.DashboardService;

@RestController
public class RestEndPointController {
	@Autowired DashboardService dashBoardService;
	
	@RequestMapping("/employees")
	public List<EmployeeInformation> getAllEmp() {
		return dashBoardService.getAllEmployee() ;
	}
	
	@RequestMapping(value="/employee/add", method= RequestMethod.POST)
	public String saveEmployeeInfo(@RequestBody EmployeeInformation employeeInformation) {
		if (dashBoardService.addEmployee(employeeInformation)!=null) {
			return "Employee data saved successfully";
		} else {
			return null;
		}
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="/employee/delete")
	public String deleteEmp(@RequestParam(name="empId", required=true) Long id) {
		try {
			dashBoardService.deleteEmployee(dashBoardService.getEmployeeById(id));
			return "Employee deleted";
		} catch (Exception e) {
			return "error";
		}
		
		
	}
	
	
}
