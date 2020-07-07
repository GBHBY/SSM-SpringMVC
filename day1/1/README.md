# SpringMVC入门案例

在这个项目中，我们要实现通过点击一个链接，从而转入另一个页面，并在后台输出数据    
#### 第一步：编辑index.jsp
```jsp
<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2020/7/6
  Time: 15:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>入门程序</h3>
    <a href="hello">入门程序</a>

</body>
</html>

```
#### 第二步：编辑controller  
- 注意我们要完成的是：点击链接，进入另一个页面并且在后台输出数据，`@RequestMapping(path = "/hello")`中的hello就是进入另一个页面的路径
- 同时success就是进入的页面的名字
```java
@Controller
public class HelloController {
    
    /**
     * create by: gb
     * description:
     *  /hello就是这个方法的请求路径
     * create time: 2020/7/6 15:27
     * @param 
     * @return null
     */

    @RequestMapping(path = "/hello")
    public String sayHello(){
        System.out.println("啦啦啦");
        return "success";
    }
}

```
#### 第三步：在WEB-INF下创建pages以及success.jsp
#### 第四步：编写success.jsp
```jsp
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>成功</h3>
</body>
</html>

```
- 此时，两个页面都写完了，controller也写完了，但是controller和两个页面没有建立起链接，这就需要配置文件
#### 第五步： 编写SpringMVC.xml
```xml
    <!--开启注解扫描-->
    <context:component-scan base-package="com.gyb"/>

    <!--配置视图解析器-->
    <bean id="internalResourceViewResolver" class="org.springframework.web.servlet.view.InternalResourceViewResolver">
        <property name="prefix" value="/WEB-INF/pages/"/>
        <property name="suffix" value=".jsp"/>
    </bean>
    <!--开启SpringMVC注解的支持-->
    <mvc:annotation-driven/>

```
- 注意：72、73里的name是固定的
#### 第六步：编写web.xml
```xml
<!--前端控制器-->
  <servlet>
    <servlet-name>dispatcherServlet</servlet-name>
    <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
    <init-param>
      <!--加载springMVC.xml-->
      <param-name>contextConfigLocation</param-name>
      <param-value>classpath:SpringMVC.xml</param-value>
    </init-param>
    <!--不知道是干嘛的-->
    <load-on-startup>1</load-on-startup>
  </servlet>
  <servlet-mapping>
    <servlet-name>dispatcherServlet</servlet-name>
    <url-pattern>/</url-pattern>
  </servlet-mapping>

```
#### 流程解释
- 启动tomcat的时候会从web.xml中加载配置  
    1. DispatcherServlet对象创建    
    2. springMVC.xml被加载，通过配置文件中的包扫描，得到HelloController.java并创建类对象     
- 点击index.jsp中的连接后，根据mvc注解，会发送请求，这个请求会被dispatcherServlet得到，因为我们在web.xml中配置了
```xml
 <servlet-mapping>
    <servlet-name>dispatcherServlet</servlet-name>
    <url-pattern>/</url-pattern>
  </servlet-mapping>
```
- `/`会拦截所有的请求，而dispatcherServlet是前端控制器，起到控制的作用
- dispatcherServlet会根据`@RequestMapping(path = "/hello")`这个注解找到该方法，并执行
- dispatcherServlet会找到视图解析器`InternalResourceViewResolver`，因为我们在springMVC.xml中对seccess.jsp进行了配置
，从而跳转到success.jsp文件，
- ![Alt text](03.bmp)
- ![Alt text](04.bmp)

#### RequestMapping注解

- 作用：建立请求和Java方法之间的关系
- 属性：
  - value:和path作用一样，都是映射的路径
  - path:和value的作用一样，都是映射的路径
  - method：规定请求方式，比如`@RequestMapping(path = "/hello",method = {RequestMethod.POST})`，此时，只有post请求才会触发方法

