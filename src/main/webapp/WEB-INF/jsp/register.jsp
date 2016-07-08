<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/> 
<html>
  <head>
    <title>新增用户</title>
  </head>
  <body>
   <form action="${ctx}/user/register.do" method="post" > 
     <table>
     <tr>
       <td>账户:</td>
       <td><input type="text" name="id"/></td>
      </tr>
      <tr>
      <tr>
       <td>用户名:</td>
       <td><input type="text" name="userName"/></td>
      </tr>
      <tr>
       <td>密码:</td>
       <td><input type="password" name="password"/></td>
      </tr>
      <tr>
       <td colspan="2"><input type="submit" name="提交"/></td>
      </tr>
     </table>
   </form>
   <h1>${errorMsg}</h1>  
  </body>
</html>