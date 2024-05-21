package com.derrysetya.testsekolah.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.derrysetya.testsekolah.model.SiswaModel;

@Repository
public interface SiswaRepo extends JpaRepository<SiswaModel, Long> {
	
	@Modifying
	@Transactional
	@Query(value = "DELETE FROM SiswaModel sm WHERE sm.id = :id ")
	void deleteById(Long id);

}
