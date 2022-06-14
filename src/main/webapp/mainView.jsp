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
      <c:out value="Welcome, ${user}!"/><br>
      <c:if test="${role==2}" var="condition">
            <a href="?action=allUsers">All users</a>
            <a href="createServiceView.jsp">Create service</a>
      </c:if>
      <c:if test="${role==1}">
            <a href="?action=myRecords">My records</a>
            <a href="createRecordView.jsp">Create record</a>
      </c:if>
      <c:if test="${role==3}">
            <a href="?action=myRecords">My records</a>
            <a href="updateRecordView.jsp">Update record</a>
      </c:if>
      <a href="?action=records">Records</a>
      <a href="?action=services">Services</a>

   </body>
</html>