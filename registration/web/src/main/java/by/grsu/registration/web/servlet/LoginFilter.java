package by.grsu.registration.web.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter {

	private static final String PAGE = "/web/login";
	
	private static final String PARAMETR_URI = "uri";
	private static final String PARAMETR_IS_LOGIN = "is_login";

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpSession session = req.getSession(true);

		String requestURI = req.getRequestURI();
		req.getSession().setAttribute(PARAMETR_URI, requestURI);

		if (session.getAttribute(PARAMETR_IS_LOGIN) == null || !session.getAttribute(PARAMETR_IS_LOGIN).equals(true)) {
			resp.sendRedirect(PAGE);
		} else {
			chain.doFilter(req, resp);
		}
	}

	@Override
	public void destroy() {
		
	}

}
