package com.derrysetya.testsekolah.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.derrysetya.testsekolah.model.GuruModel;
import com.derrysetya.testsekolah.projections.DashMapelProjection;
import com.derrysetya.testsekolah.projections.SelectOptionProjection;

@Repository
public interface GuruRepo extends JpaRepository<GuruModel, Long> {
	
	@Modifying
	@Transactional
	@Query(value = "DELETE FROM GuruModel sm WHERE sm.id = :id ")
	void deleteById(Long id);
	
	@Query(value = "select id as cd, nama from mst_guru ", nativeQuery = true)
	List<SelectOptionProjection> findListSelectOptProjection();

}
