package com.derrysetya.testsekolah.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.derrysetya.testsekolah.model.GuruModel;

@Repository
public interface GuruRepo extends JpaRepository<GuruModel, Long> {
	
	@Modifying
	@Transactional
	@Query(value = "DELETE FROM GuruModel sm WHERE sm.id = :id ")
	void deleteById(Long id);

}
