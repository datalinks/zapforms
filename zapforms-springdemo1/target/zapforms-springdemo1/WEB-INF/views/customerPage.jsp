<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>zapforms springdemo</title>
<script src="js/jquery.min.js"></script>
<script src="js/ics.js"></script>

<link rel="stylesheet" type="text/css" href="css/ics.css">

<body onload="startTime()">
    <div id="header_block">
    <table>
    	<tr>
    	    <td><div id="date_time"></div></td><td><div id="spacer"></div></td><td><div id="ICA_APPLICATION_NAME ">Purchase Special products</div></td><td><div id="spacer"></div></td><td><div id="ICA_COMP_ID">Israel Credit Card LTD</div></td>  
    	</tr>
    	<tr>
	    	<td><div id="ICA_USER_NAME">IC_TSARSU</div></td><td><div id="spacer"></div></td><td> <div id="ICA_TASK_NAME">Process One Purchase </div></td><td><div id="spacer"></div></td><td><div id="ICA_TASK_ID">POP101 </div></td> 
    	</tr>
    </table>    
    </div>
    <br />
    <div id="sub_header_block">
    	<div id="PZ_OPCODE_DESC" style="position: absolute; left: 650px;">Trans </div><div id="ICA_OP_CODE" style="position: absolute; left: 700px;">TN</div>
		<div id="operateCode">: Operate code</div>		
		<div>
			<div id="underlined"><input id="customerId" width="70" value="${customer.id}" /></div>
			<div id="titelnaam">: Customer Id</div>
		</div>   
	</div>
		
    <br />
    <div id="content_block">    

    <div>
			<div id="underlined"><input id="customerName" value="${customer.name}" /></div>
			<div id="titelnaam">: Customer name</div>
	</div>
	<div>
			<div id="underlined"><input id="customerBalance" value="${customer.balance}" /></div>
			<div id="titelnaam">: Balance</div>
	</div>
	<div>
			<div id="underlined"><input id="amount"></div>
			<div id="titelnaam">: Amount</div>
	</div>
	<div>
			<div id="underlined"><input id="description" /></div>
			<div id="titelnaam">: Description</div>
	</div>
	<br />
	<div>
			<div id="underlined"><select id="currency">
					<option value="aus">AUSTRALIA</option>
					<option value="brl">BRAZIL</option>
					<option value="cad">CANADA</option>
					<option value="usd">AMERICA</option>
			</select>
			</div>
			<div id="titelnaam">: <label id="currency_label">Currency</label></div>
	</div>
	<br />
	<div>
			<div id="underlined"><input id="inEuro" /></div>
			<div id="titelnaam">: In Euro</div>
	</div>
	<div>
			<div id="underlined"><input id="balance"></div>
			<div id="titelnaam">: New Balance</div>
	</div>
	<br />
	<div align="right">
	<table>
		<tr>
			<td>
			<div id="calcButton">
					<button type="button">calculate</button>
			</div>
			</td>
			<td>
			<div id="cancelButton">
					<button>cancel</button>
			</div>
			</td>
			<td>
			<div id="goAheadButton">
					<button>go ahead</button>
			</div>
			</td>
		</tr>
	</table>
	</div>	
    </div>
    <br />
    <br />    
	<div id="footer_block"><br /></div>
	<p hidden>
		<input id="ICA_TASK_FLOW_CONTROL" value="${ioh.ICA_TASK_FLOW_CONTROL}" /> 
		<input id="ICA_CUST_ID " value="${ioh.ICA_CUST_ID}" />
    </p>
</body>
</html>
