package com.revature.reimbursements.service;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.revature.reimbursements.controller.EmployeeController;
import com.revature.reimbursements.entity.Employee;

import io.javalin.http.Handler;

public class RequestService {
	private final static Logger logger = LogManager.getLogger(EmployeeController.class);
	
	
	public static Handler serveRequestsPage = ctx -> {
		logger.info("Entering serveRequestPage Handler.");
		EmployeeController employeeController = new EmployeeController();
		List<Employee> employeeRequests = employeeController.getEmployeeRequestsDAO(Employee.currentUser);
		ctx.json(employeeRequests);
	};
	
	
	public static Handler addRequest = ctx -> {
		logger.info("Entering 'addRequest' Handler.");
		logger.info(ctx.body());
		String jsonFromForm = ctx.body();
		EmployeeController employeeController = new EmployeeController();
		employeeController.addRequestEmployeeDAO(jsonFromForm);
		ctx.redirect("/requests.html");
	};
	
	
	public static Handler managementView = ctx -> {
		logger.info("Entering managementView Handler.");
		EmployeeController employeeController = new EmployeeController();
		List<Employee> allRequests = employeeController.getEmployeeDAOAllRequests();
		logger.info("Providing all reimbursement request results to '/management.html'");
		ctx.json(allRequests);
	};
	
	
	public static Handler updateRequestStatus = ctx -> {
		logger.info("Entering 'updateRequestStatus' Handler.");
		long requestID = Long.parseLong(ctx.formParam("requestID"));
		String decision = ctx.formParam("update");
		EmployeeController employeeController = new EmployeeController();
		logger.info("Sending status update to EmployeeController");
		employeeController.updateRequestStatusToEmployeeController(requestID, decision);
		logger.info("Sending updated status to /management.html");
		ctx.redirect("/management.html");
	};
}
