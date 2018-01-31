<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="springForm"%>
<link rel="stylesheet"	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Jaguar</title>
</head>
<style>
body
{
background-image: url(resources/images/images22.jpg);
background-size:cover;                      
background-repeat:no-repeat;
}
th{
    color:white;
    background-color:black;
    
   }
table, th, td {
    border: 1px solid black;
    align:center;
}
h2{
color:black;
font-family: "Times New Roman", Times, serif;
}
</style>

<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" >YOUR PRODUCT</a>
    </div><br>
    <ul class="nav navbar-nav">
      <li class="active"><a href="index"><span class="glyphicon glyphicon-home"></span></a></li>
	 
     </ul>
     <springForm:form action="addingtocart" method="post" modelAttribute="obcartjsp" enctype="multipart/form-data">
     <ul class="nav navbar-nav navbar-right">
      <li class="divider-vertical"></li>
		
		<c:if test="${Listofitems!= null}">
			<c:if test="${Listofitems  == 'index'}">
				<li><a href="<c:url value="/index" />">View ALL</a></li>
			</c:if>
			
			<li><a>Hello, "${Listofitems}"</a></li>
			<li><a href="<c:url value="/index" />"> <span class="glyphicon glyphicon-log-out"></span> Log Out</a></li>
		</c:if>
								
		<%-- <c:if test="${Listofitems == null}"> --%>
			<li><a href="<c:url value="/login" />"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
			<li><a href="<c:url value="memberShip.obj" />"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
	<%-- 	</c:if>
       --%>  
  </div>
</nav>

 <div class="container-fluid">
	<h3><center>YOUR CART</center></h3>
	<br>
	<br>
	<c:if test="${!empty Listofitems}">
		 <table style="width:100%">
  <tr>
   <th>CartID</th>
    <th>CartproductID</th>
    <th>cartimage</th>
    <th>cartPrice</th>
    <th>cartStock</th>
    <th>Product Discription</th>
  </tr>
			<c:forEach items="${Listofitems}" var="cart">
				<tr>
				    <td  align="center">${cart.cartId}</td>
				    <td><img src="<c:url value="resources/image/${cart.cartproductID}.jpg"/>" style="width: 100px;"></td>
					<td  align="center">${cart.cartprice}</td>
					<td  align="center">${cart.cartstock}</td>
					<td align="center"><a href="<c:url value='cart/delete/${cart.Id}' />"><button type="button" class="btn btn-default">Delete</button></a></td>
				</tr>
			</c:forEach>
		</table>
	
	</c:if>
	</div>
	<br>
	<br>
			<c:if test="${Listofitems!= null}">
		<h2><center> Total:${sum}</center></h2>
		</c:if>
	</springForm:form>
	<div style="text-align: center;">
	
	<a href="index"><button type="button" class="btn btn-default" align="center">CONTINUE SHOPPING</button>
	</h4></a>
	
	
	<br>
	<br>
	<c:if test="${!empty cartList}">
	<a href="payment"><h4 style="color: #c19a6b "><button type="button" class="btn btn-default">Checkout and Pay</button></h4></a>
	</c:if>
	</div>
</body>
</html><br><br><br><br><br><br><br><br><br><br><br>
</body>
</html>