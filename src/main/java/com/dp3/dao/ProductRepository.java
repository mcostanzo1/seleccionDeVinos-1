package com.dp3.dao;

import com.dp3.domain.Price;
import com.dp3.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.Date;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
