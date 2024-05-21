package com.derrysetya.testsekolah.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.derrysetya.testsekolah.model.MapelModel;
import com.derrysetya.testsekolah.model.NilaiModel;
import com.derrysetya.testsekolah.model.SiswaModel;
import com.derrysetya.testsekolah.repo.MapelRepo;
import com.derrysetya.testsekolah.repo.NilaiRepo;
import com.derrysetya.testsekolah.repo.SiswaRepo;

@Service
public class NilaiService {
	
	@Autowired
	NilaiRepo repo;
	
	public List<NilaiModel> getAll(){
		return repo.findAll();
	}
	
	public NilaiModel getById(Long id) {
		Optional<NilaiModel> opt = null;
		
		
		opt = repo.findById(id);
		
		if(opt.isPresent()) {
			return opt.get();
		}
		
		return null;
	}
	
	
	public NilaiModel save(NilaiModel model) {
		return repo.save(model);
	}
	
	
	public void deleteById(Long id) {
		repo.deleteById(id);
	}
	
	public void deleteByIdSiswa(Long idSiswa) {
		repo.deleteByIdSiswa(idSiswa);
	}
	
	public void deleteByIdMapel(Long idMapel) {
		repo.deleteByIdMapel(idMapel);
	}

}
