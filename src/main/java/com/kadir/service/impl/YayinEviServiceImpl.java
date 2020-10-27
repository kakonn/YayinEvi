package com.kadir.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kadir.model.YayinEvi;
import com.kadir.repository.YayinEviRepository;
import com.kadir.service.YayinEviService;

@Service
public class YayinEviServiceImpl implements YayinEviService {

	@Autowired
	YayinEviRepository yayinEviRepository;

	@Override
	public List<YayinEvi> listAll() {

		return (List<YayinEvi>) yayinEviRepository.findAll();
	}

	@Override
	public YayinEvi get(int yayinEviId) {
		
		Optional<YayinEvi> yayinEvi = yayinEviRepository.findById((long) yayinEviId);
		if(yayinEvi.isPresent())
			return yayinEvi.get();
		else
			 throw new RuntimeException("Boyle bir id bulunamadi...");
	}

	@Override
	public YayinEvi save(YayinEvi yayinEvi) {
		
		return yayinEviRepository.save(yayinEvi);
	}

	@Override
	public void delete(int yayinEviId) {

		yayinEviRepository.deleteById((long) yayinEviId);

	}

}
