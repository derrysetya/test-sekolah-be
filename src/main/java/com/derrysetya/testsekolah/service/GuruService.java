package com.derrysetya.testsekolah.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.derrysetya.testsekolah.model.GuruModel;
import com.derrysetya.testsekolah.model.SiswaModel;
import com.derrysetya.testsekolah.projections.SelectOptionProjection;
import com.derrysetya.testsekolah.repo.GuruRepo;
import com.derrysetya.testsekolah.repo.SiswaRepo;

@Service
public class GuruService {
	
	@Autowired
	GuruRepo repo;
	
	public List<SelectOptionProjection> getListSelectOptProjections(){
		return repo.findListSelectOptProjection();
	}
	
	public List<GuruModel> getAll(){
		return repo.findAll();
	}
	
	public GuruModel getById(Long id) {
		Optional<GuruModel> opt = null;
		
		
		opt = repo.findById(id);
		
		if(opt.isPresent()) {
			return opt.get();
		}else {			
			return null;
		}
		
	}
	
	
	public GuruModel save(GuruModel model) {
		return repo.save(model);
	}
	
	
	public void deleteById(Long id) {
		repo.deleteById(id);
	}

}
