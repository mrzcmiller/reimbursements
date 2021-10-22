package com.revature.reimbursements.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.revature.reimbursements.entity.User;


public class UserDAO {
	
	private static EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
			.createEntityManagerFactory("reimbursements");


	public static User getUserByUsername(int username) {
		EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
		String query = "SELECT u FROM User u WHERE u.username = " + username + "";
		
		TypedQuery<User> typedQuery = entityManager.createQuery(query, User.class);
		User user;
		try {
			user = typedQuery.getSingleResult();
			return user;
		}
		catch(NoResultException e) {
			e.printStackTrace();
		}
			
		finally {
			entityManager.close();
		}
		return null;
	}

}
