package com.dp3.web.controller;

import com.dp3.dao.CellarRepository;
import com.dp3.dao.ProductRepository;
import com.dp3.domain.Cellar;
import com.dp3.domain.Product;
import com.dp3.domain.Wine;
import com.dp3.service.CellarService;
import com.dp3.service.ProductService;
import com.dp3.web.wrapper.ProductWrapper;
import com.dp3.web.wrapper.WineWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/products")
@CrossOrigin("*")
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private CellarService cellarService;

    @GetMapping("/")
    public ModelAndView getProducts(Model model){
        model.addAttribute("cellar", new Cellar());
        model.addAttribute("productWrapper", new ProductWrapper());
        model.addAttribute("wineWrapper", new WineWrapper());
        model.addAttribute("stockList", productService.findAll());
        model.addAttribute("cellars", cellarService.findAll());
        return new ModelAndView("stock");
    }

    @GetMapping("/all")
    public List<Product> getAllProducts(){
        return productService.findAll();
    }

    @PostMapping("/edit/")
    public ModelAndView editProduct(@ModelAttribute ProductWrapper wrapper) {
        productService.addStock(wrapper);
        return new ModelAndView("redirect:/products/all");
    }

    @PostMapping("/addStock")
    public ModelAndView addStock(@ModelAttribute ProductWrapper wrapper){
        if (wrapper.getProduct() != null) {
            productService.addStock(wrapper.getProduct(), wrapper.getFinalQuantity());
        }
        return new ModelAndView("redirect:/products/");
    }
}
