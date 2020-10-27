package com.kadir;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.kadir.model.Kitap;
import com.kadir.model.YayinEvi;
import com.kadir.model.Yazar;
import com.kadir.repository.KitapRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
class YayinEviCrudApplicationTests {

	@Autowired
	KitapRepository kitapRepository;

	@Test
	public void SaveKitapTest() {

		Kitap kitap = getKitap();

		Kitap kitap2 = kitapRepository.save(kitap);

		//assertNotNull(kitap);
		assertEquals(kitap.getKitapAdi(), kitap2.getKitapAdi());
		assertEquals(kitap.getKitapIsbn(), kitap2.getKitapIsbn());
	}

	@Test
	public void testDeleteKitap() {

		Kitap kitap = getKitap();

		kitapRepository.save(kitap);
		kitapRepository.delete(kitap);

	}


	private Kitap getKitap() {

		YayinEvi yayinEvi = new YayinEvi();
		// long i = 1;
		// yayinEvi.setYayinEviId(i);
		yayinEvi.setYayinEviAdi("Epsilon");
		yayinEvi.setYayinEviAciklama("aciklama yayinevi");

		Yazar yazar = new Yazar();
		// yazar.setYazarId(i);
		yazar.setYazarAdi("Orhan Kemal");
		yazar.setYazarAciklama("aciklama yazar");

		Kitap kitap = new Kitap();
		kitap.setKitapAdi("Uckagitci");
		kitap.setKitapAltAdi("Uckagit");
		kitap.setKitapIsbn("2323-4343-31343");
		kitap.setKitapSeriAdi("UckagitciSeri");
		kitap.setYayinEvi(yayinEvi);
		kitap.setYazar(yazar);
		
		return kitap;

	}
}
