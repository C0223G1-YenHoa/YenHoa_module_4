<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 16-06-2023
  Time: 10:55 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Condiments</title>
</head>
<body>
<h1>Sandwich Condiments</h1>
<form action="/condiments" method="post">
<input type="checkbox" id="condiment1" name="condiment" value="Lettuce">
<label for="condiment1"> Lettuce</label><br>
<input type="checkbox" id="condiment2" name="condiment" value="Tomato">
<label for="condiment2">Tomato</label><br>
<input type="checkbox" id="condiment3" name="condiment" value="Mustard">
<label for="condiment3">Mustard</label><br>
<input type="checkbox" id="condiment4" name="condiment" value="Sprouts">
<label for="condiment4">Sprouts</label><br>
<button type="submit">Save</button>
<p style="color: red">You have chosen:
${listCondiments}
<c:if test="${msg!= null}">${msg}</c:if>
</p>
</form>
</body>
</html>
