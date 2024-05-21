package com.derrysetya.testsekolah.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.derrysetya.testsekolah.model.SiswaModel;
import com.derrysetya.testsekolah.response.ApiResponse;
import com.derrysetya.testsekolah.service.SiswaService;
import com.derrysetya.testsekolah.utils.ResponseUtils;

@RestController
@RequestMapping("${rest.pathPrefix:api}/siswa")
public class SiswaController {
	
	@Autowired
	SiswaService service;
	
	@PostMapping(value = "/save")
	ApiResponse save(@RequestBody SiswaModel model){
		ApiResponse resp = new ApiResponse();
		
		SiswaModel newSiswa = new SiswaModel();
		
		try {
			
			newSiswa = service.save(model);
			
			resp = ResponseUtils.getSuccess();
			
			resp.setResult(newSiswa);
			
			return resp;
		} catch (Exception e) {
			// TODO: handle exception
			
			System.out.println("Error save siswa");
			System.out.println(e.getMessage());
			
			resp = ResponseUtils.getFailed();
			
			return resp;
		}
		
	}
	
	@GetMapping(value = "/all")
	ApiResponse getAll(){
		ApiResponse resp = new ApiResponse();
		List<SiswaModel> listSiswa = new ArrayList<>();
		
		try {
			
			listSiswa = service.getAll();
			
			resp = ResponseUtils.getSuccess();
			
			resp.setResult(listSiswa);
			
			return resp;
		} catch (Exception e) {
			// TODO: handle exception
			
			System.out.println("Error get all siswa");
			System.out.println(e.getMessage());
			
			resp = ResponseUtils.getFailed();
			
			return resp;
		}
	}
	
	@GetMapping()
	ApiResponse getById(@RequestParam(required = true, name = "id") String id){
		ApiResponse resp = new ApiResponse();
		SiswaModel siswa = new SiswaModel();
		
		try {
			
			siswa = service.getById(Long.valueOf(id));
			
			resp = ResponseUtils.getSuccess();
			
			resp.setResult(siswa);
			
			return resp;
		} catch (Exception e) {
			// TODO: handle exception
			
			System.out.println("Error get siswa by "+id);
			System.out.println(e.getMessage());
			
			resp = ResponseUtils.getFailed();
			
			return resp;
		}
		
		
	}
	
	@PostMapping(value = "/delete")
	ApiResponse deleteByid(@RequestParam(required = true, name = "id") String id){
		ApiResponse resp = new ApiResponse();
		
		SiswaModel model = service.getById(Long.valueOf(id));
		
		try {
			model = service.getById(Long.valueOf(id));
			
			if(model == null) {
				resp = ResponseUtils.getFailed();
			}else {
				
				service.deleteById(Long.valueOf(id));
				resp = ResponseUtils.getSuccess();
				
			}
			
			return resp;
		} catch (Exception e) {
			// TODO: handle exception
			
			System.out.println("Error delete siswa by "+id);
			System.out.println(e.getMessage());
			
			resp = ResponseUtils.getFailed();
			
			return resp;
		}
		
	}

}
