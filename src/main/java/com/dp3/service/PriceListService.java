package com.dp3.service;

import com.dp3.dao.PriceListRepository;
import com.dp3.domain.BaseOfPriceList;
import com.dp3.domain.PriceList;
import com.dp3.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Service
public class PriceListService {

    @Autowired
    private PriceListRepository priceListRepository;
    @Autowired
    private ProductService productService;

    private static final BigDecimal TOTAL_PORCENTAGE = BigDecimal.valueOf(100);

    @Transactional
    public PriceList createNewPriceList(PriceList newPriceList){
        List<Product> products = productService.findAll();
        for (Product product: products) {
            newPriceList.addProductToPriceList(product, newPriceList.getBase() == BaseOfPriceList.ORIGINAL_PRICE ?
                    getPriceFromOriginalPrice(product, newPriceList) : getPriceFromOtherList(product, newPriceList.getBasePriceList()));
        }
        return priceListRepository.save(newPriceList);
    }

    private BigDecimal getPriceFromOtherList(Product product, PriceList basePriceList) {
        return getProductPrice(product, basePriceList)
                .multiply(convertPorcentageToMultiplier(basePriceList.getDiscountPercentage()))
                .setScale(2, RoundingMode.HALF_EVEN);
    }

    private BigDecimal getPriceFromOriginalPrice(Product product, PriceList basePriceList) {
        return productService.getEffectivePrice(product)
                .multiply(convertPorcentageToMultiplier(basePriceList.getDiscountPercentage()))
                .setScale(2, RoundingMode.HALF_EVEN);
    }

    private BigDecimal convertPorcentageToMultiplier(BigDecimal porcentage) {
        return TOTAL_PORCENTAGE.subtract(porcentage).divide(TOTAL_PORCENTAGE).setScale(2, RoundingMode.HALF_EVEN);
    }

    private BigDecimal getProductPrice(Product product, PriceList priceList) {
        return priceList.getProductPrice().get(product);
    }

    public List<PriceList> findAll() {
        return priceListRepository.findAll();
    }

    public void delete(Integer id) {
        priceListRepository.delete(id);
    }

    public PriceList findById(Integer id) {
        return priceListRepository.findOne(id);
    }
}
