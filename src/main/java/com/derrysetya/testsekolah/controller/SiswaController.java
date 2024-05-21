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

import com.derrysetya.testsekolah.model.SiswaModel;
import com.derrysetya.testsekolah.service.SiswaService;

@RestController
@RequestMapping("${rest.pathPrefix:api}/siswa")
public class SiswaController {
	
	@Autowired
	SiswaService siswaService;
	
	@PostMapping(value = "/save")
	SiswaModel save(@RequestBody SiswaModel model){
		return siswaService.save(model);
	}
	
	@GetMapping(value = "/all")
	List<SiswaModel> getAll(){
		return siswaService.getAll();
	}
	
	@GetMapping()
	SiswaModel getById(@RequestParam(required = true, name = "id") String id){
		return siswaService.getById(Long.valueOf(id));
	}
	
	@PostMapping(value = "/delete")
	String deleteByid(@RequestParam(required = true, name = "id") String id){
		
		SiswaModel model = siswaService.getById(Long.valueOf(id));
		
		if(model == null) {
			return "siswa tidak ditemukan";
		}else {
			
			siswaService.deleteById(Long.valueOf(id));
			return "siswa berhasil di delete";
		}
		
		
		
	}

}
