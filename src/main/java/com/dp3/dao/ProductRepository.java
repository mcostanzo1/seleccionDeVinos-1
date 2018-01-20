package com.dp3.dao;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dp3.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, BigInteger> {

}
