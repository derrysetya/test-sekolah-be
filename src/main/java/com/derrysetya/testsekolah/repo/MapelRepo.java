package com.derrysetya.testsekolah.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.derrysetya.testsekolah.model.MapelModel;
import com.derrysetya.testsekolah.model.SiswaModel;
import com.derrysetya.testsekolah.projections.DashMapelProjection;
import com.derrysetya.testsekolah.projections.ComboBoxProjection;

@Repository
public interface MapelRepo extends JpaRepository<MapelModel, Long> {
	
	@Modifying
	@Transactional
	@Query(value = "DELETE FROM MapelModel mm WHERE mm.id = :id ")
	void deleteById(Long id);
	
	@Query(value = "select mm.id, mm.nama, mm.kkm, mg.nama as guru from db_sekolah.mst_mapel mm "
			+ "join db_sekolah.mst_guru mg on mg.id = mm.id_guru ", nativeQuery = true)
	List<DashMapelProjection> findListDash();
	
	@Query(value = "select id as cd, nama from mst_mapel ", nativeQuery = true)
	List<ComboBoxProjection> findListSelectOptProjection();

}
