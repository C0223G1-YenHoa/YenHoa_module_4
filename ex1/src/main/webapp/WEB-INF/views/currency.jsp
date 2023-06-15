<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 15-06-2023
  Time: 1:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/currency" method="post">
    <fieldset>
        <legend>CHUYỂN ĐỔI TIỀN TỆ</legend>
        <div>
            <input name="money" type="number" placeholder="Nhập tiền" min="1" required>
            <input name="rate" type="number" placeholder="Tỷ giá" required min="1">
            <input type="submit" value="submit">
        </div>
        <div>
            Result:
            <fmt:formatNumber type="number" maxFractionDigits="3" value="${money}"/>
        </div>
    </fieldset>
</form>
</body>
</html>
