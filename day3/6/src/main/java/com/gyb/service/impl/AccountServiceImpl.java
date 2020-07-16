package com.gyb.service.impl;

import com.gyb.domain.Account;
import com.gyb.service.AccountService;

import java.util.List;

/**
 * @Author gb
 * @Date 2020/7/16 12:40
 * @Version 1.0
 * description:
 */

public class AccountServiceImpl implements AccountService {


    @Override
    public List<Account> findAll() {
        System.out.println("业务层，查询所有所有");
        return null;
    }

    @Override
    public void saveAccount() {
        System.out.println("业务层，保存账户");
    }
}
