<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page import="com.simplilearn.workshop.*"%>

<%
	List<Student> data = new ArrayList<>();
	data.add(new Student("vinodh","mahendra",false));
	data.add(new Student("dennis","puttaswamy",false));
	data.add(new Student("clarence","tauro",true));
	
	pageContext.setAttribute("myStudents", data);
%>
<html>
<body>

	<table border="1">

	<tr>
		<th>First Name</th>
		<th>Last Name</th>
		<th>Gold Customer</th>
	</tr>

	<c:forEach var="tempStudent" items="${myStudents}">
		<tr>
		<td>${tempStudent.firstName}</td>
		<td> ${tempStudent.lastName}</td>
		<td> 
			<c:if test="${tempStudent.goldCustomer}">
				Special Discount
			</c:if>
			<c:if test="${ not tempStudent.goldCustomer}">
				-
			</c:if>
		</td>
		</tr>
		
	</c:forEach>
	</table>
	
</body>
</html>