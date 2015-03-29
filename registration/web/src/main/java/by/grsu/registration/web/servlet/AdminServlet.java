package by.grsu.registration.web.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.grsu.registration.model.RegisterDate;
import by.grsu.registration.web.controller.DateController;


public class AdminServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3741744289152856785L;
	
	private static final String page = "admin.jsp";
	private static final String PARAMETR_IS_LOGIN = "is_login";
	
	private SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
	
	private DateController dateController;
	
	public AdminServlet(){
		dateController = new DateController();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Boolean isLogged = (Boolean)request.getSession().getAttribute(PARAMETR_IS_LOGIN);
		request.getSession().setAttribute("message", null);
		RequestDispatcher dispatcher = null;
		if(isLogged != null && isLogged.equals(true)){
			dispatcher = request.getRequestDispatcher(page);
			if (dispatcher != null) {
				dispatcher.forward(request, response);
			}
		} else {
			dispatcher = request.getRequestDispatcher("index.jsp");
			if (dispatcher != null) {
				dispatcher.forward(request, response);
			}
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String stringDate = request.getParameter("date");
		Date date = null;
		try{
			Integer amount = Integer.valueOf(request.getParameter("amount"));
			date = formatter.parse(stringDate);
			if(date == null){
				throw new RuntimeException();
			}
			RegisterDate registerDate = new RegisterDate();
			registerDate.setDate(date);
			registerDate.setNumber(amount);
			dateController.addDate(registerDate);
			request.getSession().setAttribute("validateMessage", null);
		} catch(Exception e){
			request.getSession().setAttribute("validateMessage", "Wrong date");
			RequestDispatcher dispatcher = request.getRequestDispatcher("admin.jsp");
			if (dispatcher != null) {
				dispatcher.forward(request, response);
			}
		}
		
	}

}
