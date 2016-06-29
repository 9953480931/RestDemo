<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="/RestDemo/rest/employee/update" >
<input type="hidden" name="_method" value="PUT">
Enter id : <input type="text" name="id" /> <br><br>
Enter Name :<input type="text" name="name" /><br><br>
<input type="submit" value="Update" />
</form>


<h2>Your details are as follows:</h2>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>Name</th>
			
		</tr>
		<tr>
			<%-- <td>${requestScope.employee.id}</td>
			<td>${requestScope.userBean.password}</td> --%>
			
		</tr>
	</table>
</body>
</html>