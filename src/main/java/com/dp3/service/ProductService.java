package com.dp3.service;

import com.dp3.dao.PriceRepository;
import com.dp3.dao.ProductRepository;
import com.dp3.domain.OrderDetail;
import com.dp3.domain.Product;
import com.dp3.web.wrapper.ProductWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    public void addStock(ProductWrapper wrapper) {
        Product prod = wrapper.getProduct();
        Integer finalStock = prod.getQuantityOnStock();
        finalStock += prod.getQuantityPerBox() * wrapper.getBoxQuantity();
        finalStock += wrapper.getUnitQuantity();
        prod.setQuantityOnStock(finalStock);
        productRepository.save(prod);
    }

    @Transactional
    public void discountStock(OrderDetail detail) {
        Product prod = detail.getProduct();
        prod.setQuantityOnStock(prod.getQuantityPerBox()-detail.getQuantity());
        productRepository.save(prod);
    }

    @Transactional
    public void returnStock(OrderDetail detail) {
        Product prod = detail.getProduct();
        prod.setQuantityOnStock(prod.getQuantityPerBox()+detail.getQuantity());
        productRepository.save(prod);
    }
}
