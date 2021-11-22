package com.revature.reimbursements.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "credentials")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private long id;
	@Column
    private int username;
	@Column
    private String password;
	@Column
    private static boolean isManager;

    public int getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public static boolean getIsManager() {
		return isManager;
	}

	public static void setIsManager(boolean manager) {
		isManager = manager;
	}

	public User() {
    	super();
		this.username = 0;
		this.password = "";
		
	}

	public User(int username, String password) {
        this.username = username;
        this.password = password;
    }
}