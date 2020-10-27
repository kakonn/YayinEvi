package com.kadir.service;

import java.util.List;

import com.kadir.model.YayinEvi;

public interface YayinEviService {
	
public List<YayinEvi> listAll();
	
	public YayinEvi get(int yayinEviId);
	
	public YayinEvi save(YayinEvi yayinEvi);
	
	public void delete(int yayinEviId);

}
