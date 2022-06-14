<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
      <title>Hello!</title>
   </head>
   <body>
      <h3>Hello!</h3>
      <c:if test="${isAdmin==true}" scope="session">
            <p>True</p>
      </c:if>
      <c:if test="${isAdmin==false}" scope="session">
            <p>False</p>
      </c:if>
      <a href = "Controller">Return to login</a>
   </body>
</html>