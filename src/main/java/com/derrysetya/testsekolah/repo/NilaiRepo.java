package com.derrysetya.testsekolah.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.derrysetya.testsekolah.model.MapelModel;
import com.derrysetya.testsekolah.model.NilaiModel;
import com.derrysetya.testsekolah.model.SiswaModel;
import com.derrysetya.testsekolah.projections.DashNilaiProjection;
import com.derrysetya.testsekolah.projections.ComboBoxProjection;

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
	
	String qDash = "select dn.id, dn.uts, dn.uas, mm.nama as mapel, ms.nama from db_sekolah.dat_nilai dn "
			+ "join db_sekolah.mst_mapel mm on mm.id = dn.id_mapel "
			+ "join db_sekolah.mst_siswa ms on ms.id = dn.id_siswa ";
	
	@Query(value = qDash, nativeQuery = true)
	List<DashNilaiProjection> findListDash();
	
	
	@Query(value =  qDash + " where dn.id_mapel = :idMapel ", nativeQuery = true)
	List<DashNilaiProjection> findListDashByIdMapel(Long idMapel);
	
	@Query(value = "select distinct dn.id_mapel as cd, mm.nama as nama from db_sekolah.dat_nilai dn "
			+ "join db_sekolah.mst_mapel mm on mm.id = dn.id_mapel ", nativeQuery = true)
	List<ComboBoxProjection> getListComboBoxDistinctMapel();
	

}
