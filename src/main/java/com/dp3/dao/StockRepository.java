package com.dp3.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.dp3.domain.Stock;
import sun.jvm.hotspot.jdi.IntegerTypeImpl;

@Repository
public interface StockRepository extends MongoRepository<Stock, String> {

}
