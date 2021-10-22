package com.revature.reimbursements.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.revature.reimbursements.entity.Employee;

public class EmployeeDAO {
	
	private static EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
		.createEntityManagerFactory("reimbursements");

	
	public void addRequest(int employeeID, String description, double amount) {
		EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction entityTransaction = null;
		try {
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			Employee employee = new Employee();
			employee.setId(employee.getId());;
			employee.setEmployeeID(employeeID);
			employee.setDescription(description);
			employee.setAmount(amount);
			employee.setStatus("PENDING");
			entityManager.persist(employee);
			entityTransaction.commit();
		}
		catch(Exception e) {
			if(entityTransaction != null) {
				entityTransaction.rollback();
			}
			e.printStackTrace();
		}
		finally {
			entityManager.close();
		}
	}
	
	
	
	
	public List<Employee> getRequestsByEmployee(int employeeID) {
		EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
		String query = "SELECT e FROM Employee e WHERE e.employeeID = " + employeeID + "ORDER BY id DESC";
		
		TypedQuery<Employee> typedQuery = entityManager.createQuery(query, Employee.class);
		List<Employee> requests;
		try {
			requests = typedQuery.getResultList();
			return requests;
		}
		catch(NoResultException e) {
			e.printStackTrace();
		}
			
		finally {
			entityManager.close();
		}
		return null;
	}
	
	
	public List<Employee> getRequests() {
		EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
		String stringQuery = "SELECT a FROM Employee a WHERE a.id IS NOT NULL";
		
		TypedQuery<Employee> typedQuery = entityManager.createQuery(stringQuery, Employee.class);
		List<Employee> requests;
		try {
			requests = typedQuery.getResultList();
			return requests;
		}
		catch(NoResultException e) {
			e.printStackTrace();
		}
		finally {
			entityManager.close();
		}
		return null;
	}
	
	
	public void updateRequest(long requestID, String status) {
		EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction entityTransaction = null;
		Employee employee = null;
		try {
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			employee = entityManager.find(Employee.class, requestID);
			employee.setStatus(status);
			entityManager.persist(employee);
			entityTransaction.commit();
		}
		catch(NoResultException e) {
			e.printStackTrace();
		}
			
		finally {
			entityManager.close();
		}
	}
	
	
}
