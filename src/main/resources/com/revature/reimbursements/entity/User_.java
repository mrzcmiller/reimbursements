package com.revature.reimbursements.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2021-11-22T17:59:08.745-0500")
@StaticMetamodel(User.class)
public class User_ {
	public static volatile SingularAttribute<User, Long> id;
	public static volatile SingularAttribute<User, Integer> username;
	public static volatile SingularAttribute<User, String> password;
	public static volatile SingularAttribute<User, Boolean> isManager;
}
