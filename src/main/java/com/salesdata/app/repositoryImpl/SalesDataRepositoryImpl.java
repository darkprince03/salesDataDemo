package com.salesdata.app.repositoryImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Selection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.salesdata.app.entity.SalesDataEntity;
import com.salesdata.app.model.SalesDataModel;
import com.salesdata.app.repository.SalesDataRepository;

@Repository
@Transactional
public class SalesDataRepositoryImpl implements SalesDataRepository {

	@Autowired
	private SessionFactory sessionfactory;
	
	private Session getSession() {
		Session session = sessionfactory.getCurrentSession();
		if(session == null) {
			session = sessionfactory.openSession(); 
		}
		return session;
	}
	
	@Override
	public List<SalesDataEntity> getSalesData(){
		List<SalesDataEntity> results = new ArrayList<>();
		try {
			CriteriaBuilder cb = getSession().getCriteriaBuilder();
			CriteriaQuery<SalesDataEntity> cr = cb.createQuery(SalesDataEntity.class);
			Root<SalesDataEntity> root = cr.from(SalesDataEntity.class);
			cr.select(root);
			

			TypedQuery<SalesDataEntity> query = getSession().createQuery(cr);
			results = query.getResultList();
		} catch(Exception e) {
			System.out.println(e);
		}
		
		return results;
	}
	
	@Override
	public List<SalesDataEntity> getSalesData(SalesDataModel salesData){
		List<SalesDataEntity> results = null;
		try {
			CriteriaBuilder cb = getSession().getCriteriaBuilder();
			CriteriaQuery<SalesDataEntity> cr = cb.createQuery(SalesDataEntity.class);
			Root<SalesDataEntity> root = cr.from(SalesDataEntity.class);
			
			int count = salesData.getCount();
			int i = 0;
			Predicate[] pre = new Predicate[count];
			if(salesData.getInvoiceId() != null && !salesData.getInvoiceId().isBlank()) {
				pre[i++] = cb.equal(root.get("invoiceId"), salesData.getInvoiceId());
			}
			if(salesData.getBranch() != null && !salesData.getBranch().isBlank()) {
				pre[i++] = cb.equal(root.get("branch"), salesData.getBranch());
			}
			if(salesData.getCity() != null && !salesData.getCity().isBlank()) {
				pre[i++] = cb.equal(root.get("city"), salesData.getCity());
			}
			if(salesData.getCustomerType() != null && !salesData.getCustomerType().isBlank()) {
				pre[i++] = cb.equal(root.get("customerType"), salesData.getCustomerType());
			}
			if(salesData.getTotal() != null) {
				pre[i++] = cb.ge(root.get("total"), salesData.getTotal());
			}
			cr.select(root).where(pre);
			if(salesData.getOrderBy()!=null && !salesData.getOrderBy().isBlank()) {
				cr.orderBy(cb.asc(root.get(salesData.getOrderBy())));
			}

			TypedQuery<SalesDataEntity> query = getSession().createQuery(cr);
			results = query.getResultList();
		} catch(Exception e) {
			System.out.println(e);
		}
		
		return results;
	}
	
	
	@Override
	public List<Map<String, Object>> getSalesDataFields(SalesDataModel salesData){
		List<Object[]> results = null;
		List<Map<String, Object>> resultList = new ArrayList<>();
		try {
			CriteriaBuilder cb = getSession().getCriteriaBuilder();
			CriteriaQuery<Object[]> cr = cb.createQuery(Object[].class);
			Root<SalesDataEntity> root = cr.from(SalesDataEntity.class);
			
			int count = salesData.getCount();
			int i = 0;
			Predicate[] pre = new Predicate[count];
			if(salesData.getInvoiceId() != null && !salesData.getInvoiceId().isBlank()) {
				pre[i++] = cb.equal(root.get("invoiceId"), salesData.getInvoiceId());
			}
			if(salesData.getBranch() != null && !salesData.getBranch().isBlank()) {
				pre[i++] = cb.equal(root.get("branch"), salesData.getBranch());
			}
			if(salesData.getCity() != null && !salesData.getCity().isBlank()) {
				pre[i++] = cb.equal(root.get("city"), salesData.getCity());
			}
			if(salesData.getCustomerType() != null && !salesData.getCustomerType().isBlank()) {
				pre[i++] = cb.equal(root.get("customerType"), salesData.getCustomerType());
			}
			if(salesData.getTotal() != null) {
				pre[i++] = cb.ge(root.get("total"), salesData.getTotal());
			}
			
			
			List<Selection<?>> sel = new ArrayList<>();
			String[] fields = salesData.getFields();
			if(fields!=null && fields.length!=0) {
				for(String field: fields) {
					sel.add(root.get(field));
				}
			} 
			cr.multiselect(sel).where(pre);
			
			
			if(salesData.getOrderBy()!=null && !salesData.getOrderBy().isBlank()) {
				cr.orderBy(cb.asc(root.get(salesData.getOrderBy())));
			}

			TypedQuery<Object[]> query = getSession().createQuery(cr);
			results = query.getResultList();
			results.forEach(s -> {
				Map<String, Object> resMap = new HashMap<>();
				for(int j=0;j<fields.length;j++) {
					resMap.put(fields[j], s[j]);
				}
				resultList.add(resMap);
			});
		} catch(Exception e) {
			System.out.println(e);
		}
		
		return resultList;
	}
}
