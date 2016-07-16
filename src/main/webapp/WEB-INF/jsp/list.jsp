<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
    <title>所有用户</title>
  </head>
  <body>
  <c:forEach items="${findAll}" var="user" varStatus="vs">
  	<tr>  
	      <td align = "center">${vs.index}</td>  
	      <td align = "center">${user.id}</td>  
	      <td align = "center">${user.userName}</td>  
	      <td align = "center">${user.password}</td>  
    </tr>  
    <br/>
  </c:forEach>
  </body>
</html>