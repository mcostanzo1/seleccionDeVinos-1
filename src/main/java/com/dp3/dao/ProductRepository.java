package com.dp3.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.dp3.domain.Product;

public interface ProductRepository extends MongoRepository<Product, String> {

}
