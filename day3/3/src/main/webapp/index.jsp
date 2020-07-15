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
<%--将文件上传到2项目中--%>
<form action="springMvcFileUploadController/fileUpload" method="post" enctype="multipart/form-data">
    选择文件<input type="file" name="upload"> <br>
    <input type="submit" value="上传"><br>
</form>



</body>
</html>
