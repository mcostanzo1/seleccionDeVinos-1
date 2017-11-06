package com.dp3.web.controller;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dp3.dao.ProductRepository;
import com.dp3.domain.Product;

@Controller()
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductRepository productRepository;
	
	public ProductController(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	@GetMapping(path="/all/", produces="application/json")
	@ResponseBody
	public List<Product> getProducts() {
		return productRepository.findAll();
	}
	
	@GetMapping(path="/{id}", produces="application/json")
	@ResponseBody
	public Product getProduct(@PathVariable BigInteger id) {
		return productRepository.findOne(id);
	}
	
	@PostMapping("/")
	public void insertProduct(@RequestBody Product product) {
		
	}
	
}
