package com.revature.reimbursements.controller;

import com.revature.reimbursements.entity.Employee;

import io.javalin.http.Handler;

public class LoginController {
	
    public static Handler serveLoginPage = ctx -> {
    	ctx.redirect("/login.html");
    };
    
    
    public static Handler handleLoginPost = ctx -> {
        if (!EmployeeController.authenticate(ctx.formParam("username"), ctx.formParam("password"))) {
            ctx.html("User authentication failed.");
        } else {
        	 Employee.currentUser =  Integer.parseInt(ctx.formParam("username"));
        	 ctx.redirect("/requests.html");
        }
    };
}

