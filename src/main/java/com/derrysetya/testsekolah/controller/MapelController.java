package com.derrysetya.testsekolah.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.derrysetya.testsekolah.model.MapelModel;
import com.derrysetya.testsekolah.model.SiswaModel;
import com.derrysetya.testsekolah.service.MapelService;
import com.derrysetya.testsekolah.service.SiswaService;

@RestController
@RequestMapping("${rest.pathPrefix:api}/mapel")
public class MapelController {
	
	@Autowired
	MapelService service;
	
	@PostMapping(value = "/save")
	MapelModel save(@RequestBody MapelModel model){
		return service.save(model);
	}
	
	@GetMapping(value = "/all")
	List<MapelModel> getAll(){
		return service.getAll();
	}
	
	@GetMapping()
	MapelModel getById(@RequestParam(required = true, name = "id") String id){
		return service.getById(Long.valueOf(id));
	}
	
	@PostMapping(value = "/delete")
	String deleteByid(@RequestParam(required = true, name = "id") String id){
		
		MapelModel model = service.getById(Long.valueOf(id));
		
		if(model == null) {
			return "mapel tidak ditemukan";
		}else {
			
			service.deleteById(Long.valueOf(id));
			return "mapel berhasil di delete";
		}
		
		
		
	}

}
