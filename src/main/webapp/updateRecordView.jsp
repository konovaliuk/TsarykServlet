<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
      <title>Update Record Status</title>
</head>
<body>
<h1>Update Record Status</h1>

<form  action="Controller" method="GET">
<input type="hidden" name="action" value="updateRecord" />
    <table style="with: 50%">
    <form  action="updateRecordView.jsp" method="GET">
        <tr>
            <td>Record Id</td>
            <td> <input type="number" name="recordId" /> </td>

        </tr>

        </table>
    <input class="btn btn-primary" type="submit" value="Submit"  />
    </form> </form>



</body>
</html>