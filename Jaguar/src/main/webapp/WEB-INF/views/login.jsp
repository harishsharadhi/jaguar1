  <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Jaguar</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="utf-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>

<div class="container">
<h2>welcome to login page....</h2>
<form action="${pageContext.request.contextPath}/login" class="form=signin" method="post">
<h3><label>Email:</label></h3>
<input type="text" name="username""class=login-Box" required>
<h3><label>password;</label></h3>
<input type="password" name="password" class="login_box" required>
<button class="btn btn-lg btn-primary" type="submit">Login</button>
<button class="btn btn-lg btn-warning" type="reset">Cancel</button>
<form y:csrf disabled="true"/>
</form>
</div>
</body>
</html>