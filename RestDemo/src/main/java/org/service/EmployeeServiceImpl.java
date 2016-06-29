package org.service;

import org.bean.Employee;
import org.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;

public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeDao empDao;
	
	public void setEmpDao(EmployeeDao empDao) {
		this.empDao = empDao;
	}

	/* (non-Javadoc)
	 * @see org.service.EmployeeService#save(org.bean.Employee)
	 */
	public void save(Employee employee)
	{
		this.empDao.save(employee);
	}
	
	/* (non-Javadoc)
	 * @see org.service.EmployeeService#deleteById(org.bean.Employee)
	 */
	public void deleteById(Employee employee)
	{
		this.empDao.delete(employee);
	}
	
	/* (non-Javadoc)
	 * @see org.service.EmployeeService#update(org.bean.Employee)
	 */
	public void update(Employee employee)
	{
		this.empDao.update(employee);
	}

}
