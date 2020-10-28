package com.kadir.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kadir.model.Kitap;
import com.kadir.repository.KitapRepository;
import com.kadir.service.KitapService;

@Service
public class KitapServiceImpl implements KitapService {
	
	@Autowired
	KitapRepository kitapRepository;
	
	@Override
	public List<Kitap> listAll() {
		
		return (List<Kitap>) kitapRepository.findAll();
	}

	@Override
	public Kitap get(String kitapId) {
		
		Optional<Kitap> ktp = kitapRepository.findById(kitapId);
		if(ktp.isPresent())
			return ktp.get();
		else
			 throw new RuntimeException("Boyle bir id bulunamadi...");
	}

	@Override
	public Kitap save(Kitap kitap) {
		
		return kitapRepository.save(kitap);
	}

	@Override
	public void delete(String kitapId) {
		
		kitapRepository.deleteById( kitapId);

	}

	@Override
	public List<Kitap> searchList(String araKitap) {
		if(araKitap != null)
			return kitapRepository.ara(araKitap);
		return (List<Kitap>) kitapRepository.findAll();
	}

}
