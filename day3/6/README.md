# 整合SSM
- spring整合SpringMVC，启动tomcat服务器的时候，需要加载spring的配置文件

  - 配置监听器，来加载spring配置文件 

- 整合Mybatis

- ```xml
      <!--spring整合mybatis-->
      <!--配置连接池-->
      <bean id="dataSource" class="com.mchange.v2.c3p0.ComboPooledDataSource">
          <property name="driverClass" value="com.mysql.jdbc.Driver"/>
          <property name="jdbcUrl" value="jdbc:mysql:///ssm"/>
          <property name="user" value="root"/>
          <property name="password" value="123456"/>
  
      </bean>
      <!--配置工厂对象-->
  
      <bean id="sessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
          <property name="dataSource" ref="dataSource"/>
      </bean>
      <!--配置接口所在的包-->
      <bean id="mapperScannerConfigurer" class="org.mybatis.spring.mapper.MapperScannerConfigurer">
          <property name="basePackage" value="com.gyb.dao"/>
      </bean>
  
  ```

  - 配置Spring框架声明式事务管理

