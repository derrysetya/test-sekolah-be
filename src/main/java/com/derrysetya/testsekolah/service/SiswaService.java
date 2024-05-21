package com.derrysetya.testsekolah.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.derrysetya.testsekolah.model.SiswaModel;
import com.derrysetya.testsekolah.repo.SiswaRepo;

@Service
public class SiswaService {
	
	@Autowired
	SiswaRepo siswaRepo;
	
	public List<SiswaModel> getAll(){
		return siswaRepo.findAll();
	}
	
	public SiswaModel getById(Long id) {
		Optional<SiswaModel> optSiswa = null;
		
		
		optSiswa = siswaRepo.findById(id);
		
		if(optSiswa.isPresent()) {
			return optSiswa.get();
		}
		
		return null;
	}
	
	
	public SiswaModel save(SiswaModel model) {
		return siswaRepo.save(model);
	}
	
	
	public void deleteById(Long id) {
		siswaRepo.deleteById(id);
	}

}
