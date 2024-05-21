package com.derrysetya.testsekolah.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.derrysetya.testsekolah.model.MapelModel;
import com.derrysetya.testsekolah.model.SiswaModel;

@Repository
public interface MapelRepo extends JpaRepository<MapelModel, Long> {
	
	@Modifying
	@Transactional
	@Query(value = "DELETE FROM MapelModel mm WHERE mm.id = :id ")
	void deleteById(Long id);

}
