<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
      <title>Sign Up!</title>
   </head>
   <body>
      <h3>Sign Up Page</h3>
       <form name = "signupForm" method="GET" action="Controller">
         <table border="0">
         <input type ="hidden" name="action" value="signup"/>
            <tr>
               <td>First name</td>
               <td><input type="text" name="firstname" value=""/> </td>
            </tr>
            <tr>
                <td>Last name</td>
                <td><input type="text" name="lastname" value=""/> </td>
            </tr>
            <tr>
                <td>Username</td>
                <td><input type="text" name="username" value=""/> </td>
            </tr>
            <tr>
               <td>Password</td>
               <td><input type="text" name="password" value=""/> </td>
            </tr>
            <tr>
                <td>Email</td>
                <td><input type="text" name="email" value=""/> </td>
            </tr>
            <tr>
                <td>Phone</td>
                <td><input type="text" name="phone" value=""/> </td>
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