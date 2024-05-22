package com.derrysetya.testsekolah.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.derrysetya.testsekolah.model.MapelModel;
import com.derrysetya.testsekolah.model.SiswaModel;
import com.derrysetya.testsekolah.projections.DashMapelProjection;
import com.derrysetya.testsekolah.projections.ComboBoxProjection;
import com.derrysetya.testsekolah.repo.MapelRepo;
import com.derrysetya.testsekolah.repo.SiswaRepo;

@Service
public class MapelService {
	
	@Autowired
	MapelRepo repo;
	
	public List<ComboBoxProjection> getListSelectOptProjections(){
		return repo.findListSelectOptProjection();
	}
	
	public List<MapelModel> getAll(){
		return repo.findAll();
	}
	
	public List<DashMapelProjection> getDash(){
		return repo.findListDash();
	}
	
	public MapelModel getById(Long id) {
		Optional<MapelModel> opt = null;
		
		
		opt = repo.findById(id);
		
		if(opt.isPresent()) {
			return opt.get();
		}else {			
			return null;
		}
	}
	
	
	public MapelModel save(MapelModel model) {
		return repo.save(model);
	}
	
	
	public void deleteById(Long id) {
		repo.deleteById(id);
	}

}
