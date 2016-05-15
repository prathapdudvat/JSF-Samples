<div data-demo-html="true">
	<form id="purchaseform" action="rest/purchase/save" method="POST">
		<div class="ui-field-contain">
			<label for="transDate">Date:</label> <input type="text"
				data-role="date" required="required" autofocus="autofocus"
				name="transDate" id="transDate"
				placeholder="Purchase Date(yyyy-MM-dd)" value="" maxlength="10">
		</div>
		<div class="ui-field-contain">
			<label for="item">Item:</label> <input type="text"
				required="required" name="item" id="item" placeholder="Item Details"
				value="" maxlength="100">
		</div>
		<div class="ui-field-contain">
			<label for="amount">Amount:</label> <input type="range"
				required="required" name="amount" id="amount" min="10" max="1000"
				value="10">
		</div>
		<div class="ui-field-contain" align="center">
			<input type="button" id="submitBtn" class="ui-corner-all"
				value="Submit" data-enhanced="true"> <input type="reset"
				class="ui-corner-all" value="Reset" data-enhanced="true">
		</div>
	</form>
</div>
<script type="text/javascript">
	$(document).ready(function(){
		$("#submitBtn").click(function(e){
				e.preventDefault();
				alert('clicked');
				var transDate = $("#transDate").val();
				var item=$("#item").val();
				var amount=$("#amount").val();
				var createdBy="prathapd";
				if(transDate==''||item==''||amount==''||amount=='0'){
					alert('All fields are required');
					return;
				}else{
					alert('posting');
					$.ajax({
				    type: 'POST',
				    url: 'rest/purchase/save',
				    data: '{"transDate":"'+transDate+'","item":"'+item+'","amount":"'+amount+'","createdBy":"'+createdBy+'"}', // or JSON.stringify ({name: 'jonas'}),
				    success: function(data) { 
				    	alert('data: ' + data); 
				    },
				    error:function(jqXHR,textStatus,error){
				    	alert('error'+error);
				    },
				    contentType: "application/json"
					});
				}
		});
		
		 /* 
		$( "#transDate" ).datepicker( "option", "maxDate", "-1" );
		$( "#transDate" ).datepicker( "option", "stepMonths", "0" );
		$( "#transDate" ).datepicker( "option", "dateFormat", "yyyy-MM-dd" ); */
	});
</script>
</body>
</html>