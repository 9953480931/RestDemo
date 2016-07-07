package org.controller;

import java.io.IOException;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.bean.Employee;
import org.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.util.CommonUtil;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

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
	public void add(
			/* @FormParam("id") int id, @FormParam("name") String name */  @FormParam("json") String json) throws JsonParseException, JsonMappingException, IOException

	{
		// Employee employee = new Employee();
		// employee.setId(id);
		// employee.setName(name);
		 System.out.println(json.substring(0,json.lastIndexOf(",")));
		Employee employee = (Employee)CommonUtil.convertFromJsonStrToEntity(Employee.class, json.substring(0,json.lastIndexOf(",")) + "}");
		
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
	public void updateById(@FormParam("id") int id, @FormParam("name") String name)

	{
		Employee employee = new Employee();
		employee.setId(id);
		employee.setName(name);
		this.empService.update(employee);
		System.out.println(employee.toString());

	}

	@POST
	@Path("/view")
	@Produces("application/json")
	@Consumes("application/json")
	public Response viewById(Employee employee) {
		return Response.status(200).entity(this.empService.viewAll(employee)).build();

	}

}
