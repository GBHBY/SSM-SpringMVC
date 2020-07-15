<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2020/7/9
  Time: 14:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注解</title>
</head>
<body>
<a href="annotation/testRequestParam?username=哈哈">dsdsd</a><br>


<form action="annotation/testRequestBody" method="post">
    用户姓名： <input type="text" name="userName"/><br>
    用户年龄: <input type="text" name="age"/><br>
    <input type="submit" value="提交"><br>
</form>
<br>
<a href="annotation/testRequestHeader">testRequestHeader</a>
<br>


<a href="annotation/testCookieValue">testCookieValue</a>
<br>

<form action="annotation/testModelAttribute" method="post">
    用户姓名： <input type="text" name="userName"/><br>
    用户年龄: <input type="text" name="age"/><br>
    <input type="submit" value="提交"><br>

</form>


<br>
<a href="annotation/testSessionAttributes">testSessionAttributes</a>
<a href="annotation/testGetSessionAttributes">testGetSessionAttributes</a>



</body>
</html>
