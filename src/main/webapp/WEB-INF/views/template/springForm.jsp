<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<form:form modelAttribute="boardVO" class="form-horizontal" action="${board}${path}" method="POST" enctype="multipart/form-data">
    <form:input path="num" type="hidden" id="num" />
    
    <div class="form-group">
      <label class="control-label col-sm-2" for="title">Title:</label>
      <div class="col-sm-10">
        <form:input path="title" type="text" class="form-control" id="title" placeholder="Enter title"/>
        <form:errors path="title" cssClass="t"></form:errors>
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="writer">Writer:</label>
      <div class="col-sm-10">          
        <input type="text" class="form-control" id="writer" placeholder="Enter writer" name="writer" value="${member.id}" readonly="readonly">
        <%-- <form:input path="writer" type="text" class="form-control" id="writer" placeholder="Enter writer" readonly="true" /> --%>
      </div>
    </div>
     <div class="form-group">
      <label class="control-label col-sm-2" for="contents">Contents:</label>
      <div class="col-sm-10">          
    	  <form:textarea path="contents" rows="" cols="" class="form-control" id="summernote" ></form:textarea>
    	  <form:errors path="contents"></form:errors>
      </div>
    </div>
    <div class="form-group">
   	 	<input type="button" class="btn btn-info" id="add" value="FileAdd">
    </div>
    <div class="form-group" id="f">
		    	
    </div>
    <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
        <button type="submit" class="btn btn-default">Submit</button>
      </div>
    </div>
  </form:form>