package by.grsu.registration.web.controller;

import by.grsu.registration.dao.DateDao;
import by.grsu.registration.model.RegisterDate;

public class DateController {
	
	private DateDao dao;
	
	public DateController(){
		dao = new DateDao();
	}
	
	public void addDate(RegisterDate date){
		dao.addDate(date);
	}

}
