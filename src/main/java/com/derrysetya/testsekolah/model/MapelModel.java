package com.derrysetya.testsekolah.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "mst_mapel")
public class MapelModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "nama")
	private String nama;
	
	@Column(name = "kkm")
	private Integer kkm;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public Integer getKkm() {
		return kkm;
	}

	public void setKkm(Integer kkm) {
		this.kkm = kkm;
	}

	@Override
	public String toString() {
		return "MapelModel [id=" + id + ", nama=" + nama + ", kkm=" + kkm + "]";
	}

	

}
