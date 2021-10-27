package com.revature.reimbursements.controller;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.revature.reimbursements.DAO.UserDAO;
import com.revature.reimbursements.entity.User;

public class LoginController {
	private final static Logger logger = LogManager.getLogger(LoginController.class);
	
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
        	return true;
        } else {
        	logger.info("Passwords did not match.");
        	return false;
        }
       
    }

}

