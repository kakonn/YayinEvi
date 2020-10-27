package com.kadir.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kadir.model.Kitap;

@Repository
public interface KitapRepository extends CrudRepository<Kitap, String>{

}
