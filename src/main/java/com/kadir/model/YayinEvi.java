package com.kadir.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "YAYIN_EVI")
public class YayinEvi {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "yyn-seq")
	@SequenceGenerator(name = "yyn-seq", sequenceName = "YAYIN_EVI_SEQ", allocationSize = 1)
	@Column(name = "yayin_evi_id")
	private Long yayinEviId;
	
	@NotNull(message = "Yayın Evi Adı Boş Bırakılamaz!")
	@Size(min = 5, max=100)
	@Column(name = "yayin_evi_adi")
	private String yayinEviAdi;

	@Column(name = "yayin_evi_aciklama")
	private String yayinEviAciklama;

	@OneToMany(mappedBy = "yayinEvi",cascade = CascadeType.ALL)
	private List<Kitap> yayinEviKitaplar;

	public Long getYayinEviId() {
		return yayinEviId;
	}

	public void setYayinEviId(Long yayinEviId) {
		this.yayinEviId = yayinEviId;
	}

	public String getYayinEviAdi() {
		return yayinEviAdi;
	}

	public void setYayinEviAdi(String yayinEviAdi) {
		this.yayinEviAdi = yayinEviAdi;
	}

	public String getYayinEviAciklama() {
		return yayinEviAciklama;
	}

	public void setYayinEviAciklama(String yayinEviAciklama) {
		this.yayinEviAciklama = yayinEviAciklama;
	}

	public List<Kitap> getYayinEviKitaplar() {
		return yayinEviKitaplar;
	}

	public void setYayinEviKitaplar(List<Kitap> yayinEviKitaplar) {
		this.yayinEviKitaplar = yayinEviKitaplar;
	}

}
