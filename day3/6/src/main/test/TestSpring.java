import com.gyb.dao.AccountDao;
import com.gyb.domain.Account;
import com.gyb.service.AccountService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Author gb
 * @Date 2020/7/16 13:01
 * @Version 1.0
 * description:测试Spring
 */

public class TestSpring {
    @Test
    public void run1() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        AccountService accountService = (AccountService) applicationContext.getBean("accountService");
        accountService.findAll();


    }


    @Test
    public void run2() throws IOException {
//        加载mybatis文件
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
//        创建sqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        AccountDao dao = sqlSession.getMapper(AccountDao.class);
        List<Account> accounts = dao.findAll();
        for (Account account : accounts) {
            System.out.println(account);

        }
        sqlSession.close();
        resourceAsStream.close();
    }
}
