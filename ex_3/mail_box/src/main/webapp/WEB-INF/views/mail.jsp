<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 19-06-2023
  Time: 11:04 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table>
        <tr>
            <th>STT</th>
            <th>Language</th>
            <th>Page Size</th>
            <th>Spams filter</th>
            <th>Signature</th>
        </tr>
    <c:forEach var="mail" items="${mailList}" varStatus="loop">
        <tr>
            <td>${loop.count}</td>
            <td>${mail.language}</td>
            <td>${mail.pageSize}</td>
            <td>
                  <c:if test="${mail.spams==true}">Spams</c:if>
                  <c:if test="${mail.spams==false}">Not spams</c:if>
            </td>
            <td>${mail.signature}</td>
            <td>
                <form method="get" action="/showEditForm/${mail.id}">
                <button type="submit">Edit</button>
                </form>
            </td>
        </tr>
    </c:forEach>
    </table>

</body>
</html>
