package com.dp3.web.controller;

import com.dp3.domain.BaseOfPriceList;
import com.dp3.domain.PriceList;
import com.dp3.service.PriceListService;
import com.lowagie.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;


@RestController
@RequestMapping("/lists")
@CrossOrigin("*")
public class PriceListController {

    @Autowired
    private PriceListService priceListService;

    @GetMapping("/")
    public ModelAndView getView(Model model){
        ModelAndView list = new ModelAndView("pricelist");
        model.addAttribute("priceList", new PriceList());
        model.addAttribute("lists", priceListService.findAll());
        return list;
    }

    @GetMapping("/baseOfPriceList")
    public List<BaseOfPriceList> getBaseOfPriceList(){
        return Arrays.asList(BaseOfPriceList.values());
    }

    @GetMapping("/all")
    public List<PriceList> getAllPriceLists(){
        return priceListService.findAll();
    }

    @PostMapping("/create")
    public ModelAndView createList(Model model, @ModelAttribute PriceList priceList){
        priceListService.createNewPriceList(priceList);
        model.addAttribute("lists", priceListService.findAll());
        return new ModelAndView("redirect:/lists/");
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PriceList> getPriceListByListCode(@PathVariable("id") Integer id){
        PriceList priceList = priceListService.findById(id);
        if (priceList==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(priceList, HttpStatus.OK);
        }
    }

    @PutMapping(value = "/edit/{id}")
    public ResponseEntity<PriceList> updatePriceList(@PathVariable("id") Integer id,
                                             @Valid @RequestBody PriceList priceList){
        return new ResponseEntity<>(HttpStatus.METHOD_NOT_ALLOWED);
    }

    @RequestMapping(value = "/delete/{id}")
    public ModelAndView deleteStock(Model model,@PathVariable("id") Integer id){
        priceListService.delete(id);
        return new ModelAndView("redirect:/lists/");
    }

    @GetMapping(value = "/printOrder", produces = "application/pdf")
    public ResponseEntity<byte[]> getPDF(@ModelAttribute PriceList priceList) throws DocumentException {
        return null;
    }

}

