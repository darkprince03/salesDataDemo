package com.salesdata.app.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesdata.app.entity.SalesDataEntity;
import com.salesdata.app.model.SalesDataModel;
import com.salesdata.app.repository.SalesDataRepository;
import com.salesdata.app.service.SalesDataService;

@Service
public class SalesDataServiceImpl implements SalesDataService{
	
	@Autowired
	private SalesDataRepository salesrepo;

	@Override
	public List<SalesDataEntity> getSalesData() {
		List<SalesDataEntity> result = null;
		result = salesrepo.getSalesData();
		return result;
	}

	@Override
	public List<SalesDataEntity> getSalesData(SalesDataModel salesData) {
		List<SalesDataEntity> result = null;
		result = salesrepo.getSalesData(salesData);
		return result;
	}
	
	@Override
	public List<Map<String, Object>> getSalesDataFields(SalesDataModel salesData){
		List<Map<String, Object>> result = null;
		result = salesrepo.getSalesDataFields(salesData);
		return result;
	}
	
	
}
