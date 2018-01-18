package com.dp3.web.controller;

import com.dp3.dao.CellarRepository;
import com.dp3.dao.WineRepository;
import com.dp3.domain.Wine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@RestController
@RequestMapping("/wines")
@CrossOrigin("*")
public class WineController {

    @Autowired
    private WineRepository wineRepository;

    @Autowired
    private CellarRepository cellarRepository;

    @GetMapping("/all")
    public List<Wine> getAllWines(){
        Sort sortByWineNameDesc = new Sort(Sort.Direction.DESC, "createdAt");
        return wineRepository.findAll(sortByWineNameDesc);
    }

    @PostMapping("/createWine")
    public ModelAndView createWine(Model model, Wine wine){
        model.addAttribute("cellars", cellarRepository.findAll());
        wineRepository.save(wine);
        return new ModelAndView("redirect:/stock/all");
    }

    @GetMapping(value = "/wine/{id}")
    public ResponseEntity<Wine> getWineByWineName(@PathVariable("id") String id){
        Wine wine = wineRepository.findOne(id);
        if(wine == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(wine, HttpStatus.OK);
        }
    }

    @PutMapping(value = "/wine/{id}")
    public ResponseEntity<Wine> updateWine(@PathVariable("id") String id,
                                                @RequestBody Wine wine){
        Wine wineData = wineRepository.findOne(id);
        if(wineData == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        wineData.setName(wine.getName());
        wineData.setVariety(wine.getVariety());
        wineData.setQuantityOnBox(wine.getQuantityOnBox());
        Wine updateWine = wineRepository.save(wineData);
        return new ResponseEntity<>(updateWine,HttpStatus.OK);
    }

    @DeleteMapping(value = "/wine/{id}")
    public void deleteWine(@PathVariable("id") String id){
        wineRepository.delete(id);
    }

}
