package com.derrysetya.testsekolah.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.derrysetya.testsekolah.model.MapelModel;
import com.derrysetya.testsekolah.model.NilaiModel;
import com.derrysetya.testsekolah.model.SiswaModel;

@Repository
public interface NilaiRepo extends JpaRepository<NilaiModel, Long> {
	
	@Modifying
	@Transactional
	@Query(value = "DELETE FROM NilaiModel mm WHERE mm.id = :id ")
	void deleteById(Long id);
	
	
	@Modifying
	@Transactional
	@Query(value = "DELETE FROM NilaiModel mm WHERE mm.idSiswa = :idSiswa ")
	void deleteByIdSiswa(Long idSiswa);
	
	@Modifying
	@Transactional
	@Query(value = "DELETE FROM NilaiModel mm WHERE mm.idMapel = :idMapel ")
	void deleteByIdMapel(Long idMapel);

}
