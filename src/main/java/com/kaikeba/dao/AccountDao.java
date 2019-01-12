package com.kaikeba.dao;

public interface AccountDao {

    double queryMoney(String name);

    void updateMoney(String name,double money);

    void insertAccount(String name,double money);
}
