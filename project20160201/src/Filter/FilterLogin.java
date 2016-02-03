package Filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import _00_register.MemberBean;

/**
 * Servlet Filter implementation class FilterLogin
 */
@WebFilter(
		urlPatterns = { "/*" }, 
		initParams = { 
		@WebInitParam(name = "url_1", value = "/_02_memodify/*"), 
		@WebInitParam(name = "url_6", value = "/_06_shoppingcar/*") 
		}
		)
public class FilterLogin implements Filter {
	String contextPath;
	Collection<String> url = new ArrayList<>();
	public FilterLogin() {

	}

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		contextPath = req.getContextPath();
		//System.out.println("contextPath="+contextPath);
		String servletPath = req.getServletPath();
		if (mustLogin(servletPath)) {
			if (checkLogin(req)) {
				
				chain.doFilter(request, response);

			} else {
				HttpSession session = req.getSession();
				session.setAttribute("target", servletPath);
				resp.sendRedirect(contextPath + "/_01_login/login.jsp");
//				RequestDispatcher rd = req
//						.getRequestDispatcher("/_01_login/login.jsp");
//				rd.forward(request, response);

			}
		} else {
			chain.doFilter(request, response);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {				
		Enumeration<String> e = fConfig.getInitParameterNames();
		while (e.hasMoreElements()) {
			String name = e.nextElement();
			url.add(fConfig.getInitParameter(name));
		}
	}
	
	private boolean mustLogin(String servletPath){
		boolean login = false;
		for(String sURL:url){
			if(sURL.endsWith("*")){
				sURL = sURL.substring(0,sURL.length()-1);
				if(servletPath.startsWith(sURL)){
					login = true;
					break;
				}
			}else{
				if(servletPath.equals(sURL)){
					login= true;
					break;
				}
			}
		}
		return login;
	}

	public boolean checkLogin(HttpServletRequest req) {
		HttpSession session = req.getSession();
		MemberBean ch = (MemberBean)session.getAttribute("LoginOK");
		//System.out.println(ch);
		if (ch == null) {
			return false;
		} else {
			return true;
		}
	}

}
