package com.revature.reimbursements.controller;

import java.util.List;

import com.revature.reimbursements.DAO.EmployeeDAO;
import com.revature.reimbursements.entity.Employee;
import com.revature.reimbursements.DAO.UserDAO;
import com.revature.reimbursements.entity.User;

import io.javalin.http.Handler;



public class EmployeeController {
	
	
	public static Handler serveRequestsPage = ctx -> {
		EmployeeDAO employeeDAO = new EmployeeDAO(); //create a new access object for the employee
		List<Employee> requests = employeeDAO.getRequestsByEmployee(Employee.currentUser); //Save the database resultSet to a List object
			if (requests == null) {
				ctx.html("Not Found");
			} else {
				ctx.json(requests);
			}
	};
	
	
	public static Handler managementView = ctx -> {
		EmployeeDAO employeeDAO = new EmployeeDAO(); //create a new access object for the employee
		List<Employee> requests = employeeDAO.getRequests(); //Save the database resultSet to a List object
			if (requests == null) {
				ctx.html("Not Found");
			} else {
				ctx.json(requests);
			}
	};
		
		public static Handler addRequest = ctx -> {
		int employeeID = Employee.currentUser;
		EmployeeDAO dao = new EmployeeDAO();
		dao.addRequest(employeeID, ctx.formParam("description"), Double.parseDouble(ctx.formParam("amount")));
		ctx.redirect("/requests.html");
		};
		
		public static Handler requestStatus = ctx -> {
			long requestID = Long.parseLong(ctx.formParam("requestID"));
			String decision = ctx.formParam("update");
			EmployeeDAO dao = new EmployeeDAO();
			dao.updateRequest(requestID, decision);
			ctx.redirect("/management.html");
	};
	
	
	public static boolean authenticate(String username, String password) {
        if (username == null || password == null) {
            return false;
        }
        User user = UserDAO.getUserByUsername(Integer.parseInt(username));
        if (user == null) {
            return false;
        }
        
        if (password.equals(user.getPassword())) {
        	char firstNumber = username.charAt(0);
        	String number = String.valueOf(firstNumber);
        	if (number.equals("1")) {
        		User.setIsManager(true);
        	} else {
        		User.setIsManager(false);
        	}
        	return true;
        } else {
        	return false;
        }
       
    }

}
