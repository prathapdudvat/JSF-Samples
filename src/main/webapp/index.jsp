<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="js/jquery.mobile-1.4.5/jquery.mobile-1.4.5.css"><!-- 
<link rel="stylesheet" href="js/jquery.mobile-1.4.5/jquery.mobile.datepicker.css" />
<link rel="stylesheet" href="js/jquery.mobile-1.4.5/jquery.mobile.datepicker.theme.css" /> -->
	
<script src="js/jquery-1.11.3.js"></script>
<script src="js/jquery.mobile-1.4.5/jquery.mobile-1.4.5.js"></script>
<!-- <script src="js/jquery-ui/datepicker.js"></script>
<script src="js/jquery.mobile-1.4.5/jquery.mobile.datepicker.js"></script> -->
<script src="js/jquery-ui/jquery-ui.js"></script>

</head>
<body>

<div data-role="page" id="indexpage">
  <div data-role="header">
    <jsp:include page="header.jsp" ></jsp:include>
  </div>

  <div data-role="main" class="ui-content">
    <p>welcome to rms</p>
  </div>

  <div data-role="footer">
    <jsp:include page="footer.jsp" ></jsp:include>
  </div>
</div> 


<!--  add page -->
<div data-role="page" id="addpurchasepage">
  <div data-role="header">
    <jsp:include page="header.jsp" ></jsp:include>
  </div>

  <div data-role="main" class="ui-content">
   <jsp:include page="addpurchase.jsp"></jsp:include>
  </div>

  <div data-role="footer">
    <jsp:include page="footer.jsp" ></jsp:include>
  </div>
</div> 


<!-- current Month -->
<div data-role="page" id="addpurchasepage">
  <div data-role="header">
    <jsp:include page="header.jsp" ></jsp:include>
  </div>

  <div data-role="main" class="ui-content">
   <jsp:include page="searchpurchase.jsp"></jsp:include>
  </div>

  <div data-role="footer">
    <jsp:include page="footer.jsp" ></jsp:include>
  </div>
</div> 

</body>
</html>