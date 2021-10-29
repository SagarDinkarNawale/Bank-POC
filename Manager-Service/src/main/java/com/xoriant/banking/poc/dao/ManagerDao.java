package com.xoriant.banking.poc.dao;

import com.xoriant.banking.poc.model.Branch;
import com.xoriant.banking.poc.model.PersonInfo;

public interface ManagerDao {

	Branch addNewBranch(Branch branch);

	PersonInfo addNewPerson(PersonInfo personInfo);

	int updateCustomer(int accountNumber, PersonInfo personInfo);

	String getPersonId(int customer_id);

	Boolean checkCustomer_id(int customer_id);

	void deleteCustomer(int customer_id);

	void addAccount(String roleType, int accountId, int balance, int customerId, int managerId, int accountTypeId,
			int branchId);

}