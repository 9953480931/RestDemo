/**
 * 
 */
package org.dao;

import java.util.UUID;

import org.bean.Employee;
import org.cassandraSession.SessionCreate;

import com.datastax.driver.core.GettableByIndexData;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.Statement;
import com.datastax.driver.core.querybuilder.Clause;
import com.datastax.driver.core.querybuilder.Delete;
import com.datastax.driver.core.querybuilder.Insert;
import com.datastax.driver.core.querybuilder.QueryBuilder;

/**
 * @author jaspreet.singh1
 *
 */
public class EmployeeDaoImpl implements EmployeeDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.dao.EmployeeDao#save(org.bean.Employee)
	 */
	public void save(Employee employee) {

		Session session = SessionCreate.getCassandraSession("127.0.0.1", "finity");
		Insert insert = QueryBuilder.insertInto("finity", "employee");
		insert = insert.value("id", employee.getId());
		insert = insert.value("name", employee.getName());

		session.execute(insert);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.dao.EmployeeDao#delete(org.bean.Employee)
	 */
	public void delete(Employee employee) {
		Session session = SessionCreate.getCassandraSession("127.0.0.1", "finity");
		// Delete delete = QueryBuilder.delete().from("finity",
		// "employee").where(eq("id",employee.getId()));
		String query = "Delete From employee where id=" + employee.getId() + "";
		ResultSet rs = session.execute(query);
		System.out.println(rs.toString());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.dao.EmployeeDao#update(org.bean.Employee)
	 */
	public void update(Employee employee) {
		Session session = SessionCreate.getCassandraSession("127.0.0.1", "finity");
		String query = "UPDATE employee SET name='" + employee.getName() + "' where id=" + employee.getId() + " ";
		ResultSet rs = session.execute(query);
		System.out.println(rs.toString());
	}

	public Employee viewAll(Employee employee) {
		Employee responseEmployee = new Employee();
		Session session = SessionCreate.getCassandraSession("127.0.0.1", "finity");
		String query = "select * from  employee where id=" + employee.getId() + " ";
		ResultSet rs = session.execute(query);
		System.out.println(rs);
		for (Row emp : rs) {
			responseEmployee.setId(emp.getInt(0));
			responseEmployee.setName(emp.getString(1));
			// System.out.println(emp.getObject(1));
		}
		return responseEmployee;
	}


	/*
	 * public static void main(String[] args) { Employee emp = new Employee();
	 * emp.setId(0); System.out.println(new EmployeeDaoImpl().viewAll(emp)); }
	 */
}
