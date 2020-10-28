package com.kadir.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "KITAP")
public class Kitap {

	@NotNull(message = "Kitap Isbn Boş Bırakılamaz!")
	@Size(min = 12, max = 13)
	@Id
	@Column(name = "kitap_isbn")
	private String kitapIsbn;

	@NotNull(message = "Kitap Adı Boş Bırakılamaz!")
	@Size(min = 5, max = 100)
	@Column(name = "kitap_adi")
	private String kitapAdi;

	@NotNull(message = "Kitap Alt Adı Boş Bırakılamaz!")
	@Size(min = 5, max = 100)
	@Column(name = "kitap_alt_adi")
	private String kitapAltAdi;

	@NotNull(message = "Kitap Seri Adı Boş Bırakılamaz!")
	@Size(min = 5, max = 100)
	@Column(name = "kitap_seri_adi")
	private String kitapSeriAdi;

	@ManyToOne
	@JoinColumn(name = "yazar_id")
	private Yazar yazar;

	@ManyToOne
	@JoinColumn(name = "yayin_evi_id")
	private YayinEvi yayinEvi;

	public Kitap() {

	}

	public Kitap(@NotNull(message = "Kitap Isbn Boş Bırakılamaz!") @Size(min = 12, max = 13) String kitapIsbn,
			@NotNull(message = "Kitap Adı Boş Bırakılamaz!") @Size(min = 5, max = 100) String kitapAdi,
			@NotNull(message = "Kitap Alt Adı Boş Bırakılamaz!") @Size(min = 5, max = 100) String kitapAltAdi,
			@NotNull(message = "Kitap Seri Adı Boş Bırakılamaz!") @Size(min = 5, max = 100) String kitapSeriAdi,
			Yazar yazar, YayinEvi yayinEvi) {

		this.kitapIsbn = kitapIsbn;
		this.kitapAdi = kitapAdi;
		this.kitapAltAdi = kitapAltAdi;
		this.kitapSeriAdi = kitapSeriAdi;
		this.yazar = yazar;
		this.yayinEvi = yayinEvi;
	}

	public String getKitapIsbn() {
		return kitapIsbn;
	}

	public void setKitapIsbn(String kitapIsbn) {
		this.kitapIsbn = kitapIsbn;
	}

	public String getKitapAdi() {
		return kitapAdi;
	}

	public void setKitapAdi(String kitapAdi) {
		this.kitapAdi = kitapAdi;
	}

	public String getKitapAltAdi() {
		return kitapAltAdi;
	}

	public void setKitapAltAdi(String kitapAltAdi) {
		this.kitapAltAdi = kitapAltAdi;
	}

	public String getKitapSeriAdi() {
		return kitapSeriAdi;
	}

	public void setKitapSeriAdi(String kitapSeriAdi) {
		this.kitapSeriAdi = kitapSeriAdi;
	}

	public Yazar getYazar() {
		return yazar;
	}

	public void setYazar(Yazar yazar) {
		this.yazar = yazar;
	}

	public YayinEvi getYayinEvi() {
		return yayinEvi;
	}

	public void setYayinEvi(YayinEvi yayinEvi) {
		this.yayinEvi = yayinEvi;
	}

}
