<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
      <title>All Records</title>
   </head>
   <body>
      <h3>All records</h3>
      <c:if test="${userId == null}">
            <a href="login.jsp">Log in to surf our site!</a>
      </c:if>
      <c:if test="${userId != null}">
      <table style="margin-top: 3ch" class="table">
              <tr>
                  <td scope="col">ID</td>
                  <td scope="col">Date</td>
                  <td scope="col">Time</td>
                  <td scope="col">Id Service</td>
                  <td scope="col">Is Open</td>

              </tr>
              <tbody>

              <c:if test="${not empty records}">
              <c:forEach items="${records}" var="item">
              <tr>
              <td><c:out value="${item.id}" /> </td>
                  <td><c:out value="${item.date}" /> </td>
                  <td><c:out value="${item.time}" /> </td>
                  <td><c:out value="${item.id_service}" /> </td>
                  <td><c:out value="${item.is_open}" /> </td>



              </tr>
              </c:forEach>
              </c:if>

              </tbody>
          </table>

        <table style="margin-top: 3ch" class="table">
              <tr>
                  <td scope="col">Id</td>
                  <td scope="col">Name</td>
                  <td scope="col">Cost</td>

              </tr>
              <tbody>

              <c:if test="${not empty services}">
              <c:forEach items="${services}" var="item">
              <tr>
                  <td><c:out value="${item.id}" /> </td>
                  <td><c:out value="${item.name}" /> </td>
                  <td><c:out value="${item.cost}" /> </td>
              </tr>
              </c:forEach>
              </c:if>

              </tbody>
          </table>

      </c:if>
   </body>
</html>