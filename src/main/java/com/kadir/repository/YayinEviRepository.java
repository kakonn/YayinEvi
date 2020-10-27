package com.kadir.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kadir.model.YayinEvi;

@Repository
public interface YayinEviRepository extends CrudRepository<YayinEvi, Long>{

}
