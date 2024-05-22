package com.derrysetya.testsekolah.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.util.http.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.derrysetya.testsekolah.constants.AppConstants;
import com.derrysetya.testsekolah.model.MapelModel;
import com.derrysetya.testsekolah.model.NilaiModel;
import com.derrysetya.testsekolah.model.SiswaModel;
import com.derrysetya.testsekolah.projections.DashNilaiProjection;
import com.derrysetya.testsekolah.response.ApiResponse;
import com.derrysetya.testsekolah.service.MapelService;
import com.derrysetya.testsekolah.service.NilaiService;
import com.derrysetya.testsekolah.service.SiswaService;
import com.derrysetya.testsekolah.utils.ResponseUtils;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("${rest.pathPrefix:api}/nilai")
public class NilaiController {
	
	@Autowired
	NilaiService service;
	
	@PostMapping(value = "/save")
	ApiResponse save(@RequestBody NilaiModel model){
		ApiResponse resp = new ApiResponse();
		
		NilaiModel newNilai = new NilaiModel();
		
		try {
			newNilai = service.save(model);
			
			resp = ResponseUtils.getSuccess();
			resp.setResult(newNilai);
			return resp;
		} catch (Exception e) {
			// TODO: handle exception
			
			System.out.println("Error save nilai");
			System.out.println(e.getMessage());
			
			resp = ResponseUtils.getFailed();
			
			return resp;
			
		}
		
		
	}
	
	@GetMapping(value = "/all")
	ApiResponse getAll(){
		ApiResponse resp = new ApiResponse();
		List<NilaiModel> listNilai = new ArrayList<>();
		
		try {
			listNilai = service.getAll();
			resp = ResponseUtils.getSuccess();
			resp.setResult(listNilai);
			return resp;
		} catch (Exception e) {
			// TODO: handle exception
			
			System.out.println("Error get all nilai");
			System.out.println(e.getMessage());
			
			resp = ResponseUtils.getFailed();
			
			return resp;
		}
		
		 
	}
	
	@GetMapping(value = "/dash")
	ApiResponse getDash(){
		ApiResponse resp = new ApiResponse();
		List<DashNilaiProjection> listNilai = new ArrayList<>();
		
		try {
			listNilai = service.getDash();
			resp = ResponseUtils.getSuccess();
			resp.setResult(listNilai);
			return resp;
		} catch (Exception e) {
			// TODO: handle exception
			
			System.out.println("Error get all dash nilai");
			System.out.println(e.getMessage());
			
			resp = ResponseUtils.getFailed();
			
			return resp;
		}
		
		 
	}
	
	@GetMapping()
	ApiResponse getById(@RequestParam(required = true, name = "id") String id){
		ApiResponse resp = new ApiResponse();
//		return service.getById(Long.valueOf(id));
		NilaiModel nilai = new NilaiModel();
		try {
			nilai = service.getById(Long.valueOf(id));
			resp = ResponseUtils.getSuccess();
			resp.setResult(nilai);
			return resp;
		} catch (Exception e) {
			// TODO: handle exception
			
			System.out.println("Error get nilai by "+id);
			System.out.println(e.getMessage());
			
			resp = ResponseUtils.getFailed();
			
			return resp;
		}
	}
	
	@PostMapping(value = "/delete")
	ApiResponse deleteByid(
			@RequestParam(required = true, name = "id") String id){
		ApiResponse resp = new ApiResponse();
		
		NilaiModel model = service.getById(Long.valueOf(id));
		
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
			
			System.out.println("Error delete nilai by "+id);
			System.out.println(e.getMessage());
			
			resp = ResponseUtils.getFailed();
			
			return resp;
		}
	}

}
