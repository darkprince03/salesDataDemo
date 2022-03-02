package com.salesdata.app.service;

import java.util.List;
import java.util.Map;

import com.salesdata.app.entity.SalesDataEntity;
import com.salesdata.app.model.SalesDataModel;

public interface SalesDataService {
	public List<SalesDataEntity> getSalesData();
	
	public List<SalesDataEntity> getSalesData(SalesDataModel salesData);

	public List<Map<String, Object>> getSalesDataFields(SalesDataModel salesData);
}
