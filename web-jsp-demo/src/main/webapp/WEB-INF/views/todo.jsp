<%@ page pageEncoding="UTF-8" info="Page JSP Todo"
	contentType="text/html; charset=ISO-8859-1"%>
<%@ page import="fr.nro.demoservlet.bean.ToDoBean"%>
<%@ page import="java.util.List"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<html>
<head>
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
	<%@ include file="bandeau.jsp"%>
	
	
	<%! String message = "hello";%>
	<%! int index = 0; %>
	
	
	<div class="container">Liste de todos</div>
	<ul class="list-group">
	<c:forEach items="${todos}" var="todo">
		<jsp:useBean id="todo" 
			type="fr.nro.demoservlet.bean.ToDoBean"  
			beanName="todo"></jsp:useBean>
		
		<li class="list-group-item"><c:out value="${todo.label}"></c:out></li>
	</c:forEach>
	</ul>
</body>
</html>