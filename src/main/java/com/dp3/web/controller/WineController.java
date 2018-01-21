package com.dp3.web.controller;

import com.dp3.domain.Wine;
import com.dp3.exceptions.CellarNotFoundException;
import com.dp3.exceptions.WineNotFoundException;
import com.dp3.service.WineService;
import com.dp3.web.wrapper.WineWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/wine")
@CrossOrigin("*")
public class WineController {

    @Autowired
    private WineService wineService;

    @GetMapping("/all")
    public List<Wine> getAllWines(){
        return wineService.getAllWines();
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<Wine> getWineByWineName(@PathVariable("id") Integer id) {
        Wine wine = wineService.findById(id);
        if(wine == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(wine, HttpStatus.OK);
        }
    }

    @PostMapping("/create")
    public ModelAndView createWine(Model model, @ModelAttribute WineWrapper wrapper) throws CellarNotFoundException {
        wineService.createWine(wrapper);
        return new ModelAndView("redirect:/products/all");
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Wine> updateWine(@PathVariable("id") Integer id,
                                           @RequestBody WineWrapper wrapper) throws CellarNotFoundException, WineNotFoundException {
        Wine updateWine = wineService.updateWine(id, wrapper);
        return new ResponseEntity<>(updateWine, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteWine(@PathVariable("id") Integer id){
        wineService.delete(id);
    }

}
