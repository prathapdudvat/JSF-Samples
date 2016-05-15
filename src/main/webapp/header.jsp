
<h1>Room Expense Management System</h1>
<div data-role="navbar">
	<ul>
		<li><a href="#indexpage">Home</a></li>
		<li><a href="#addpurchasepage" >Add Purchase</a></li>
		<li><a href="#searchpurchasepage" id="search">Search</a></li>
	</ul>
</div>

<script type="text/javascript">
	$(document).ready(function(){
		$("#search").click(function(e){
				e.preventDefault();
				alert('clicked');
				var currDate = new Date();
				var transDate=currDate.getFullYear()+"-"+month(currDate.getMonth())+"-"+"01";
				var item='';
				var amount='0';
				var createdBy="prathapd";
					alert('searching');
					$.ajax({
				    type: 'POST',
				    url: 'rest/purchase/search',
				    data: '{"transDate":"'+transDate+'","item":"'+item+'","amount":"'+amount+'","createdBy":"'+createdBy+'"}', // or JSON.stringify ({name: 'jonas'}),
				    success: function(data) { 
				    	alert('data: ' + data); 
				    },
				    error:function(jqXHR,textStatus,error){
				    	alert('error'+error);
				    },
				    contentType: "application/json",
				    dataType:'json'
					});
				
		});
		
		function month(num){
			if(num<10){
				return "0"+(num+1);
			}else{
				return (num+1);
			}
		}
	});
</script>
