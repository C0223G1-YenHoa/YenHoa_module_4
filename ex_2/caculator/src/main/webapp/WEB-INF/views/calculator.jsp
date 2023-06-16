<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 16-06-2023
  Time: 2:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Caculator</title>
</head>
<body>
<form action="/calculator" method="post">
    <input type="number" placeholder="first number" name="first" required>
    <input type="number" placeholder="second number" name="second" required>
    <button name="operation"  value="Addition">Addition</button>
    <button name="operation" value="Subtraction">Subtraction</button>
    <button name="operation" value="Multiplication">Multiplication</button>
    <button name="operation" value="Division">Division</button>
    <p style="color: green">Result: ${result}</p>
    <span style="color: red">${msg}</span>
</form>
</body>
</html>
