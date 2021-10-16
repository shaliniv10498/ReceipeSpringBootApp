package com.shalini.receipe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shalini.receipe.model.Receipe;

@Repository
public interface ReceipeRepository extends JpaRepository<Receipe,Integer>{

	
}
