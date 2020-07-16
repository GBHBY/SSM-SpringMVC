package com.gyb.service;

import com.gyb.domain.Account;

import java.util.List;

/**
 * @Author gb
 * @Date 2020/7/16 12:40
 * @Version 1.0
 * description:业务层
 */

public interface AccountService {

    /**
     * create by: gb
     * description: TODO
     * create time: 2020/7/16 12:38
     *
     * @param
     * @return 返回List集合
     */
    List<Account> findAll();


    /**
     * create by: gb
     * description: 保存
     * create time: 2020/7/16 12:38
     *
     * @param
     * @return
     */
    void saveAccount();
}
