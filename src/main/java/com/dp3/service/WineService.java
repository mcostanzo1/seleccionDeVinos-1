package com.dp3.service;

import com.dp3.dao.CellarRepository;
import com.dp3.dao.WineRepository;
import com.dp3.domain.Cellar;
import com.dp3.domain.Wine;
import com.dp3.exceptions.CellarNotFoundException;
import com.dp3.exceptions.WineNotFoundException;
import com.dp3.web.WineWrapper;
import org.hibernate.annotations.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.sql.Wrapper;
import java.util.Date;
import java.util.List;

@Service
public class WineService {

    @Autowired
    private WineRepository wineRepository;
    @Autowired
    private CellarRepository cellarRepository;

    public List<Wine> getAllWines(){
        return wineRepository.findAll();
    }

    public Wine createWine(WineWrapper wrapper) throws CellarNotFoundException {
        Cellar cellar = cellarRepository.findOne(wrapper.getCellarId());
        if (cellar == null) {
            throw new CellarNotFoundException("Cellar "+wrapper.getCellarId()+" does not exists.");
        }
        Wine wine = wrapper.getWine();
        wine.setCellar(cellar);
        wine.addPrice(new Date(), wrapper.getPrice());
        return wineRepository.save(wine);
    }

    public Wine updateWine(Integer id, WineWrapper wrapper) throws CellarNotFoundException, WineNotFoundException {
        Wine wineData = wineRepository.findOne(id);
        if(wineData == null){
            throw new WineNotFoundException("Wine "+id+" does not exists.");
        }
        if (wrapper.getCellarId()!=null) {
            Cellar cellar = cellarRepository.findOne(wrapper.getCellarId());
            if (cellar == null) {
                throw new CellarNotFoundException("Cellar "+wrapper.getCellarId()+" does not exists.");
            } else {
                wineData.setCellar(cellar);
            }
        }

        if (wrapper.getWine().getName()!=null){
            wineData.setName(wrapper.getWine().getName());
        }
        if (wrapper.getWine().getVariety()!=null){
            wineData.setVariety(wrapper.getWine().getVariety());
        }
        if (wrapper.getWine().getQuantityPerBox()!=0){
            wineData.setQuantityPerBox(wrapper.getWine().getQuantityPerBox());
        }
        return wineRepository.save(wineData);
    }

    public void delete(Integer id){
        wineRepository.delete(id);
    }

    public Wine findById(Integer id) {
        return wineRepository.findOne(id);
    }
}
