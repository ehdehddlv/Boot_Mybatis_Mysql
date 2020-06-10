<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/boot.jsp"></c:import>
</head>
<body>
	<c:import url="../template/nav.jsp"></c:import>
	
		<div class="container">
		<div class="row">
		<h1>${board} Reply</h1>
			<form class="form-horizontal" action="./${board}Reply" method="post">
				<input type="hidden" name="num" value="${num}">
				
				<div class="form-group">
					<label class="control-label col-sm-2" for="title">Title:</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="title" placeholder="Enter Title" name="title">
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-sm-2" for="writer">Writer:</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="writer" name="writer" value="${member.id}" readonly="readonly">
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-sm-2" for="contents">Contents:</label>
					<div class="col-sm-10">
						<textarea rows="5" cols="" class="form-control" id="contents" name="contents"></textarea>
					</div>
				</div>
				

				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="submit" class="btn btn-default">Write</button>
					</div>
				</div>
			</form>

		</div>
	</div>

</body>
</html>