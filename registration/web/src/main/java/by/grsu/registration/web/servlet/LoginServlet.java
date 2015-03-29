package by.grsu.registration.web.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.grsu.registration.model.User;
import by.grsu.registration.model.enumeration.Role;
import by.grsu.registration.web.controller.UserController;


@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {

	private static final String page = "login.jsp";

	private static final String PARAMETR_LOGIN = "login";
	private static final String PARAMETR_PASSWORD = "password";
	private static final String PARAMETR_USER = "user";
	private static final String PARAMETR_IS_LOGIN = "is_login";
	
	private UserController controller;

	public LoginServlet(){
		controller = new UserController();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(page);
		if (dispatcher != null) {
			dispatcher.forward(request, response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter(PARAMETR_LOGIN);
		String password = request.getParameter(PARAMETR_PASSWORD);
		User user = controller.getUser(login, password);
		if (user != null && user.getPassword().equals(password)) {
			request.getSession().setAttribute(PARAMETR_USER, login);
			request.getSession().setAttribute(PARAMETR_IS_LOGIN, true);
			request.getSession().setAttribute("message", "Success login");
			if(user.getRole() == Role.ADMIN){
				response.sendRedirect("/web/admin");
			} else {
				response.sendRedirect("/web/index");
			}
		} else {
			request.getSession().setAttribute("message", "Not correct user");
			response.sendRedirect("/web/login");
		}
		
	}

}
