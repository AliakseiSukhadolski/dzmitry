package by.grsu.registration.web.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@SuppressWarnings("serial")
public class LogoutServlet  extends HttpServlet {

	private static final String PAGE = "/";

	private static final String PARAMETR_USER = "user";
	private static final String PARAMETR_IS_LOGIN = "is_login";

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().setAttribute(PARAMETR_USER, null);
		request.getSession().setAttribute(PARAMETR_IS_LOGIN, false);

		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher(PAGE);
		if (dispatcher != null) {
			dispatcher.forward(request, response);
		}
	}

}
