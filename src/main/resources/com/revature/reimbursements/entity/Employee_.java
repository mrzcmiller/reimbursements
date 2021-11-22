package com.revature.reimbursements.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2021-11-22T17:59:08.693-0500")
@StaticMetamodel(Employee.class)
public class Employee_ {
	public static volatile SingularAttribute<Employee, Long> id;
	public static volatile SingularAttribute<Employee, Integer> employeeID;
	public static volatile SingularAttribute<Employee, String> description;
	public static volatile SingularAttribute<Employee, Double> amount;
	public static volatile SingularAttribute<Employee, String> status;
	public static volatile SingularAttribute<Employee, String> comments;
}
