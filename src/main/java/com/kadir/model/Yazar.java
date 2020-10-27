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
@Table(name = "YAZAR")
public class Yazar {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "yzr-seq")
	@SequenceGenerator(name = "yzr-seq", sequenceName = "YAZAR_SEQ", allocationSize = 1)
	@Column(name = "YAZAR_ID")
	private Long yazarId;

	@NotNull(message = "Yazar Adı Boş Bırakılamaz!")
	@Size(min = 5, max=100)
	@Column(name = "YAZAR_ADI")
	private String yazarAdi;
	
	@Column(name = "YAZAR_ACIKLAMA")
	private String yazarAciklama;

	@OneToMany(mappedBy = "yazar", cascade = CascadeType.ALL)
	private List<Kitap> yazarKitap;

	public Long getYazarId() {
		return yazarId;
	}

	public void setYazarId(Long yazarId) {
		this.yazarId = yazarId;
	}

	public List<Kitap> getYazarKitap() {
		return yazarKitap;
	}

	public void setYazarKitap(List<Kitap> yazarKitap) {
		this.yazarKitap = yazarKitap;
	}

	public String getYazarAdi() {
		return yazarAdi;
	}

	public void setYazarAdi(String yazarAdi) {
		this.yazarAdi = yazarAdi;
	}

	public String getYazarAciklama() {
		return yazarAciklama;
	}

	public void setYazarAciklama(String yazarAciklama) {
		this.yazarAciklama = yazarAciklama;
	}

	@Override
	public String toString() {
		return "Yazar [yazarId=" + yazarId + ", yazarAdi=" + yazarAdi + ", yazarAciklama=" + yazarAciklama
				+ ", yazarKitap=" + yazarKitap + "]";
	}

}
