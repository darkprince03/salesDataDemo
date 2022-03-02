package com.salesdata.app.repository;

import java.util.List;
import java.util.Map;

import com.salesdata.app.entity.SalesDataEntity;
import com.salesdata.app.model.SalesDataModel;

public interface SalesDataRepository {
	public List<SalesDataEntity> getSalesData();
	
	public List<SalesDataEntity> getSalesData(SalesDataModel salesData);

	public List<Map<String, Object>> getSalesDataFields(SalesDataModel salesData);
}
