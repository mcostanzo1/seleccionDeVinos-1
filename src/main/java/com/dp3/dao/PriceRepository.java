package com.dp3.dao;

import com.dp3.domain.Price;
import com.dp3.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PriceRepository extends JpaRepository<Price, PriceId>{
    List<Price> findByPriceIdProductAndPriceIdEffectiveDateLessThanEqualOrderByPriceIdEffectiveDateDesc(Product product, Date effectiveDate);

}
