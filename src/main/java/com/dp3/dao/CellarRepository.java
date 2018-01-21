package com.dp3.dao;

import com.dp3.domain.Cellar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CellarRepository extends JpaRepository<Cellar, Integer> {
}