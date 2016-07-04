package org.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import org.bean.Employee;
import org.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Path("/employee")
public class EmployeeController {
	@Autowired
	private EmployeeService empService;

	public void setEmpService(EmployeeService empService) {
		this.empService = empService;
	}

	@POST
	@Path("/add")

	 @Consumes("application/json")
	public void add(/*@FormParam("id") int id, @FormParam("name") String name*/ Employee employee)

	{
	//	Employee employee = new Employee();
		//employee.setId(id);
		//employee.setName(name);
		this.empService.save(employee);
		System.out.println(employee.toString());
		System.out.println("Test");
		System.out.println(" hOme BranchTest");

	}

	@DELETE
	@Path("/delete")
	public void deleteById(@FormParam("id") int id)

	{
		Employee employee = new Employee();
		employee.setId(id);

		this.empService.deleteById(employee);
		System.out.println(employee.toString());

	}
	
	@PUT
	@Path("/update")
	public void updateById(@FormParam("id") int id,  @FormParam("name") String name)

	{
		Employee employee = new Employee();
		employee.setId(id);
        employee.setName(name);
		this.empService.update(employee);
		System.out.println(employee.toString());

	}

}
