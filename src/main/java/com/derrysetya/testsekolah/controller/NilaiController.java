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
import com.derrysetya.testsekolah.model.NilaiModel;
import com.derrysetya.testsekolah.model.SiswaModel;
import com.derrysetya.testsekolah.service.MapelService;
import com.derrysetya.testsekolah.service.NilaiService;
import com.derrysetya.testsekolah.service.SiswaService;

@RestController
@RequestMapping("${rest.pathPrefix:api}/nilai")
public class NilaiController {
	
	@Autowired
	NilaiService service;
	
	@PostMapping(value = "/save")
	NilaiModel save(@RequestBody NilaiModel model){
		return service.save(model);
	}
	
	@GetMapping(value = "/all")
	List<NilaiModel> getAll(){
		return service.getAll();
	}
	
	@GetMapping()
	NilaiModel getById(@RequestParam(required = true, name = "id") String id){
		return service.getById(Long.valueOf(id));
	}
	
	@PostMapping(value = "/delete")
	String deleteByid(
			@RequestParam(required = true, name = "type") String type,
			@RequestParam(required = true, name = "id") String id){
		
		NilaiModel model = service.getById(Long.valueOf(id));
		
		if(model == null) {
			return "nilai tidak ditemukan";
		}else {
			
			service.deleteById(Long.valueOf(id));
			return "nilai berhasil di delete";
		}
		
		
		
	}

}
