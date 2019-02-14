<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>     
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <title>Login Form</title>
 <link href="../../webjars/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" />
 <script src="../../webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
 <script src="../../webjars/jquery/3.0.0/js/jquery.min.js"></script>
</head>
<body>
 <div class="container">
  <spring:url value="/login" var="loginURL" />
  <h2>Enter alias an password!</h2>
  <form:form modelAttribute="userForm" method="post" action="${loginURL }" cssClass="form" >
   
   <div class="form-group">
    <label>Alias</label>
    <form:input path="alias" cssClass="form-control" id="alias" />
   </div>
   <div class="form-group">
    <label>Password</label>
    <form:input path="password" cssClass="form-control" id="password" />
   </div>
   <button type="submit" class="btn btn-primary">Login</button>
  </form:form>
  
  <c:if test="${not empty param.msgError}">
    <p style="color:red">${param.msgError}</p>
  </c:if>
  
 </div>
</body>
</html>