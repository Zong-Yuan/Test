package _07_checkout.controller;

public class OrdDetailBean {
	//private int ord_id;
	private ProdOrderBean prodBean;
	
	private int mem_id;
	private int seller_id;
	private int prod_id;
	private String prod_name;
	private int price;
	private int count;
	private int subtotal;
	private int ord_point;
	private java.util.Date ord_date;
//	public int getOrd_id() {
//		return ord_id;
//	}
//	public void setOrd_id(int ord_id) {
//		this.ord_id = ord_id;
//	}
	
	
	public int getMem_id() {
		return mem_id;
	}
	public ProdOrderBean getProdBean() {
		return prodBean;
	}
	public void setProdBean(ProdOrderBean prodBean) {
		this.prodBean = prodBean;
	}
	public void setMem_id(int mem_id) {
		this.mem_id = mem_id;
	}
	public int getSeller_id() {
		return seller_id;
	}
	public void setSeller_id(int seller_id) {
		this.seller_id = seller_id;
	}
	public int getProd_id() {
		return prod_id;
	}
	public void setProd_id(int prod_id) {
		this.prod_id = prod_id;
	}
	public String getProd_name() {
		return prod_name;
	}
	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(int subtotal) {
		this.subtotal = subtotal;
	}
	public int getOrd_point() {
		return ord_point;
	}
	public void setOrd_point(int ord_point) {
		this.ord_point = ord_point;
	}
	public java.util.Date getOrd_date() {
		return ord_date;
	}
	public void setOrd_date(java.util.Date ord_date) {
		this.ord_date = ord_date;
	}
	
	
}
