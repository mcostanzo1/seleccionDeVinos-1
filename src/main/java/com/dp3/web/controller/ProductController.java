package com.dp3.web.controller;

import com.dp3.dao.CellarRepository;
import com.dp3.dao.ProductRepository;
import com.dp3.domain.Cellar;
import com.dp3.domain.Product;
import com.dp3.domain.Wine;
import com.dp3.web.wrapper.WineWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/products")
@CrossOrigin("*")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CellarRepository cellarRepository;

    @GetMapping("/all")
    public ModelAndView getAllProducts(Model model){
        model.addAttribute("cellar", new Cellar());
        model.addAttribute("wineWrapper", new WineWrapper());
        model.addAttribute("stockList", productRepository.findAll());
        model.addAttribute("cellars", cellarRepository.findAll());
        return new ModelAndView("stock");
    }

}
