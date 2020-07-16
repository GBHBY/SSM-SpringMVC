package com.gyb.controller;

import com.gyb.domain.Account;
import com.gyb.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author gb
 * @Date 2020/7/16 12:42
 * @Version 1.0
 * description:控制层
 */
@Controller
@RequestMapping("account")
public class AccountController {
    @Resource
    private AccountService accountService;

    /**
     * create by: gb
     * description: 测试
     * create time: 2020/7/16 13:53
     *
     * @param
     * @return
     */
    @RequestMapping(value = "testSpringMVC")
    public String testSpring() {
        System.out.println("testSpring");
        List<Account> accounts = accountService.findAll();
        for (Account account : accounts) {
            System.out.println(account.getId());
            System.out.println(account.getName());
        }
        System.out.println("23232");
        return "success";
    }

    @RequestMapping(value = "testSave")
    public String testSave(Account account) {
        System.out.println("testSave");
        accountService.saveAccount(account);
        System.out.println(account);

        return "success";
    }

}
