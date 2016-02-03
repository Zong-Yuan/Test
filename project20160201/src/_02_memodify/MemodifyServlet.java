package _02_memodify;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import _00_register.MemberBean;

@WebServlet("/_02_memodify/member.do")
public class MemodifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		MemodifyService mdse = new MemodifyService();
		HttpSession session = request.getSession();
		MemberBean mb = (MemberBean)session.getAttribute("LoginOK");
//		MemberBean mb1 =  mdse.Memodify(mb.getMail());
		if(mb.getGender().equals("男")){
			session.setAttribute("gender", 1);
		}else{
			session.setAttribute("gender", 2);
		}
		session.setAttribute("mem", mb);
		System.out.println(mb);
		RequestDispatcher rd = request
				.getRequestDispatcher("/_02_member/member.jsp");
		rd.forward(request, response);
		
	}

}
