package com.dp3.web.controller;

<<<<<<< HEAD
=======
import java.math.BigInteger;
>>>>>>> c885f0c2656b8ce59f835f24e12ac74303215185
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
=======
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
>>>>>>> c885f0c2656b8ce59f835f24e12ac74303215185

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
	
<<<<<<< HEAD
	@GetMapping()
	public ModelAndView getProductView() {
		return new ModelAndView("products");
	}
	
=======
>>>>>>> c885f0c2656b8ce59f835f24e12ac74303215185
	@GetMapping(path="/all/", produces="application/json")
	@ResponseBody
	public List<Product> getProducts() {
		return productRepository.findAll();
	}
	
<<<<<<< HEAD
//	@GetMapping(path="/{id}", produces="application/json")
//	@ResponseBody
//	public Product getProduct(@PathVariable BigInteger id) {
//		return productRepository.findOne(id);
//	}
	
	@PostMapping("/")
	public Product insertProduct(@RequestBody Product product) {
		return productRepository.insert(product);
	}
	
	@PutMapping("/")
	public Product updateProduct(@RequestBody Product product) {
		return productRepository.save(product);
=======
	@GetMapping(path="/{id}", produces="application/json")
	@ResponseBody
	public Product getProduct(@PathVariable BigInteger id) {
		return productRepository.findOne(id);
	}
	
	@PostMapping("/")
	public void insertProduct(@RequestBody Product product) {
		
>>>>>>> c885f0c2656b8ce59f835f24e12ac74303215185
	}
	
}
