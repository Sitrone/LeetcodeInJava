<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Save product</title>
<style type="text/css">
@import url(/css/main.css);
</style>
</head>
<body>
	<div id="global">
		<h4>The product has been saved.</h4>
		<p>
		<h5>Details:</h5>
		Product Name: ${product.name}<br/> Description:
		${product.description}<br/> Price: $${product.price}
		</p>
	</div>
</body>
</html>