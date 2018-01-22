package com.dp3.service;

import com.dp3.dao.PriceRepository;
import com.dp3.dao.ProductRepository;
import com.dp3.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private PriceRepository priceRepository;


    public BigDecimal getEffectivePrice(Product product) {
        return priceRepository.findByPriceIdProductAndPriceIdEffectiveDateLessThanEqualOrderByPriceIdEffectiveDateDesc(product, new Date()).get(0).getPrice();
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }
}
