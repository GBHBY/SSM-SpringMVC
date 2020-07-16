package com.gyb.dao;

import com.gyb.domain.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author gb
 * @Date 2020/7/15 19:15
 * @Version 1.0
 * description:
 */
@Repository
public interface AccountDao {
    /**
     * create by: gb
     * description: TODO
     * create time: 2020/7/16 12:38
     *
     * @param
     * @return 返回List集合
     */
    @Select("select * from account")
    List<Account> findAll();


    /**
     * create by: gb
     * description: 保存
     * create time: 2020/7/16 12:38
     *
     * @param account
     * @return
     */
    @Insert("insert into account (name,money) values (#{name},#{money})")
    void saveAccount(Account account);


}
