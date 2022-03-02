package com.salesdata.app.model;

public class SalesDataModel {
	private String invoiceId;
	private String branch;
	private String city;
	private String customerType;
	private Double total;
	private String orderBy;
	private String[] fields;
	

	public String getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(String invoiceId) {
		this.invoiceId = invoiceId;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}
	
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	public String[] getFields() {
		return fields;
	}

	public void setFields(String[] fields) {
		this.fields = fields;
	}

	@Override
	public String toString() {
		return getInvoiceId() + " ---  " + getBranch() + " ---- " + getCity();
	}
	
	public int getCount() {
		int count = 0;
		if(this.invoiceId != null && !this.invoiceId.isBlank())
			count++;
		if(this.branch != null && !this.branch.isBlank())
			count++;
		if(this.city != null && !this.city.isBlank())
			count++;
		if(this.customerType != null && !this.customerType.isBlank())
			count++;
		if(this.total != null)
			count++;
		
		return count;
	}

}
