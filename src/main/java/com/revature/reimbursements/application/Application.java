package com.revature.reimbursements.application;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.revature.reimbursements.DAO.UserDAO;
import com.revature.reimbursements.controller.EmployeeController;
import com.revature.reimbursements.controller.LoginController;


import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;

public class Application {
	
	private static EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
			.createEntityManagerFactory("reimbursements");
	
	public static UserDAO userDao;

	public static void main(String[] args) {
		userDao = new UserDAO();
		
	       
		Javalin app = Javalin.create(config -> {
			config.addStaticFiles("/public", Location.CLASSPATH);
		}).start(7000);
		
			app.get("/index", LoginController.serveLoginPage);
			app.post("/login", LoginController.handleLoginPost);
			app.get("/requests", EmployeeController.serveRequestsPage);
			app.post("/requests", EmployeeController.addRequest);
			app.get("/management", EmployeeController.managementView);
			app.post("/management", EmployeeController.requestStatus);

		
		ENTITY_MANAGER_FACTORY.close();
	}

}
