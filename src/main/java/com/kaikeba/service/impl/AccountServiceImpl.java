package com.kaikeba.service.impl;

import com.kaikeba.dao.AccountDao;
import com.kaikeba.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Override
    public void register(String name, double money) {
        accountDao.insertAccount(name,money);
    }

    @Override
    public void transfer(String from, String to, double money) {
        double fromMoney = accountDao.queryMoney(from);

        accountDao.updateMoney(from,fromMoney - money);

        //System.out.println(1 / 0);

        double toMoney = accountDao.queryMoney(to);

        accountDao.updateMoney(to,toMoney + money);
    }
}
