package com.derrysetya.testsekolah.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "dat_nilai")
public class NilaiModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "id_siswa")
	private Long idSiswa;
	
	@Column(name = "id_mapel")
	private Long idMapel;
	
	@Column(name = "uts")
	private Integer uts;
	
	@Column(name = "uas")
	private Integer uas;
	
	
	

}
