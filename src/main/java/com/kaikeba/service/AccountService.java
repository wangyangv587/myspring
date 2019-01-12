package com.kaikeba.service;

import com.kaikeba.entity.Account;

public interface AccountService {

    void transfer(String from,String to,double money);

    void register(String name,double money);

}
