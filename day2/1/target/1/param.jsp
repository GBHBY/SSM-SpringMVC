<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2020/7/7
  Time: 14:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>请求参数绑定</title>
</head>
<body>
<%--    <a href="param/testParam?userName=gyb&password=123456">请求参数绑定</a>--%>
<%--
    数据封装到Account的User中
<form action="param/saveAccount" method="post">
    姓名：<input type="text" name="userName"/><br/>
    密码：<input type="text" name="password"/><br/>
    金额：<input type="text" name="money"/><br/>
    UserName：<input type="text" name="user.age"/><br/>
    age：<input type="text" name="user.userName"/><br/>
    <input type="submit" value="提交" >

</form>--%>


<%--数据封装到List和Map中--%>
<%--<form action="param/saveAccount" method="post">
    姓名：<input type="text" name="userName"/><br/>
    密码：<input type="text" name="password"/><br/>
    金额：<input type="text" name="money"/><br/>

    ListUserName：<input type="text" name="userList[0].userName"/><br/>
    age：<input type="text" name="userList[0].age"/><br/>

    MapUserName：<input type="text" name="userMap['one'].userName"/><br/>
    age：<input type="text" name="userMap['one'].age"/><br/>


    <input type="submit" value="提交" >--%>


<%--自定义类型转换器--%>
<form action="param/saveUser" method="post">

    ListUserName：<input type="text" name="userName"/><br/>
    age：<input type="text" name="age"/><br/>
    生日：<input type="text" name="date"/><br/>
    <input type="submit" value="提交" >

</form>


</body>
</html>
