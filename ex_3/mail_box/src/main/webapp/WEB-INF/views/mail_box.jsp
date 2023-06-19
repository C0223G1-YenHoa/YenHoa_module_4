<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 19-06-2023
  Time: 10:36 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>SETTING</h1>
<form:form method="post" action="/update" modelAttribute="mailBox">
    <form:hidden path="id"/>
    <label>Language</label>
    <form:select path="language" items="${languages}"/>
    <br>
    <label>Page size</label>
    Show
    <form:select path="pageSize" items="${pageSizes}"/>
    email per page
    <br>
    <label>Spams filter</label>
    <form:checkbox path="spams"/> Enable spams filter
    <br>
    <label>Signature</label>
    <form:textarea path="signature"/>
    <br>
    <button type="submit">Update</button>
    <button type="button">Cancel</button>
</form:form>
</body>
</html>
