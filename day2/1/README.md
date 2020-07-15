# 请求参数绑定

#### 项目目标

- 从前台获取数据到后台
- 自定义类型转换器
- 处理乱码

##### 从前台获取数据到后台    



```java
@Controller
@RequestMapping("/param")
public class ParamController {

    /**
     * create by: gb
     * description: 请求参数绑定入门方法
     * create time: 2020/7/7 14:47
     *
     * @param
     * @param userName
     * @param password
     * @return
     */
    @RequestMapping(value = "testParam")
    public String testParam(String userName, String password) {
        System.out.println("请求参数绑定");
        System.out.println("用户名" + userName);
        System.out.println("密码" + password);
        return "testParam";
    }
}
```

```html
  <a href="param/testParam?userName=gyb&password=123456">请求参数绑定</a>
```

此时，后台输出结果就是

```
请求参数绑定
用户名 gyb
密码 123456
```

- 如果参数列表是实体类型

```java

    /**
     * create by: gb
     * description: 保存账户，用来测试param.jsp中的表单
     * create time: 2020/7/7 15:03
     *
     * @param account
     * @return
     */
    @RequestMapping(value = "saveAccount")
    public String saveAccount(Account account) {
        System.out.println(account);
        return "testParam";
    }

```

```html
<form action="param/saveAccount" method="post">
    姓名：<input type="text" name="userName"/><br/>
    密码：<input type="text" name="password"/><br/>
    金额：<input type="text" name="money"/><br/>
    <input type="submit" value="提交">

</form>

```

此时，在前台输入的数据，就会传到后台

- 如果实体类型中的属性还有一个实体类型，获取方式如下

  Account

  ```java
  public class Account implements Serializable {
      private String userName;
      private String password;
      private Double money;
      private User user;
  ```

  

  User

  ```java
  public class User implements Serializable {
      private String userName;
      private Integer age;
      private Date date;
  ```

  param.jsp

  ```jsp
  <form action="param/saveAccount" method="post">
      姓名：<input type="text" name="userName"/><br/>
      密码：<input type="text" name="password"/><br/>
      金额：<input type="text" name="money"/><br/>
      UserName：<input type="text" name="user.age"/><br/>
      age：<input type="text" name="user.userName"/><br/>
      <input type="submit" value="提交" >
  
  </form>
  ```

  Controller

  ```java
      /**
       * create by: gb
       * description: 保存账户，用来测试param.jsp中的表单
       * create time: 2020/7/7 15:03
       *
       * @param account
       * @return
       */
      @RequestMapping(value = "saveAccount")
      public String saveAccount(Account account) {
          System.out.println(account);
          return "testParam";
      }
  ```

  - 如果实体类中的属性有集合，那么代码如下

  jsp

  ```jsp
  <form action="param/saveAccount" method="post">
      姓名：<input type="text" name="userName"/><br/>
      密码：<input type="text" name="password"/><br/>
      金额：<input type="text" name="money"/><br/>
  
      ListUserName：<input type="text" name="userList[0].userName"/><br/>
      age：<input type="text" name="userList[0].age"/><br/>
  
      MapUserName：<input type="text" name="userMap['one'].userName"/><br/>
      age：<input type="text" name="userMap['one'].age"/><br/>
  
  
      <input type="submit" value="提交" >
  ```

  Account

  ```java
  public class Account implements Serializable {
      private String userName;
      private String password;
      private Double money;
      private List<User> userList;
      private Map<String, User> userMap;
  ```

  Controller

  ```java
      /**
       * create by: gb
       * description: 保存账户，用来测试param.jsp中的表单
       * create time: 2020/7/7 15:03
       *
       * @param account
       * @return
       */
      @RequestMapping(value = "saveAccount")
      public String saveAccount(Account account) {
          System.out.println(account);
          return "testParam";
      }
  ```



##### 自定义类型转换器

- 有的时候，我们在表单中传入日期，Java能识别的是'xxxx/x/xx'，但如果是‘xxxx-xx-xx’，这个就不会被Java识别成日期，会乱码，所以，我们要对这种日期进行转换，SpringMVC内置了很多的自动转换类型，都是基于Converter接口，我们也可以实现这个接口来完成我们自己想要的类型转换

  **![image-20200709134200158](C:\Users\asus\AppData\Roaming\Typora\typora-user-images\image-20200709134200158.png)**
  - 首先我们要自己实现一个类型转换的并实现Converter接口

  - 在SpringMVC.xml文件中注册我们自定义的转换器

    ```java
    /**
     * @Author gb
     * @Date 2020/7/8 17:06
     * @Version 1.0
     * description:字符串转日期
     */
    
    public class StringToDateConverter implements Converter<String, Date> {
    
    
        /**
         * create by: gb
         * description: TODO
         * create time: 2020/7/8 17:08
         *
         * @param source 传入进来的字符串
         * @return
         */
        @Override
        public Date convert(String source) {
    //        判断是否为空
            if (source == null) {
                throw new RuntimeException("日期有误");
            }
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            try {
    //把字符串转成日期
                return dateFormat.parse(source);
            } catch (ParseException e) {
                throw new RuntimeException("数据类型转换错误");
            }
    
        }
    }
    
    ```

    ```xml
    
        <!--配置自定义类型转换器-->
        <bean id="conversionServiceFactoryBean" class="org.springframework.context.support.ConversionServiceFactoryBean">
            <property name="converters" >
                <set>
                    <bean class="com.gyb.ustils.StringToDateConverter"/>
                </set>
            </property>
        </bean>
        <!--开启SpringMVC注解的支持,把转换器放进来-->
        <mvc:annotation-driven conversion-service="conversionServiceFactoryBean"/>
    ```

    这样就可以了

##### 处理乱码

```xml
 <!--配置解决中文乱码的过滤器-->
    <filter>
        <filter-name>characterEncodingFilter</filter-name>
        <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
        <init-param>
            <param-name>encoding</param-name>
            <param-value>UTF-8</param-value>
        </init-param>
    </filter>
    <filter-mapping>
        <filter-name>characterEncodingFilter</filter-name>
        <url-pattern>/*</url-pattern>
    </filter-mapping>
```

这样就可以了

##### 

##### 