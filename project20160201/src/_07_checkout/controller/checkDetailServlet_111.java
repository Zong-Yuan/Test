package _07_checkout.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import _06_shoppingcar.controller.ShoppingCar;


@WebServlet(
			urlPatterns="/_07_checkout/controller/checkDetailServlet.con"
		)
public class checkDetailServlet_111 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse respone)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String addressee = request.getParameter("addressee");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String sender = request.getParameter("sender");
		String sender_address = request.getParameter("sender_address");
		String sender_phone = request.getParameter("sender_phone");
		String radio = request.getParameter("radio");
		//System.out.println(radio);
		
		HttpSession session = request.getSession();
		ShoppingCar shoppcar = (ShoppingCar)session.getAttribute("shopcar");
		
		
		
		
	}
	
}
