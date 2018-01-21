package com.dp3.web.controller;

import com.dp3.dao.CellarRepository;
import com.dp3.dao.WineRepository;
import com.dp3.domain.Cellar;
import com.dp3.domain.Wine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/cellar")
@CrossOrigin("*")
public class CellarController {

    @Autowired
    private CellarRepository cellarRepository;
    @Autowired
    private WineRepository wineRepository;

    @GetMapping("/all")
    public List<Cellar> getAllCellars(){
        Sort sortByCellarNameDesc = new Sort(Sort.Direction.DESC, "createdAt");
        return cellarRepository.findAll(sortByCellarNameDesc);
    }

    @PostMapping("/create")
    public ModelAndView createCellar(Model model, @Valid @RequestBody  Cellar cellar){
        cellarRepository.save(cellar);
        model.addAttribute("cellars", cellarRepository.findAll());
        return new ModelAndView("redirect:/stock/all");
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Cellar> getCellarByCellarName(@PathVariable("id") Integer id){
        Cellar cellar = cellarRepository.findOne(id);
        if(cellar == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(cellar, HttpStatus.OK);
        }
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Cellar> updateCellar(@PathVariable("id") Integer id,
                                               @Valid @RequestBody Cellar cellar){
        Cellar cellarData = cellarRepository.findOne(id);
        if(cellarData == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if (cellar.getCellarName()!=null){
            cellarData.setCellarName(cellar.getCellarName());
        }
        if (cellar.getDescription()!=null){
            cellarData.setDescription(cellar.getDescription());
        }
        if (cellar.getLocation()!=null) {
            cellarData.setLocation(cellar.getLocation());
        }
        Cellar updateCellar = cellarRepository.save(cellarData);
        return new ResponseEntity<>(updateCellar,HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteCellar(@PathVariable("id") Integer id){
        Cellar cellarToDelete = cellarRepository.findOne(id);
        List<Wine> wines = wineRepository.findByCellar(cellarToDelete);
        if (wines.isEmpty()){
            cellarRepository.delete(id);
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.METHOD_NOT_ALLOWED);
        }
    }

}
