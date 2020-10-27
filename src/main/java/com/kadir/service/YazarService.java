package com.kadir.service;

import java.util.List;

import com.kadir.model.Yazar;

public interface YazarService {
	
	public List<Yazar> listAll();
	
	public Yazar get(int yazarId);
	
	public Yazar save(Yazar yazar);
	
	public void delete(int yazarId);
}
