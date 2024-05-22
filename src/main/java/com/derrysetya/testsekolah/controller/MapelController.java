package com.derrysetya.testsekolah.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.derrysetya.testsekolah.model.MapelModel;
import com.derrysetya.testsekolah.model.SiswaModel;
import com.derrysetya.testsekolah.projections.DashMapelProjection;
import com.derrysetya.testsekolah.projections.ComboBoxProjection;
import com.derrysetya.testsekolah.response.ApiResponse;
import com.derrysetya.testsekolah.service.MapelService;
import com.derrysetya.testsekolah.service.SiswaService;
import com.derrysetya.testsekolah.utils.ResponseUtils;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("${rest.pathPrefix:api}/mapel")
public class MapelController {
	
	@Autowired
	MapelService service;
	
	@GetMapping(value = "/list-combo-box")
	ApiResponse getListSelectOptions(){
		ApiResponse resp = new ApiResponse();
		List<ComboBoxProjection> listModel = new ArrayList<>();
		
		try {
			
			listModel = service.getListSelectOptProjections();
			
			resp = ResponseUtils.getSuccess();
			
			resp.setResult(listModel);
			
			return resp;
		} catch (Exception e) {
			// TODO: handle exception
			
			System.out.println("Error get list combo box");
			System.out.println(e.getMessage());
			
			resp = ResponseUtils.getFailed();
			
			return resp;
		}
	}
	
	@PostMapping(value = "/save")
	ApiResponse save(@RequestBody MapelModel model){
		ApiResponse resp = new ApiResponse();
		MapelModel newMapel = new MapelModel();
		
		try {
			
			newMapel = service.save(model);
			
			resp = ResponseUtils.getSuccess();
			
			resp.setResult(newMapel);
			
			return resp;
		} catch (Exception e) {
			// TODO: handle exception
			
			System.out.println("Error save mapel");
			System.out.println(e.getMessage());
			
			resp = ResponseUtils.getFailed();
			
			return resp;
		}
	}
	
	@GetMapping(value = "/all")
	ApiResponse getAll(){
		ApiResponse resp = new ApiResponse();
		List<MapelModel> listMapel = new ArrayList<>();
		
		try {
			
			listMapel = service.getAll();
			
			resp = ResponseUtils.getSuccess();
			
			resp.setResult(listMapel);
			
			return resp;
		} catch (Exception e) {
			// TODO: handle exception
			
			System.out.println("Error get all mapel");
			System.out.println(e.getMessage());
			
			resp = ResponseUtils.getFailed();
			
			return resp;
		}
	}
	
	@GetMapping(value = "/dash")
	ApiResponse getDash(){
		ApiResponse resp = new ApiResponse();
		List<DashMapelProjection> listMapel = new ArrayList<>();
		
		try {
			
			listMapel = service.getDash();
			
			resp = ResponseUtils.getSuccess();
			
			resp.setResult(listMapel);
			
			return resp;
		} catch (Exception e) {
			// TODO: handle exception
			
			System.out.println("Error get all mapel");
			System.out.println(e.getMessage());
			
			resp = ResponseUtils.getFailed();
			
			return resp;
		}
	}
	
	@GetMapping()
	ApiResponse getById(@RequestParam(required = true, name = "id") String id){
		ApiResponse resp = new ApiResponse();
		MapelModel model = new MapelModel();
		
		try {
			
			model = service.getById(Long.valueOf(id));
			
			resp = ResponseUtils.getSuccess();
			
			resp.setResult(model);
			
			return resp;
		} catch (Exception e) {
			// TODO: handle exception
			
			System.out.println("Error get mapel by "+id);
			System.out.println(e.getMessage());
			
			resp = ResponseUtils.getFailed();
			
			return resp;
		}
		
	}
	
	@PostMapping(value = "/delete")
	ApiResponse deleteByid(@RequestParam(required = true, name = "id") String id){
		ApiResponse resp = new ApiResponse();
		MapelModel model = service.getById(Long.valueOf(id));
		
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
			
			System.out.println("Error delete mapel by "+id);
			System.out.println(e.getMessage());
			
			resp = ResponseUtils.getFailed();
			
			return resp;
		}
		
		
		
	}

}
