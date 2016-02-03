package _06_shoppingcar.controller;

public class CarDetailBean {
	private int shoppingcart_Id;
	private int mem_Id;
	private int seller_Id;
	private int prod_Id;
	private String prod_Name;
	private java.util.Date ord_Date;
	private int price;
	private int count;
	private int subtotal;
	private String ship;
	private int ord_Point;
	
	@Override
	public String toString() {
		return "CarDetailBean [shoppingcart_Id=" + shoppingcart_Id
				+ ", mem_Id=" + mem_Id + ", seller_Id=" + seller_Id
				+ ", prod_Id=" + prod_Id + ", prod_Name=" + prod_Name
				+ ", ord_Date=" + ord_Date + ", price=" + price + ", count="
				+ count + ", subtotal=" + subtotal + ", ship=" + ship
				+ ", ord_Point=" + ord_Point + "]";
	}
	public int getShoppingcart_Id() {
		return shoppingcart_Id;
	}
	public void setShoppingcart_Id(int shoppingcart_Id) {
		this.shoppingcart_Id = shoppingcart_Id;
	}
	public int getMem_Id() {
		return mem_Id;
	}
	public void setMem_Id(int mem_Id) {
		this.mem_Id = mem_Id;
	}
	public int getSeller_Id() {
		return seller_Id;
	}
	public void setSeller_Id(int seller_Id) {
		this.seller_Id = seller_Id;
	}
	public int getProd_Id() {
		return prod_Id;
	}
	public void setProd_Id(int prod_Id) {
		this.prod_Id = prod_Id;
	}
	public String getProd_Name() {
		return prod_Name;
	}
	public void setProd_Name(String prod_Name) {
		this.prod_Name = prod_Name;
	}
	public java.util.Date getOrd_Date() {
		return ord_Date;
	}
	public void setOrd_Date(java.util.Date ord_Date) {
		this.ord_Date = ord_Date;
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
	public String getShip() {
		return ship;
	}
	public void setShip(String ship) {
		this.ship = ship;
	}
	public int getOrd_Point() {
		return ord_Point;
	}
	public void setOrd_Point(int ord_Point) {
		this.ord_Point = ord_Point;
	}
	
}
