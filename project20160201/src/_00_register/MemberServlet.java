package _00_register;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/_00_register/register.do")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		Map<String, String> ermsg = new HashMap<>();
		
		//request.setAttribute("insertmember", ermsg);
		session.setAttribute("insertmember", ermsg);
		String mail = request.getParameter("mail");
		if (mail == null || mail.trim().length() == 0) {
			ermsg.put("errormail", "帳號不可空白");
		}
		String pwd = request.getParameter("pwd");
		if (pwd == null || pwd.trim().length() == 0) {
			ermsg.put("errorpwd", "密碼不可空白");
		}
		String mem_name = request.getParameter("mem_name");
		if (mem_name == null || mem_name.trim().length() == 0) {
			ermsg.put("errorname", "姓名不可空白");
		}
		String identification = request.getParameter("identification");
		if (identification == null || identification.trim().length() == 0) {
			ermsg.put("errorid", "身分證不可空白");
		}
		String gender = request.getParameter("gender");
		if (gender == null || gender.trim().length() == 0) {
			ermsg.put("errorgender", "性別必選");
		}
		String bdate = request.getParameter("bdate");
		if (bdate == null || bdate.trim().length() == 0) {
			ermsg.put("errorbdate", "生日不可空白");
		}
		

		
		// 設定日期格式
		// 進行轉換
		java.util.Date date = null;
		if (bdate != null && bdate.trim().length() > 0) {
			try {
				date = java.sql.Date.valueOf(bdate);
			} catch (IllegalArgumentException e) {
				ermsg.put("errorbdate", "生日格式錯誤");
			}
		}
		if (gender != null) {
			if (gender.equals("1"))
				gender = "男";
			else
				gender = "女";
		}
				
		if (! ermsg.isEmpty() ) {
			RequestDispatcher rd = request.getRequestDispatcher("/_00_register/register.jsp");
			rd.forward(request, response);
	
			return;

		}
//		
//		System.out.println(11);
//		
//		MemberDAO Memberdao = new MemberDAO();
//		System.out.println(mb);
//		Memberdao.insert(mb);
//		RequestDispatcher r = request.getRequestDispatcher("success.jsp");
//		r.forward(request, response);
		
		try {
			MemberService msc = new MemberService();
			msc.member(mail, pwd, mem_name, identification, gender, date);
			//System.out.println("date="+date);
			msc.insert();
			RequestDispatcher rd = request.getRequestDispatcher("/_00_register/success.jsp");
			rd.forward(request, response);
//			response.sendRedirect(
//					response.encodeRedirectURL("success.jsp"));
			return;
		} catch (SQLException e) {
			if (e.getMessage().indexOf("插入重複的索引鍵") != -1
					|| e.getMessage().indexOf("Duplicate entry") != -1) {
				ermsg.put("errorDB","帳號重複，請重新輸入帳號");
			} else {
				System.out.println(e.getMessage());
				ermsg.put("errorDB","資料庫存取錯誤");				
			}
			RequestDispatcher rd = request.getRequestDispatcher("/_00_register/error.jsp");
			rd.forward(request, response);
			//response.sendRedirect("error.jsp");
			return;
		}
	}

}
