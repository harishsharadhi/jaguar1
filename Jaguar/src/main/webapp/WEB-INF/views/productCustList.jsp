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
<h2>Product List for Customer</h2>

<table class="table table-hover" id="ap1" class="display" border="2" width="80" align="center">
<tr>
<th>PID</th>
<th>Product Name</th>
<th>Description</th>
<th>Stock</th>
<th>Price</th>
<th>Stock</th>

<th>Image</th>
<th>>Action</th>
</tr>

<c:if test="${empty prodList }">
<tr>
<td colspan="10" align="center">No Record Exists!!</td>
</tr>
</c:if>

<c:forEach var="p" varstatus="st" items="${prodList }">
<tr>

<td><c:out value="${st.count }"></c:out></td>
<td><c:out value="${p.pid }"></c:out></td>
<td><c:out value="${p.pname }"></c:out></td>
<td><c:out value="${p.supplier.supplierName }"></c:out></td>
<td><c:out value="${p.category.cname}"></c:out></td>
<td class="span3"><c:out value="${p.description }"></c:out></td>
<td><c:out value="${p.price }"></c:out></td>
<td><c:out value="${p.stock }"></c:out></td>
<td><img src="${pageContext.request.contextPath }/resources/${p.imgName}" height="50px" width="50px"></td>
<td class="span2">
<c:set var="contextRoot" value="${pageContext.request.contextPath }"></c:set>
<a class="btn btn-info" role="button" href="#">Edit</a>
<a class="btn btn-info" role="button" href="<c:url value="/prodDetails${p.pid}"/>">Details</a></td>
</tr>
</c:forEach>

</table>



</div>
</body>
</html>