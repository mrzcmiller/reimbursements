package com.revature.reimbursements.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.reimbursements.application.Application;
import com.revature.reimbursements.entity.Employee;

public class EmployeeDAO {
	private final static Logger logger = LogManager.getLogger(EmployeeDAO.class);

	
	public String addRequest(String jsonFromForm) {
		logger.info("Entering EmployeeDAO addRequest method.");
		EntityManager entityManager = Application.ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction entityTransaction = null;
		try {
			ObjectMapper mapper = new ObjectMapper();
			Employee employee = mapper.readValue(jsonFromForm, Employee.class);
			logger.info("Setting property values for Employee: " + employee.getEmployeeID() + ".");
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			employee.setId(employee.getId());;
			employee.setEmployeeID(employee.getEmployeeID());
			employee.setDescription(employee.getDescription());
			employee.setAmount(employee.getAmount());
			employee.setStatus("PENDING");
			logger.info("Persisting.");
			entityManager.persist(employee);
			logger.info("Committing.");
			entityTransaction.commit();
			logger.info("Transaction successful.");
			return "Complete";
		}
		catch(Exception e) {
			if(entityTransaction != null) {
				logger.warn("Transaction failed due to 'null' value. Rolling back transaction.");
				entityTransaction.rollback();
			}
			e.printStackTrace();
			logger.info("Returning to EmployeeController.");
			return "Failed";
		}
		finally {
			entityManager.close();
		}
		
	}
	
	
	
	
	public List<Employee> getRequestsByEmployee(int employeeID) {
		logger.info("Searching for reimbursement requests for " + employeeID + ".");
		EntityManager entityManager = Application.ENTITY_MANAGER_FACTORY.createEntityManager();
		String query = "SELECT e FROM Employee e WHERE e.employeeID = " + employeeID + "ORDER BY id DESC";
		
		TypedQuery<Employee> typedQuery = entityManager.createQuery(query, Employee.class);
		List<Employee> requests;
		try {
			requests = typedQuery.getResultList();
			logger.info(employeeID + " has " + requests.size() + " reimbursement requests.");
			return requests;
		}
		catch(NoResultException e) {
			logger.info("No reimbursement exists for employee " + employeeID + ".");
			e.printStackTrace();
		}
			
		finally {
			entityManager.close();
		}
		logger.info("Returning 'null' for reimbursement requests for " + employeeID + ".");
		return null;
	}
	
	
	public List<Employee> getRequests() {
		logger.info("Searching for reimbursement requests for all employees.");
		EntityManager entityManager = Application.ENTITY_MANAGER_FACTORY.createEntityManager();
		String stringQuery = "SELECT a FROM Employee a WHERE a.id IS NOT NULL ORDER BY id DESC";
		
		TypedQuery<Employee> typedQuery = entityManager.createQuery(stringQuery, Employee.class);
		List<Employee> requests;
		try {
			logger.info("Getting ResultList.");
			requests = typedQuery.getResultList();
			logger.info("Sending results to EmployeeController.");
			return requests;
		}
		catch(NoResultException e) {
			logger.info("No results were found. Please check database to ensure there is data.");
			e.printStackTrace();
		}
		finally {
			entityManager.close();
		}
		logger.info("The getRequests() method in EmployeeDao is returning a null value.");
		return null;
	}
	
	
	public void updateRequest(long requestID, String status, String comments) {
		logger.info("Entering updateRequest() method for request with id: " + requestID + ".");
		EntityManager entityManager = Application.ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction entityTransaction = null;
		Employee employee = null;
		try {
			logger.info("Setting property values for request with id: " + requestID + ".");
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			employee = entityManager.find(Employee.class, requestID);
			employee.setStatus(status);
			employee.setComments(comments);
			logger.info("Persisting.");
			entityManager.persist(employee);
			logger.info("Committing.");
			entityTransaction.commit();
			logger.info("Transaction successful.");
		}
		catch(NoResultException e) {
			if(entityTransaction != null) {
				logger.warn("Transaction failed due to 'null' value. Rolling back transaction.");
				entityTransaction.rollback();
			}
			e.printStackTrace();
		}
			
		finally {
			entityManager.close();
		}
		logger.info("Returning to EmployeeController.");
	}
	
	
	
}
