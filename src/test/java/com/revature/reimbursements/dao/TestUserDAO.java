package com.revature.reimbursements.dao;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.revature.reimbursements.DAO.UserDAO;
import com.revature.reimbursements.entity.User;

public class TestUserDAO {
	
	@Test
	public void should_get_user_by_username() {
		
		//given a username which exists in the database
		int username = 11111111;
		
		//when the getUserByUsername(int username) method is called in UserDAO
		User user = UserDAO.getUserByUsername(username);
		
		//then provided username should match the retrieved username
		assertTrue(user.getUsername() == username);
	}
	
	@Test
	public void should_get_username_and_password() {
		
		//given a username which exists in the database
		int username = 11111111;
		
		//when the getUserByUsername(int username) method is called in UserDAO
		User user = UserDAO.getUserByUsername(username);
		
		//then provided username should match the retrieved username
		assertTrue(user.getPassword() != null && user.getUsername() != 0);
	}
	
//	@Test() //Not sure how to test this correctly. The exception is thrown and is handled, but I'm not sure how to prove that currently.
//	public void should_get_no_Result_Exception() {
//		
//		
//		//given a username which does not exist in the database
//		int username = 11111110;
//		
//		//when the getUserByUsername(int username) method is called in UserDAO
//		
//		
//		//then provided username should match the retrieved username
//		Exception exception = assertThrows(NoResultException.class, () -> {
//			User user = UserDAO.getUserByUsername(username);
//		});
//		
//		String expectedMessage = "No entity found for query";
//		String actualMessage = exception.getMessage();
//		
//		assertTrue(actualMessage.contains(expectedMessage));
//	}
	
	@Test
	public void should_return_null_if_no_user_found() {
		
		//given a username which exists in the database
		int username = 11111110;
		
		//when the getUserByUsername(int username) method is called in UserDAO
		User user = UserDAO.getUserByUsername(username);
		
		//then provided username should match the retrieved username
		assertTrue(user == null);
	}
}
