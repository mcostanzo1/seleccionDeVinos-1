package com.dp3.service;

import com.dp3.dao.CellarRepository;
import com.dp3.domain.Cellar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CellarService {

    @Autowired
    private CellarRepository cellarRepository;

    public List<Cellar> findAll(){
        return cellarRepository.findAll();
    }
}
