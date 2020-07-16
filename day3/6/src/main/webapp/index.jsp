<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2020/7/16
  Time: 13:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="account/testSpringMVC">测试</a>
<h3>测试保存</h3>
<form action="account/testSave" method="post">
    姓名：<input type="text" name="name"/>
    金额：<input type="text" name="money"/>
    <input type="submit" value="保存">


</form>

</body>
</html>
