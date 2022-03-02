package com.salesdata.app.controller;

import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.salesdata.app.entity.SalesDataEntity;
import com.salesdata.app.model.SalesDataModel;
import com.salesdata.app.service.SalesDataService;

@RestController
public class SalesDataController {

	@Autowired
	private SalesDataService salesDataService;
	
	@GetMapping("/getAll")
	public List<SalesDataEntity> getData(){
		return salesDataService.getSalesData();
	}
	
	@SuppressWarnings("unchecked")
	@GetMapping("/getSalesData")
	public JSONObject getSalesData(@RequestBody SalesDataModel salesDataparams) {
		JSONObject result = new JSONObject();
		try {
			
			List<SalesDataEntity> data = salesDataService.getSalesData(salesDataparams);
			result.put("result", data);
			System.out.println(salesDataparams);
			System.out.println(result);
		} catch(Exception e) {
			System.out.println(e);
			
		}
		
		return result;
		
	}
	
	@GetMapping("/getSalesDataFields")
	public JSONObject getSalesDataFields(@RequestBody SalesDataModel salesDataparams) {
		JSONObject result = new JSONObject();
		try {
			
			List<Map<String, Object>> data = salesDataService.getSalesDataFields(salesDataparams);
			result.put("result", data);
			System.out.println(salesDataparams);
			System.out.println(result);
		} catch(Exception e) {
			System.out.println(e);
			
		}
		
		return result;
		
	}
}

