package com.kaikeba.mapper;

import org.apache.ibatis.annotations.Param;

public interface AccountMapper {

    double queryMoney(String name);

    void updateMoney(@Param("name") String name, @Param("money") double money);

    void insertAccount(@Param("name") String name, @Param("money") double money);
}
