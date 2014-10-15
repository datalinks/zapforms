<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title>zapforms springdemo</title>

<style>
body {
	background-color: blue
}

h1 {
	font-family: "courier";
	color: white;
	font-size: 16pt
}

p {
	color: green
}

a:link {
	color: #FFFFFF;
}

a:visited {
	color: #FFFFFF;
}

font {
	font-family: "courier";
	color: white
}

td {
	text-align: right;
	color: white
}
</style>
<script src="js/jquery.min.js"></script>
<script type="text/javascript">

	function selectCustomer(customerID){
        window.location.href = 'getCustomer?id='+customerID;
	}


		

	$(document).ready(function () {		
   	});
   	
</script>

<body>

	<table border="1">
		<tr>
			<td>Customer ID</td>
			<td>Customer name</td>
		</tr>
		<c:forEach items="${customerz}" var="customer">
			<tr>
				<td><div id="customerId" onClick="selectCustomer('${customer.id}')"><c:out value="${customer.id}" /></div></td>
				<td><c:out value="${customer.name}" /></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
