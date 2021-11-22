package com.revature.reimbursements.dao;

//import org.junit.jupiter.api.Test;

//import com.revature.reimbursements.DAO.EmployeeDAO;
//import com.revature.reimbursements.entity.Employee;

public class TestEmployeeDAO {

//	Will need to figure out how to mock something like this
//	//Tests:
//	//Given a string with json information, 
//	String jsonFromForm = "{employeeID: '11111111', description: 'Testing the addRequest() method', amount: '150.75'}";
//	
//		//employee.getID should not be null and should contain the next number in the sequence
//	@Test
//	public void should_set_ID() {
//		//When addRequest() method is ran
//		EmployeeDAO employeeDAO = new EmployeeDAO();
//		employeeDAO.addRequest(jsonFromForm);
//		
//		//Then the employee object should have its id property set
//		
//		
//	}

//		//employee.getEmployeeID should not be null, and should contain an integer value
//	@Test
//	public void should_set_employeeID() {
//		//When addRequest() method is ran
//		EmployeeDAO employeeDAO = new EmployeeDAO();
//		employeeDAO.addRequest(jsonFromForm);
//	}

//		//employee.getDescription should not be null and should contain a string of less than 250 characters
//	@Test
//	public void should_set_description() {
//		//When addRequest() method is ran
//		EmployeeDAO employeeDAO = new EmployeeDAO();
//		employeeDAO.addRequest(jsonFromForm);
//		
//	}

//		//employee.getAmount should not be null and should and should contain a double
//	@Test
//	public void should_set_amount() {
//		//When addRequest() method is ran
//		EmployeeDAO employeeDAO = new EmployeeDAO();
//		employeeDAO.addRequest(jsonFromForm);
//		
//	}

//		//employee.getStatus should not be null and should be equal to "PENDING"
//	@Test
//	public void should_set_status() {
//		//When addRequest() method is ran
//		EmployeeDAO employeeDAO = new EmployeeDAO();
//		employeeDAO.addRequest(jsonFromForm);
//		
//	}

//		//if an exception is thrown and entity transaction was null, data should not be inserted into the database
//	@Test
//	public void should_handle_exception() {
//		//When addRequest() method is ran
//		EmployeeDAO employeeDAO = new EmployeeDAO();
//		employeeDAO.addRequest(jsonFromForm);
//		
//	}

//		//should add an item to the database
//	@Test
//	public void should_add_item_to_database() {
//		//When addRequest() method is ran
//		EmployeeDAO employeeDAO = new EmployeeDAO();
//		employeeDAO.addRequest(jsonFromForm);
//		
//	}

	// Second method to test

	// Tests:
	// Given an employeeID

	// A List<Employee> Object should be returned
//	@Test
//	public void should_return_a_List_Employee_Object() {
//		int employeeID = 11111111;
//		EmployeeDAO employeeDAO = new EmployeeDAO();
//		//Determine how to ensure the result is of type List<Employee>
//		employeeDAO.getRequestsByEmployee(employeeID);
//	}

	// An exception should be thrown and handled if no results are returned
//	@Test
//	public void should_throw_exception_if_no_results_returned() {
//		int employeeID = 11111110;
//		EmployeeDAO employeeDAO = new EmployeeDAO();
//		//Determine how to check for exceptions
//		employeeDAO.getRequestsByEmployee(employeeID);
//	}

	// A null value should be passed if there are no results returned
//	@Test
//	public void should_return_null_if_no_results_returned() {
//		int employeeID = 11111110;
//		EmployeeDAO employeeDAO = new EmployeeDAO();
//		List<Employee> results = employeeDAO.getRequestsByEmployee(employeeID)
//		assertNull(results);
//	}

	// The list should be size N according to number of requests the employee has
//	@Test
//	public void should_return_list_with_size_equal_to_number_of_request_in_database() {
//		int requestCount = NumberOfRecordsInDatabase;	
//		int employeeID = 11111111;
//		EmployeeDAO employeeDAO = new EmployeeDAO();
//		List<Employee> results = employeeDAO.getRequestsByEmployee(employeeID)
//		assertTrue(results.size() == requestCount);
//	}

	// All requests should have the same employeeID
//	@Test
//	public void should_return_same_employeeID_for_all_records() {
//		int employeeID = 11111111;
//		EmployeeDAO employeeDAO = new EmployeeDAO();
//		List<Employee> results = employeeDAO.getRequestsByEmployee(employeeID)
//		do research for how to perform correctly
//	}

	// There should be no duplicate request results
//	@Test
//	public void should_not_return_any_duplicate_results() {
//		int employeeID = 11111111;
//		EmployeeDAO employeeDAO = new EmployeeDAO();
//		List<Employee> results = employeeDAO.getRequestsByEmployee(employeeID)
//		do research for how to perform correctly
//	}

	// There should be no blank columns in the results
//	@Test
//	public void should_not_return_any_empty_columns() {
//		int employeeID = 11111111;
//		EmployeeDAO employeeDAO = new EmployeeDAO();
//		List<Employee> results = employeeDAO.getRequestsByEmployee(employeeID)
//		do research for how to perform correctly
//	}

	// Tests: public List<Employee> getRequests() {}
	// should return a List<Employee> object
//	@Test
//	public void should_return_a_List_Employee_Object() {
//		int employeeID = 11111111;
//		EmployeeDAO employeeDAO = new EmployeeDAO();
//		List<Employee> results = employeeDAO.getRequestsByEmployee(employeeID)
//		do research for how to perform correctly
//	}

	// Should return all items in the table
//	@Test
//	public void should_return_list_with_size_equal_to_total_number_of_requests_in_database() {
//		int requestCount = NumberOfRecordsInDatabase;	
//		int employeeID = 11111111;
//		EmployeeDAO employeeDAO = new EmployeeDAO();
//		List<Employee> results = employeeDAO.getRequests();
//		assertTrue(results.size() == requestCount);
//	}

	// Should catch/handle exceptions if no items are in the table

	// Should return null if no items are in the table

	// Should return items in descending order based on id

	// Tests: public void updateRequest(long requestID, String status) {}
	// Given a requestID of type 'long' and a status of type 'String'
	// Should update the status column in the database with the provided status
	// Should catch/handle exception if no record is found matching the requestID
	// Should rollback transaction if null

}
