package com.revature.reimbursements.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "reimbursement")
public class Employee {
	public static int currentUser;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "employee_id")
	private int employeeID;

	@Column(name = "description", nullable = false)
	private String description;

	@Column(name = "amount", nullable = false)
	private double amount;

	@Column(name = "status")
	private String status;

	@Column(name = "comments")
	private String comments;

	public Employee() {
	}

	public Employee(int employeeID) {
		this.employeeID = employeeID;
	}

	public Employee(long id, int employeeID, String description, double amount, String status) {
		this.id = id;
		this.employeeID = employeeID;
		this.description = description;
		this.amount = amount;
		this.status = status;
	}

	public Employee(long id, int employeeID, String description, double amount, String status, String comments) {
		this.id = id;
		this.employeeID = employeeID;
		this.description = description;
		this.amount = amount;
		this.status = status;
		this.comments = comments;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "Request [id=" + id + ", employeeID=" + employeeID + ", description=" + description + ", amount="
				+ amount + ", status=" + status + ", comments=" + comments + "]";
	}
}