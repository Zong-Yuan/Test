package _07_checkout.controller;

import java.util.HashSet;
import java.util.Set;

public class ProdOrderBean {
	// private int ord_id;
	private Set<OrdDetailBean> detailBean = new HashSet<>();
	private int mem_id;
	private String addressee;
	private String address;
	private int phone;
	private String sender;
	private String sender_address;
	private int sender_phone;
	private String payment;
	private String payment_status;
	private java.util.Date ord_date;
	private int total;
	private int total_point;

	public Set<OrdDetailBean> getDetailBean() {
		return detailBean;
	}

	public void setDetailBean(Set<OrdDetailBean> detailBean) {
		this.detailBean = detailBean;
	}

	// public int getOrd_id() {
	// return ord_id;
	// }
	// public void setOrd_id(int ord_id) {
	// this.ord_id = ord_id;
	// }
	public int getMem_id() {
		return mem_id;
	}

	public void setMem_id(int mem_id) {
		this.mem_id = mem_id;
	}

	public String getAddressee() {
		return addressee;
	}

	public void setAddressee(String addressee) {
		this.addressee = addressee;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getSender_address() {
		return sender_address;
	}

	public void setSender_address(String sender_address) {
		this.sender_address = sender_address;
	}

	public int getSender_phone() {
		return sender_phone;
	}

	public void setSender_phone(int sender_phone) {
		this.sender_phone = sender_phone;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public String getPayment_status() {
		return payment_status;
	}

	public void setPayment_status(String payment_status) {
		this.payment_status = payment_status;
	}

	public java.util.Date getOrd_date() {
		return ord_date;
	}

	public void setOrd_date(java.util.Date ord_date) {
		this.ord_date = ord_date;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getTotal_point() {
		return total_point;
	}

	public void setTotal_point(int total_point) {
		this.total_point = total_point;
	}

}
