<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
      <title>Error!</title>
   </head>
   <body>
      <h3>Error!</h3>
      <c:out value="${error}"/>
      <a href = "Controller">Return to login</a>
   </body>
</html>