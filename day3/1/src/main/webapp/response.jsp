<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2020/7/11
  Time: 13:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery.min.js"></script>
    <script>
        <%--        页面加载，绑定单击事件--%>
        $(function () {
            $("#btn").click(function () {
                // 发送ajax请求
                $.ajax({
                    // 编写json格式，设置属性和值
                    url: "user/testJson",
                    contentType: "application/json;charset=UTF-8",
                    data: '{"userName":"hehe","password":"123","age":30}',
                    dataType: 'json',
                    type: "post",
                    success: function (data) {
                        alert(data);
                        alert(data.age)
                    },
                    error: function (json, XMLHttpReuqest) {
                        console.log(json)
                        console.log(XMLHttpRequest.status);//返回200 说明正确
                        console.log(XMLHttpReuqest.readyState);//返回4，说明饭也正确，页面可以调用这些数据
                        console.log(XMLHttpRequest.responseText);//显示返回的数据，要的就是这些数据，但是在success中却不能处理
                        console.log(textStautus);//parseerror提示这个错误，重点就在这个错误上
                        console.log(errothrown);
                    }

                });


                console.log("12312");

            });
        });

    </script>
</head>
<body>
<a href="user/testString">testString </a>
<br>
<a href="user/testVoid">3232</a>
<br>
<a href="user/testModelAndView">testModelAndView</a>
<br>
<a href="user/testForwardOrRedirect">testForwardOrRedirect</a>
<br>
<button id="btn">发送ajax的请求</button>

</body>
</html>
