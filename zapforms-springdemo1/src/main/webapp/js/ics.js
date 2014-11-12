	function startTime() {
		var today=new Date();
		var h=today.getHours();
		var m=today.getMinutes();
		var s=today.getSeconds();
		var day=today.getUTCDate();
		var month=today.getMonth();
		var year=today.getUTCFullYear();
		m = checkTime(m);
		s = checkTime(s);
		document.getElementById('date_time').innerHTML = day+"/"+month+"/"+year+" "+h+":"+m+":"+s;
		var t = setTimeout(function(){startTime()},500);
	}

	function checkTime(i) {
	    if (i<10) {i = "0" + i};  // add zero in front of numbers < 10
	    return i;
	}

	jQuery(document).keypress(function(e) {
	    code = e.keyCode ? e.keyCode : e.which;
	    if(code.toString() == 25) { // CTRL Y
			if ($('#currency').is(":visible")) {
				$("#currency").hide();
			} else {
				$("#currency").show();
			}
	    }
	    if(code.toString() == 17) {   // CTRL Q
			window.location.href = './';	
	    }	    
	});

	$(document).ready(
			
			function() {

				$("#currency").hide();
			
				$("#customerId").focusout(function() {
					ajaxGetCustomer();
				});

				$("#calcButton").click(function() {
					ajaxCalculate();
				});

				$("#cancelButton").click(function() {
					window.location.href = '.';
					return false;
				});

				$("#goAheadButton").click(function() {
					ajaxSave();
				});

				$("#customerBalance").prop("readonly", true);
				$("#customerName").prop("readonly", true);
				$("#balance").prop("readonly", true);

				function ajaxSave() {
					var customerId = $("#customerId").val();
					$.ajax({
						url : 'ajax_save_customer',
						data : 'id=' + customerId + '&amount='
								+ $("#inEuro").val() + '&balance='
								+ $("#customerBalance").val(),
						success : function(data) {
							window.location.href = '.';
						}
					});
				}

				function ajaxCalculate() {
					var customerId = $("#customerId").val();
					if ($('#currency').is(":visible")) {
						var currency = $("#currency").val();
						var calcz = $("#amount").val();
						if (currency == 'usd') {
							$("#inEuro").val(calcz * 0.79);
						}
						if (currency == 'aus') {
							$("#inEuro").val(calcz * 0.69);
						}
						if (currency == 'brl') {
							$("#inEuro").val(calcz * 0.33);
						}
						if (currency == 'cad') {
							$("#inEuro").val(calcz * 0.70);
						}

					} else {
						$("#inEuro").val($("#amount").val());
					}
					$.ajax({
						url : 'ajax_calc_customer',
						data : 'id=' + customerId + '&amount='
								+ $("#inEuro").val() + '&balance='
								+ $("#customerBalance").val(),
						success : function(data) {
							$("#balance").val(data);
						}
					});
				}

				function ajaxGetCustomer() {
					var customerId = $("#customerId").val();
					$.ajax({
						url : 'ajax_get_customer',
						data : ({
							id : customerId
						}),
						success : function(data) {
							var res = data.split("|:|");
							$("#customerName").val(res[1]);
							$("#customerBalance").val(res[2]);
							$("#ICA_TASK_FLOW_CONTROL").val(res[3]);
						}//success      		
					});
				}

			});
