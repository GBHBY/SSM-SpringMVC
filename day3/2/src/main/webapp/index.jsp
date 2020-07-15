<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2020/7/12
  Time: 13:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>
<h3>啦啦啦啦</h3>
<%--传统方式上传文件--%>
<%--<form action="file/fileUpload1" method="post" enctype="multipart/form-data">
    选择文件<input type="file" name="upload"> <br>
    <input type="submit" value="上传"><br>
</form>--%>
<%--SpringMVC方式上传--%>
<form action="springMvcFileUploadController/fileUpload" method="post" enctype="multipart/form-data">
    选择文件<input type="file" name="upload"> <br>
    <input type="submit" value="上传"><br>
</form>

<br>



</body>
</html>
