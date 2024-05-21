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

import com.derrysetya.testsekolah.model.GuruModel;
import com.derrysetya.testsekolah.model.SiswaModel;
import com.derrysetya.testsekolah.response.ApiResponse;
import com.derrysetya.testsekolah.service.GuruService;
import com.derrysetya.testsekolah.service.SiswaService;
import com.derrysetya.testsekolah.utils.ResponseUtils;

@RestController
@RequestMapping("${rest.pathPrefix:api}/guru")
public class GuruController {
	
	@Autowired
	GuruService service;
	
	@PostMapping(value = "/save")
	ApiResponse save(@RequestBody GuruModel model){
		ApiResponse resp = new ApiResponse();
		
		GuruModel newModel = new GuruModel();
		
		try {
			
			newModel = service.save(model);
			
			resp = ResponseUtils.getSuccess();
			
			resp.setResult(newModel);
			
			return resp;
		} catch (Exception e) {
			// TODO: handle exception
			
			System.out.println("Error save guru");
			System.out.println(e.getMessage());
			
			resp = ResponseUtils.getFailed();
			
			return resp;
		}
		
	}
	
	@GetMapping(value = "/all")
	ApiResponse getAll(){
		ApiResponse resp = new ApiResponse();
		List<GuruModel> listModel = new ArrayList<>();
		
		try {
			
			listModel = service.getAll();
			
			resp = ResponseUtils.getSuccess();
			
			resp.setResult(listModel);
			
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
		GuruModel model = new GuruModel();
		
		try {
			
			model = service.getById(Long.valueOf(id));
			
			resp = ResponseUtils.getSuccess();
			
			resp.setResult(model);
			
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
		
		GuruModel model = new GuruModel();
		
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
