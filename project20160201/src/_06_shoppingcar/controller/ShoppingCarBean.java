package _06_shoppingcar.controller;

public class ShoppingCarBean {
	private int shoppingCart_Id;
	private int mem_Id;
	private java.util.Date ord_Date;
	private int total;
	
	
	
	
	
	
	@Override
	public String toString() {
		return "ShoppingCarBean [shoppingCart_Id=" + shoppingCart_Id + ", mem_Id=" + mem_Id + ", ord_Date=" + ord_Date
				+ ", total=" + total + "]";
	}
	public int getShoppingCart_Id() {
		return shoppingCart_Id;
	}
	public void setShoppingCart_Id(int shoppingCart_Id) {
		this.shoppingCart_Id = shoppingCart_Id;
	}
	public int getMem_Id() {
		return mem_Id;
	}
	public void setMem_Id(int mem_Id) {
		this.mem_Id = mem_Id;
	}
	public java.util.Date getOrd_Date() {
		return ord_Date;
	}
	public void setOrd_Date(java.util.Date ord_Date) {
		this.ord_Date = ord_Date;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	
		
}
