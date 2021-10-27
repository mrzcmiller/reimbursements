package com.revature.reimbursements.application;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.revature.reimbursements.DAO.UserDAO;
import com.revature.reimbursements.service.LoginService;
import com.revature.reimbursements.service.RequestService;

import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;

public class Application {
	private final static Logger logger = LogManager.getLogger(Application.class);
	
	
	private static EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
			.createEntityManagerFactory("reimbursements");
	
	public static UserDAO userDao;

	public static void main(String[] args) {
		
		userDao = new UserDAO();
		
	       
		Javalin app = Javalin.create(config -> {
			config.addStaticFiles("/public", Location.CLASSPATH);
		}).start(7000);
		
		logger.info("Javalin started");
		
			
			app.post("/login", LoginService.handleLoginPost);
			app.get("/requests", RequestService.serveRequestsPage);
			app.post("/requests", RequestService.addRequest);
			app.get("/management", RequestService.managementView);
			app.post("/management", RequestService.updateRequestStatus);	

		
		ENTITY_MANAGER_FACTORY.close();
		logger.info("ENTITY_MANAGER_FACTORY has been closed");
		logger.info("End of Main()");
	}
	
}
