<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="./template/boot.jsp"></c:import>
<link href="./css/test.css" rel="styleSheet" type="text/css">
</head>
<body>
	<c:import url="./template/nav.jsp"></c:import>

	<div class="container">
		<h1>Index Page</h1>
		<h1><spring:message code="hello"></spring:message> </h1>
		<h1><spring:message code="member.welcome" arguments="${member.id},${phone}" argumentSeparator=","></spring:message> </h1>
		<h1><spring:message code="member.deny" text="Default Message"></spring:message> </h1>
		<spring:message code="member.update" text="test message" var="test"></spring:message>
		<img alt="" src="./images/iu1.jpg">
		<h1>${test}</h1>
	</div>

	<script type="text/javascript" src="./js/test.js"></script>
	<script type="text/javascript">
		//start();
	</script>
</body>
</html>