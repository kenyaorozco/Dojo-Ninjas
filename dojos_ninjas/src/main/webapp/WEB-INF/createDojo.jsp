<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) -->
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create a dojo</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">

<!-- change to match your file/naming structure -->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	${allDojos}
	<h2>New Dojo</h2>
	<form:form  action="/dojos" method="post" modelAttribute="dojo">
		<form:label path="name">Name:</form:label>
		<form:errors path="name" style="color: red" />
		<form:input path="name" />

		<button>Create</button>
	</form:form>
</body>
</html>