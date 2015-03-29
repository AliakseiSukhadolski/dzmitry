package by.grsu.registration.web.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@SuppressWarnings("serial")
public class AddUserServlet extends HttpServlet {

	private static final String PAGE1 = "add_user.jsp";
	private static final String PAGE2 = "/";
	
	private static final String PARAMETR_LOGIN = "login";
	private static final String PARAMETR_PASSWORD = "password";
	private static final String PARAMETR_USER = "user";
	private static final String PARAMETR_IS_LOGIN = "is_login";

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(PAGE1);
		if (dispatcher != null) {
			dispatcher.forward(request, response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter(PARAMETR_LOGIN);
		String password1 = request.getParameter(PARAMETR_PASSWORD);
		request.getSession().setAttribute(PARAMETR_USER, login);
		request.getSession().setAttribute(PARAMETR_IS_LOGIN, true);
		
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher(PAGE2);
		if (dispatcher != null) {
			dispatcher.forward(request, response);
		}
	}

}
