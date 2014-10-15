<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>zapforms springdemo</title>

        <style>
            body {background-color:blue}
            h1   {font-family: "courier" ; color:white ; font-size: 16pt}
            p    {color:green}
            a:link {color: #FFFFFF;}
            a:visited {color: #FFFFFF;}
            font {font-family: "courier" ; color:white }
            td { text-align: right; color:white }

        </style>
        <script src="js/jquery.min.js"></script>


        <script type="text/javascript">
        

    	$(document).keypress(function( event ) {
		  <!-- ALT-C  231 -->
      	  if ( event.which == 231 ) {
      		if ($('#currency').is(":visible")){
      			$("#currency").hide();
      		} else {
      			$("#currency").show();
      		}
            event.preventDefault();
      	  }
      	  <!-- ALT X -->
      	  if ( event.which == 8776 ) {
              window.location.href = 'showCustomers';
      		  event.preventDefault();
       	  }
        	  
      	  
  		});

        
          $(document).ready(function () {

    			$("#currency").hide();
          	
              $("#customerId").focusout(function () {
                  ajaxGetCustomer();
              });

              $("#calcButton").click(function () {
                  ajaxCalculate();
              });
              
              $("#cancelButton").click(function () {
                  window.location.href = '.';
                  return false;
              });

              $("#goAheadButton").click(function () {
                  ajaxSave();
              });

              
              $("#customerBalance").prop("readonly",true);
              $("#customerName").prop("readonly",true);
              $("#balance").prop("readonly",true);

              function ajaxSave() {
                  var customerId = $("#customerId").val();
                  $.ajax({
                      url: 'ajax_save_customer',
                      data: 'id='+customerId+'&amount='+$("#inEuro").val()+'&balance='+$("#customerBalance").val(),
                      success: function (data) {
                          window.location.href = '.';
                      }      		
                  });
              }                

              function ajaxCalculate() {
                  var customerId = $("#customerId").val();
                  if ($('#currency').is(":visible")){
            		  var currency = $("#currency").val();
					  var calcz = $("#amount").val();
            		  if( currency == 'usd' ){
              			  $("#inEuro").val(calcz * 0.79);	
                      }
            		  if( currency == 'aus' ){
            			  $("#inEuro").val(calcz * 0.69);	
                      }
            		  if( currency == 'brl' ){
            			  $("#inEuro").val(calcz * 0.33);	
                      }
            		  if( currency == 'cad' ){
            			  $("#inEuro").val(calcz * 0.70);	
                      }

                  } else {
                      $("#inEuro").val($("#amount").val());
            	  }
                  $.ajax({
                      url: 'ajax_calc_customer',
                      data: 'id='+customerId+'&amount='+$("#inEuro").val()+'&balance='+$("#customerBalance").val(),
                      success: function (data) {
                          $("#balance").val(data);
                      }      		
                  });
              }

              function ajaxGetCustomer() {
                  var customerId = $("#customerId").val();
                  $.ajax({
                      url: 'ajax_get_customer',
                      data: ({id: customerId}),
                      success: function (data) {
                          var res = data.split("|:|");
                          $("#customerName").val(res[1]);
                          $("#customerBalance").val(res[2]);
                      }//success      		
                  });
              }
              
          });


        </script>

    <body>
    
        <table>
            <tr>
                <td><input id="customerId" width="70" value="${customer.id}" /></td><td>Customer ID (alt X)</td>
            </tr>
            <tr>
                <td><input id="customerName" value="${customer.name}" /></td><td>Customer name</td>
            </tr>
            <tr>
                <td><input id="customerBalance" value="${customer.balance}" /></td><td>Balance</td>
            </tr>
            <tr>
                <td><input id="amount"></td><td>Amount</td>
            </tr>
            <tr>
                <td><input id="description" /></td><td>Description</td>
            </tr>
            <tr>    
                <td><select id="currency">
                        <option value="aus">AUSTRALIA</option>
                        <option value="brl">BRAZIL</option>
                        <option value="cad">CANADA</option>
                        <option value="usd">AMERICA</option>                        
                    </select>           
                </td><td><label id="currency_label">Currency</label>(alt_C)</td>
            </tr>
            <tr>
                <td colspan="2"><div id="calcButton"><button type="button">calculate</button></div></td>
            </tr>
            <tr>
                <td><input id="inEuro" /></td><td>In Euro</td>
            </tr>
            <tr>
                <td><input id="balance"></td><td>New Balance</td>
            </tr>
            <tr>
                <td><div id="cancelButton"><button>cancel</button></div></td><td><div id="goAheadButton"><button>go ahead</button></div></td>
            </tr>            
        </table>
    </body>
</html>
