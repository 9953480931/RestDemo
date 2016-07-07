package org.dao;

import org.bean.Employee;

public interface EmployeeDao {

	void save(Employee employee);

	void delete(Employee employee);

	void update(Employee employee);
	
	public Employee viewAll(Employee employee);

}