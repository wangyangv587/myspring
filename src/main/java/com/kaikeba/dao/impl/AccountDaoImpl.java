package com.kaikeba.dao.impl;

import com.kaikeba.dao.AccountDao;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao {
    @Override
    public void insertAccount(String name, double money) {
        this.getJdbcTemplate().update("insert into account(name,money)values(?,?)",name,money);
    }

    @Override
    public double queryMoney(String name) {
        return this.getJdbcTemplate().queryForObject("select money from account where name=?",new AccountMapper(),name);
    }

    @Override
    public void updateMoney(String name, double money) {
        this.getJdbcTemplate().update("update account set money=? where name=?",money,name);
    }
}
class AccountMapper implements RowMapper<Double> {

    @Override
    public Double mapRow(ResultSet resultSet, int i) throws SQLException {
        return resultSet.getDouble("money");
    }
}
