package com.kadir.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kadir.model.Kitap;

@Repository
public interface KitapRepository extends CrudRepository<Kitap, String>{
	
	@Query("select k from Kitap k where lower(concat(k.kitapIsbn,' ',k.kitapAdi,' ',k.kitapSeriAdi,' ',k.yazar.yazarAdi)) like %?1%")	
	public List<Kitap> ara(String araKitap);

}
