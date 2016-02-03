package _06_shoppingcar.controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import _00_register.MemberBean;

@WebServlet(urlPatterns = { "/_06_shoppingcar/controller/BuyProServlet.con" })
public class BuyProServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse respone) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String product = request.getParameter("product");
		String brand = request.getParameter("brand");
		String price = request.getParameter("price");
		String count = request.getParameter("count");

		// System.out.println("id=" +id +"product=" + product + "price="+price
		// +"count="+count);
		HttpSession session = request.getSession();
		MemberBean mb = (MemberBean) session.getAttribute("LoginOK");
		// System.out.println(mb);
		if (mb == null) {

			respone.sendRedirect(getServletContext().getContextPath()
					+ "/_01_login/login.jsp");
			// request.getRequestDispatcher("/_01_login/login.jsp").forward(request,
			// respone);
			return;
		}
		ShoppingCar car = (ShoppingCar) session.getAttribute("shopcar");
		if (car == null) {
			car = new ShoppingCar();
			session.setAttribute("shopcar", car);
		}
		Map<String, String> error = new HashMap<>();
		request.setAttribute("error", error);
		BuyProService service = new BuyProService();
		ProductBean proBean = service.findPro(Integer.parseInt(id));
		if (Integer.parseInt(count) > proBean.getCount()) {
			error.put("count", "數量不足");
			request.getRequestDispatcher(
					"/_06_shoppingcar/controller/shoppingcar.con").forward(
					request, respone);
			return;
		}
		
		ShoppingCarBean carBean = new ShoppingCarBean();
		MemberBean memBean = new MemberBean();
		memBean = (MemberBean) session.getAttribute("LoginOK");
		//int pk = 0;
		if (car.getCar().get(id) == null) {
			
	
				CarDetailBean carDetail = new CarDetailBean();
				//carDetail.setShoppingcart_Id(pk);
				carDetail.setMem_Id(memBean.getMem_id());
				carDetail.setSeller_Id(proBean.getMemId());
				carDetail.setProd_Id(proBean.getProdId());
				carDetail.setProd_Name(proBean.getProductName());
				carDetail.setOrd_Date(new java.util.Date());
				carDetail.setPrice(proBean.getPrice());
				carDetail.setCount(1);
				carDetail.setSubtotal(proBean.getPrice()
						* Integer.parseInt(count));
				carDetail.setShip("");
				carDetail.setOrd_Point(0);
			
			if (proBean != null) {
				
				carBean.setMem_Id(memBean.getMem_id());
				carBean.setOrd_Date(new java.util.Date());
				carBean.setTotal(proBean.getPrice() * Integer.parseInt(count));
				service.insertShopCar(carBean, car , carDetail, id);
			}
//			if (pk != 0) {
//				CarDetailBean carDetail = new CarDetailBean();
//				carDetail.setShoppingcart_Id(pk);
//				carDetail.setMem_Id(memBean.getMem_id());
//				carDetail.setSeller_Id(proBean.getMemId());
//				carDetail.setProd_Id(proBean.getProdId());
//				carDetail.setProd_Name(proBean.getProductName());
//				carDetail.setOrd_Date(new java.util.Date());
//				carDetail.setPrice(proBean.getPrice());
//				carDetail.setCount(1);
//				carDetail.setSubtotal(proBean.getPrice()
//						* Integer.parseInt(count));
//				carDetail.setShip("");
//				carDetail.setOrd_Point(0);
//				service.insertCarDetail(carDetail, conn);
//
//				car.addToCar(id, carDetail);
//			}
			
		} else {
			error.put("exist", "已加入購物車");
		}
		// System.out.println(id);
		// car.addToCar(id, bean);

		// request.setAttribute("car", list);

		request.getRequestDispatcher(
				"/_06_shoppingcar/controller/shoppingcar.con").forward(request,
				respone);
	}

}
