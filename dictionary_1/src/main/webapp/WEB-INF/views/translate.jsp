<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 15-06-2023
  Time: 3:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<fieldset>
    <legend>TỪ ĐIỂN</legend>
    <form action="/translate" method="get">
        <div>
            <input name="word" type="text" placeholder="Enter you want to translate: ">
            <button type="submit">Submit</button>
        </div>
        <div>
            Mean: <p style="color: red"> ${mean} ${notfound}</p>
        </div>
    </form>
</fieldset>
</body>
</html>
