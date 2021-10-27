package com.revature.reimbursements.service;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.revature.reimbursements.controller.LoginController;
import com.revature.reimbursements.entity.Employee;

import io.javalin.http.Handler;

public class LoginService {
	public static boolean requireLogin = true;
	private final static Logger logger = LogManager.getLogger(LoginController.class);
	
	public static Handler handleLoginPost = ctx -> {
    	logger.info("Entering handleLoginPost Handler.");
        if (!LoginController.authenticate(ctx.formParam("username"), ctx.formParam("password"))) {
            ctx.redirect("/login.html");
            logger.info("Authentication failed.");
        } else {
        	Employee.currentUser =  Integer.parseInt(ctx.formParam("username"));
        	ctx.redirect("/requests.html");
        	logger.info("Authentication successful. Redirected to '/requests.html'");
        }
    };

}
