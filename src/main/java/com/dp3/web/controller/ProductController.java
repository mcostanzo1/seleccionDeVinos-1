package com.dp3.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {
	
	public ProductController() {
		
	}
	
	@GetMapping("/{id}")
	public void getProduct() {
		
	}
	
}
