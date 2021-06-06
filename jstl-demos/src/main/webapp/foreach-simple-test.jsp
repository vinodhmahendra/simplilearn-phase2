<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<%
	String[] cities = {"Mumbai","Singapore","Philadelphia"};
	
	pageContext.setAttribute("myCities",cities);
	
%>

<html>

<body>

	<c:forEach var="tempCity" items="${myCities}">
	
		${tempCity} <br/>
	
	</c:forEach>

</body>
</html>