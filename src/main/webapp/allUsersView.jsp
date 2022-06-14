<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
      <title>All Users</title>
   </head>
   <body>
      <h3>All users</h3>
      <c:if test="${userId == null}">
            <a href="login.jsp">Log in to surf our site!</a>
      </c:if>
      <c:if test="${userId != null}">
      <table style="margin-top: 3ch" class="table">
              <tr>
                  <td scope="col">Login</td>
                  <td scope="col">Role</td>

              </tr>
              <tbody>

              <c:if test="${not empty users}">
              <c:forEach items="${users}" var="item">
              <tr>
                  <td><c:out value="${item.username}" /> </td>
                  <td><c:out value="${item.id_role}" /> </td>




              </tr>
              </c:forEach>
              </c:if>

              </tbody>
          </table>


      </c:if>
   </body>
</html>