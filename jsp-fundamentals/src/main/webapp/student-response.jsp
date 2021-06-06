<html>

<head>
<title>Student Confirmation Title</title>
</head>

<body>

	The student is confirmed : ${param.firstName} ${param.lastName}

	<br />
	<br /> The student's country : ${param.country}

	<br />
	<br /> The student's favorite programming language:

	<ul>
		<%
		String[] langs = request.getParameterValues("favoriteLanguage");
		if (langs != null) {
			for (String temLang : langs) {
				out.println("<li>" + temLang + "</li>");
			}
		}
		%>
	</ul>
</body>
</html>