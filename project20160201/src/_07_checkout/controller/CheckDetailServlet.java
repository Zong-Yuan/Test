package _07_checkout.controller;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import _00_register.MemberBean;
import _06_shoppingcar.controller.ShoppingCar;

public class CheckDetailServlet extends ActionSupport implements SessionAware{
	private ProdOrderBean orderBean;
	String radio;
	public ProdOrderBean getOrderBean() {
		return orderBean;
	}
	public void setOrderBean(ProdOrderBean orderBean) {
		this.orderBean = orderBean;
	}
	public void setRadio(String radio) {
		this.radio = radio;
	}
	public String getRadio() {
		return radio;
	}
	@Override
	public void validate() {
		if(orderBean.getAddressee() == null || orderBean.getAddressee().trim().isEmpty()){
			this.addFieldError("addressee", this.getText("addressee.error"));
		}
		if(orderBean.getAddress() == null || orderBean.getAddress().trim().isEmpty()){
			this.addFieldError("address", this.getText("address.error"));
		}
		if(orderBean.getPhone() == 0 ){
			this.addFieldError("phone", this.getText("phone.error"));
		}
		if(orderBean.getSender() == null || orderBean.getSender().trim().isEmpty()){
			this.addFieldError("sender", this.getText("sender.error"));
		}
		if(orderBean.getSender_address() == null || orderBean.getSender_address().trim().isEmpty()){
			this.addFieldError("sender_address", this.getText("sender_address.error"));
		}
		if(orderBean.getSender_phone() == 0 ){
			this.addFieldError("sender_phone", this.getText("sender_phone.error"));
		}
	}
	
	
	private Map<String,Object> session ;
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	@Override
	public String execute() throws Exception {
		MemberBean memBean = (MemberBean)session.get("LoginOK");
		ShoppingCar shopcar= (ShoppingCar)session.get("shopcar");
		return "xxx";
	}

	
	
}
