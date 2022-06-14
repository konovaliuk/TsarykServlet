<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
      <title>Create Service</title>
</head>
<body>
<h1>Create new service</h1>

<form  action="Controller" method="GET">
<input type="hidden" name="action" value="createService" />
    <table style="with: 50%">
    <form  action="createServiceView.jsp" method="GET">
        <tr>
            <td>Name</td>

            <td> <input type="text" name="name" /> </td>

        </tr>
        <tr>
            <td>Cost</td>
            <td><input type="number" name="cost" /></td>
        </tr>


        </table>
    <input class="btn btn-primary" type="submit" value="Submit"  />
    </form> </form>



</body>
</html>