<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/boot.jsp"></c:import>
<style type="text/css">
	.mjfe{
		color:red;
	}
</style>
</head>
<body>
	<c:import url="../template/nav.jsp"></c:import>

	<div class="container">
		<div class="row">
			<form:form modelAttribute="memberVO" class="form-horizontal" action="./memberJoin" method="post">
				<div class="form-group">
					<label class="control-label col-sm-2" for="id">ID:</label>
					<div class="col-sm-10">
						<form:input path="id" type="text" class="form-control" id="id" placeholder="Enter ID" />
						<form:errors path="id" cssClass="mjfe"></form:errors>
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-sm-2" for="pw">PW:</label>
					<div class="col-sm-10">
						<form:input path="pw" type="password" class="form-control" id="pw" placeholder="Enter PW" />
						<form:errors path="pw" cssClass="mjfe"></form:errors>
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-sm-2" for="pwCheck">PW Check:</label>
					<div class="col-sm-10">
						<form:input path="pwCheck" type="password" class="form-control" id="pwCheck" placeholder="Enter pwCheck" />
						<form:errors path="pwCheck" cssClass="mjfe"></form:errors>
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-sm-2" for="age">Age:</label>
					<div class="col-sm-10">
						<form:input path="age" type="text" class="form-control" id="age" placeholder="Enter Age" />
						<form:errors path="age" cssClass="mjfe"></form:errors>
					</div>
				</div>
				
				
				<div class="form-group">
					<label class="control-label col-sm-2" for="email">Email:</label>
					<div class="col-sm-10">
						<form:input path="email" type="email" class="form-control" id="email" placeholder="Enter Email" />
						<form:errors path="email"></form:errors>
					</div>
				</div>				
				
						
				
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="submit" class="btn btn-default">Submit</button>
					</div>
				</div>
			</form:form>

		</div>
	</div>

</body>
</html>