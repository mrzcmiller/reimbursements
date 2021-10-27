package com.revature.reimbursements.controller;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.revature.reimbursements.DAO.EmployeeDAO;
import com.revature.reimbursements.DAO.UserDAO;
import com.revature.reimbursements.entity.Employee;
import com.revature.reimbursements.entity.User;




public class EmployeeController {
	private final static Logger logger = LogManager.getLogger(EmployeeController.class);
	
	
	public List<Employee> getEmployeeRequestsDAO(int employeeID) {
		logger.info("Entering getEmployeeRequestsDAO() method in EmployeeController");
		EmployeeDAO employeeDAO = new EmployeeDAO(); //create a new access object for the employee
		List<Employee> employeeRequests = employeeDAO.getRequestsByEmployee(employeeID); //Save the database resultSet to a List object
		return employeeRequests;
	}
	
	
	public void addRequestEmployeeDAO(int employeeID, String description, double amount) {
		logger.info("Entering addRequestEmployeeDAO() method.");
		EmployeeDAO dao = new EmployeeDAO(); //New EmployeeDAO object
		dao.addRequest(employeeID, description, amount);
	}
	
	
	public List<Employee> getEmployeeDAOAllRequests() {
		logger.info("Entering getEmployeeDAOAllRequests() method in EmployeeController.");
		EmployeeDAO employeeDAO = new EmployeeDAO(); //create a new access object for the employee
		List<Employee> allRequests = employeeDAO.getRequests(); //Save the database resultSet to a List object
		logger.info("Returning all requests to RequestService.");
		return allRequests;
	}
	
	
	public void updateRequestStatusToEmployeeController(long requestID, String decision) {
		logger.info("Entering updateRequestStatusToEmployeeController() method in EmployeeController.");
		EmployeeDAO dao = new EmployeeDAO();
		logger.info("Sending status update to EmployeeDAO");
		dao.updateRequest(requestID, decision);
	}
		
		
	public static boolean authenticate(String username, String password) {
        if (username == null || password == null) {
        	logger.info("Username or Password was empty.");
        	return false;
        }
        User user = UserDAO.getUserByUsername(Integer.parseInt(username));
        if (user == null) {
        	logger.info("Username was not found.");
            return false;
        }
        
        if (password.equals(user.getPassword())) {
        	logger.info("Password validation successful, checking if employee is a manager.");
//        	char firstNumber = username.charAt(0);
//        	String number = String.valueOf(firstNumber);
//        	if (number.equals("1")) {
//        		User.setIsManager(true);
//        		logger.info("Setting isManager to true.");
//        	} else {
//        		User.setIsManager(false);
//        		logger.info("Setting isManager to false.");
//        	}
        	return true;
        } else {
        	logger.info("Passwords did not match.");
        	return false;
        }
       
    }

}
