package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.service.DashboardService;

@Controller
public class ThymeleafController {
	@Autowired DashboardService dashboardService;
	
	@GetMapping("/charts")
	public String getChartDetail(Model model) {
		/**
		 * Populate Company Revenue data
		 */
		model.addAttribute("cr", dashboardService.getTodayRevenueDash());
		model.addAttribute("bc", dashboardService.getBestCategoryDash());
		model.addAttribute("or", dashboardService.getOrdersReceivedDash());
		return "/charts";
	}
	
	@GetMapping("/")
	public String getDashDetail(Model model) {
		/**
		 * Populate Company Revenue data
		 */
		model.addAttribute("cr", dashboardService.getTodayRevenueDash());
		model.addAttribute("bc", dashboardService.getBestCategoryDash());
		model.addAttribute("ei", dashboardService.getAllEmployee());
		return "/index";
	}
}
