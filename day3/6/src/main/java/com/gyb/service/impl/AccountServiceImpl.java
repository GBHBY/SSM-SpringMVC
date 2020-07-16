package com.gyb.service.impl;

import com.gyb.dao.AccountDao;
import com.gyb.domain.Account;
import com.gyb.service.AccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author gb
 * @Date 2020/7/16 12:40
 * @Version 1.0
 * description:
 */
@Service(value = "accountService")
public class AccountServiceImpl implements AccountService {
    @Resource
    private AccountDao accountDao;

    @Override
    public List<Account> findAll() {

        System.out.println("业务层，查询所有所有");
        return accountDao.findAll();
    }

    @Override
    public void saveAccount(Account account) {
        accountDao.saveAccount(account);
        System.out.println("业务层，保存账户");
    }
}
