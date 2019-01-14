package com.kaikeba.service.impl;

import com.kaikeba.dao.AccountDao;
import com.kaikeba.mapper.AccountMapper;
import com.kaikeba.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

//@Transactional表示该类所有方法都被事务进行管理了
//@Transactional( propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT)
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public void register(String name, double money) {
        accountMapper.insertAccount(name,money);
    }

    @Override
    public void transfer(String from, String to, double money) {
        double fromMoney = accountMapper.queryMoney(from);

        accountMapper.updateMoney(from,fromMoney - money);

        System.out.println(1 / 0);

        double toMoney = accountMapper.queryMoney(to);

        accountMapper.updateMoney(to,toMoney + money);
    }
}
