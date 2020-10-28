package com.kadir;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.kadir.model.Kitap;
import com.kadir.model.YayinEvi;
import com.kadir.model.Yazar;
import com.kadir.service.KitapService;
import com.kadir.service.YayinEviService;
import com.kadir.service.YazarService;

@SpringBootApplication
public class YayinEviCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(YayinEviCrudApplication.class, args);
	}

	KitapService kitapService;
	YazarService yazarService;
	YayinEviService yayinEviService;

	@Autowired
	public void DefaultValue(KitapService kitapService, YazarService yazarService, YayinEviService yayinEviService) {

		this.kitapService = kitapService;
		this.yazarService = yazarService;
		this.yayinEviService = yayinEviService;
	}
	
	@Bean
	public CommandLineRunner setUp() {
		return(args) ->{
		
		Long id = (long) 1;

		Yazar yazar1 = new Yazar(id, "ROBERT KRUGMANN", "Robert");
		Yazar yazar2 = new Yazar(id + 1, "JOSEF NYARY", "Josef");
		Yazar yazar3 = new Yazar(id + 2, "ALEXANDRE DUMAS", "Alexandre");
		Yazar yazar4 = new Yazar(id + 3, "LEV NİKOLAYEVİÇ TOLSTOY", "Tolstoy");
		YayinEvi yayinEvi1 = new YayinEvi(id, "YURT KİTAP-YAYIN", "Ankara");
		YayinEvi yayinEvi2 = new YayinEvi(id+1, "İSKELE YAYIN EVİ", "İstanbul");
		Kitap kitap1 = new Kitap("975-9099-55-1", "Anna Karanina", "Anna Karanina", "Anna Karanina 1", yazar4,
				yayinEvi2);
		Kitap kitap2 = new Kitap("975-7076-24-4", "İlyada", "Tarihi Romanlar Dizisi", "Mitoloji", yazar1, yayinEvi1);
		Kitap kitap3 = new Kitap("978-975-9025-94-6", "Hükümdarlar Hükümdarı Sargon", "Lugal", "Sargon", yazar2,
				yayinEvi1);
		Kitap kitap4 = new Kitap("975-9099-20-9", "Monte Kristo Kontu", "Monte Kristo", "Dünya Klasikleri Dizisi:24",
				yazar3, yayinEvi2);
		Kitap kitap5 = new Kitap("975-9099-55-1", "Anna Karanina", "Anna Karanina", "Anna Karanina 2", yazar4,
				yayinEvi2);

		yazarService.save(yazar1);
		yazarService.save(yazar2);
		yazarService.save(yazar3);
		yazarService.save(yazar4);

		yayinEviService.save(yayinEvi1);
		yayinEviService.save(yayinEvi2);

		kitapService.save(kitap1);
		kitapService.save(kitap2);
		kitapService.save(kitap3);
		kitapService.save(kitap4);
		kitapService.save(kitap5);
		
	};
	}
}
