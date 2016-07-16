<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/> 
<html>
  <head>
    <title>spark任务</title>
  </head>
  <body>
   <form action="${ctx}/ssh/run.do" method="post" > 
     <table>
     <tr>
       <td>master:</td>
       <td><input type="text" name="master"/></td>
      </tr>
      <tr>
      <tr>
       <td>class:</td>
       <td><input type="text" name="clazz"/></td>
      </tr>
      <tr>
       <td>path:</td>
       <td><input type="text" name="jarParh"/></td>
      </tr>
      <tr>
       <td colspan="2"><input type="submit" name="提交"/></td>
      </tr>
     </table>
   </form>
   <h1>${errorMsg}</h1>  
  </body>
</html>