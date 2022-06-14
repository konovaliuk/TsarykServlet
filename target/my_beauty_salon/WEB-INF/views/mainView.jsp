<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
      <title>Login</title>
   </head>
   <body>
      <h3>Login Page</h3>
       <form name = "loginForm" method="GET" action="Controller">
         <table border="0">
         <input type ="hidden" name="action" value="login"/>
            <tr>
               <td>Username</td>
               <td><input type="text" name="username" value=""/> </td>
            </tr>
            <tr>
               <td>Password</td>
               <td><input type="text" name="password" value=""/> </td>
            </tr>
            <tr>
               <td colspan ="2">
                  <input type="submit" value= "Submit" />
               </td>
            </tr>
         </table>
      </form>
   </body>
</html>