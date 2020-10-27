package com.kadir.service;

import java.util.List;

import com.kadir.model.Kitap;

public interface KitapService {

	public List<Kitap> listAll();

	public Kitap get(String kitapId);

	public Kitap save(Kitap kitap);

	public void delete(String kitapId);

}
