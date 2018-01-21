package com.dp3.dao;

import com.dp3.domain.Cellar;
import com.dp3.domain.Wine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WineRepository extends JpaRepository<Wine, Integer> {

    List<Wine> findByCellar(Cellar cellar);

}