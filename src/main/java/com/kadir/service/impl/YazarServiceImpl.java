package com.kadir.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kadir.model.Yazar;
import com.kadir.repository.YazarRepository;
import com.kadir.service.YazarService;

@Service
public class YazarServiceImpl implements YazarService{
	
	@Autowired
	YazarRepository yazarRepository;
	
	@Transactional
	@Override
	public List<Yazar> listAll() {
		
		return (List<Yazar>) yazarRepository.findAll();
	}

	@Override
	public Yazar get(int yazarId) {
		
		Optional<Yazar> yzr = yazarRepository.findById((long) yazarId);
		if(yzr.isPresent())
			return yzr.get();
		else
			 throw new RuntimeException("Boyle bir id bulunamadi...");
	}

	@Override
	public Yazar save(Yazar yazar) {
		
		return yazarRepository.save(yazar);
	}

	@Override
	public void delete(int yazarId) {
		
		yazarRepository.deleteById((long) yazarId);
	}

}
