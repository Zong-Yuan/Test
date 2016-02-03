package _01_login;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import _00_register.MemberBean;
import _99_star.Allmember;

@WebServlet("/_01_login/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		Map<String, String> error = new HashMap<>();

		request.setAttribute("loginerror", error);
		HttpSession session = request.getSession();
		String mail = request.getParameter("mail");
		String pwd = request.getParameter("pwd");
		MemberBean sec = (MemberBean) session.getAttribute("LoginOK");

		if (sec == null) {
			if (mail == null || mail.trim().length() == 0) {
				error.put("errormail", "帳號不可空白");
			}
			if (pwd == null || pwd.trim().length() == 0) {
				error.put("errorpwd", "密碼不可空白");
			}
			LoginService lse = new LoginService();
			Object obj;
			String ch = null;
			MemberBean mbb = null;
			// System.out.println("ch=" + ch);
			obj = lse.cheakID(mail, pwd);
			if (obj.equals("密碼錯誤")) {
				ch = (String) obj;
				//System.out.println("ch"+ch);
			} else if (obj.equals("帳號不存在")) {
				ch = (String) obj;
			} else {
				mbb = (MemberBean) obj;
				ch="正確";
				//System.out.println("mbb "+ mbb);
			}
			if (!error.isEmpty()) {
				// System.out.println("1");
				RequestDispatcher rd = request
						.getRequestDispatcher("/_01_login/login.jsp");
				rd.forward(request, response);
				return;
			}

			if (error.isEmpty() && ch.equals("密碼錯誤")) {
				// System.out.println("2");
				error.put("error", "密碼錯誤");
				RequestDispatcher rd = request
						.getRequestDispatcher("/_01_login/login.jsp");
				rd.forward(request, response);
				return;
			}

			if (error.isEmpty() && ch.equals("帳號不存在")) {
				// System.out.println("3");
				error.put("error", "帳號不存在");
				RequestDispatcher rd = request
						.getRequestDispatcher("/_01_login/login.jsp");
				rd.forward(request, response);
				return;

			}

			
			if (error.isEmpty() && ch != null) {
				// System.out.println("4");
				session.setAttribute("LoginOK", mbb);
				String target = (String) session.getAttribute("target");
				if (target != null) {

					response.sendRedirect(response
							.encodeRedirectURL(getServletContext()
									.getContextPath() + target));
					session.removeAttribute("target");
					// RequestDispatcher rd =
					// request.getRequestDispatcher("/index.jsp");
					// rd.forward(request, response);
					return;
				} else {
					String ta = (String) session.getAttribute("target");
					//System.out.println(ta);
					// System.out.println("5");
					RequestDispatcher rd = request
							.getRequestDispatcher("/_01_login/success.jsp");
					rd.forward(request, response);
					//System.out.println("mb111" + mbb);
				}
			}

		}
	}
}
