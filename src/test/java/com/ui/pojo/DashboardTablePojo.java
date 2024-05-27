package com.ui.pojo;

public class DashboardTablePojo {

	private String oem;
	private String job_number;
	private String imei;
	private String product;
	private String model;
	private String warranty_status;
	private String action_status;

	public DashboardTablePojo(String oem, String job_number, String imei, String product, String model,
			String warranty_status, String action_status) {
		super();
		this.oem = oem;
		this.job_number = job_number;
		this.imei = imei;
		this.product = product;
		this.model = model;
		this.warranty_status = warranty_status;
		this.action_status = action_status;
	}

	public String getOem() {
		return oem;
	}

	public void setOem(String oem) {
		this.oem = oem;
	}

	public String getJob_number() {
		return job_number;
	}

	public void setJob_number(String job_number) {
		this.job_number = job_number;
	}

	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getWarranty_status() {
		return warranty_status;
	}

	public void setWarranty_status(String warranty_status) {
		this.warranty_status = warranty_status;
	}

	public String getAction_status() {
		return action_status;
	}

	public void setAction_status(String action_status) {
		this.action_status = action_status;
	}

	@Override
	public String toString() {
		return "DashboardTablePojo [oem=" + oem + ", job_number=" + job_number + ", imei=" + imei + ", product="
				+ product + ", model=" + model + ", warranty_status=" + warranty_status + ", action_status="
				+ action_status + "]";
	}

}
