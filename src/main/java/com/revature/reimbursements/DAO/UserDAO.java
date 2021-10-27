package com.revature.reimbursements.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.revature.reimbursements.entity.User;


public class UserDAO {
	private final static Logger logger = LogManager.getLogger(UserDAO.class);
	private static EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
			.createEntityManagerFactory("reimbursements");


	public static User getUserByUsername(int username) {
		EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
		String query = "SELECT u FROM User u WHERE u.username = " + username + "";
		
		TypedQuery<User> typedQuery = entityManager.createQuery(query, User.class);
		User user = new User();
		try {
			user = typedQuery.getSingleResult();
			logger.info("Username match found.");
			return user;
		}
		catch(NoResultException e) {
			logger.info("No user found with username " + user.getUsername() + ".");
			e.printStackTrace();
		}
			
		finally {
			entityManager.close();
		}
		return null;
	}

}
