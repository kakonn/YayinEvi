package com.kadir.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kadir.model.Yazar;

@Repository
public interface YazarRepository extends CrudRepository<Yazar, Long>{
	
	
	
}
