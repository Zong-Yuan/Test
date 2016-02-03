package _06_shoppingcar.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(
		urlPatterns=("/_06_shoppingcar/controller/shoppingcar.con")
		)
public class ShowProServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse respone)
			throws ServletException, IOException {
		ShowProService service = new ShowProService();
		List<ProductBean> result= new ArrayList<ProductBean>();
		result = service.select();
		request.setAttribute("result", result);	
		request.getRequestDispatcher("/_06_shoppingcar/show.jsp").forward(request, respone);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

}
