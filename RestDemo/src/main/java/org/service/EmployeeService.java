package org.service;

import org.bean.Employee;

public interface EmployeeService {

	void save(Employee employee);

	void deleteById(Employee employee);

	void update(Employee employee);

}