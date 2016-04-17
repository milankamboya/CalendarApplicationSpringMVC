package com.vandanpatel.calendar.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Component;

import com.vandanpatel.calendar.model.Account;

@Component("accountDAO")
public class AccountDAO {
	
	private NamedParameterJdbcTemplate jdbc;

	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}

	public List<Account> getAccounts() {
	
		return jdbc.query("select * from accounts", new RowMapper<Account>(){

			@Override
			public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
				Account account = new Account();
				
				account.setId(rs.getInt("id"));
				account.setName(rs.getString("name"));
				account.setPassword(rs.getString("password"));
				account.setEmail(rs.getString("email"));
				
				return account;
			}
			
		});
	}

	public Account getAccount(int id){
		MapSqlParameterSource params = new MapSqlParameterSource("id",id);
		
		return jdbc.queryForObject("select * from accounts where id=:id", params, new RowMapper<Account>() {

			@Override
			public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
				Account account = new Account();
				
				account.setId(rs.getInt("id"));
				account.setName(rs.getString("name"));
				account.setPassword(rs.getString("password"));
				account.setEmail(rs.getString("email"));
				
				return account;
			}
		});
	}
	
	public boolean delete(int id){
		
		MapSqlParameterSource params = new MapSqlParameterSource("id", id);
		
		return jdbc.update("delete from accounts where id=:id", params) == 1;
		
	}
	
	public boolean create(Account account){
		
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(account);
		
		return jdbc.update("insert into accounts (name, password, email) values (:name, :password, :email)", params) == 1;
	}
	
	public boolean update(Account account){
		
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(account);
		
		return jdbc.update("update accounts set name=:name, password=:password, email=:email where id=:id", params) == 1;
	}
	
	public int[] create(List<Account> accounts){
		
		SqlParameterSource[] params =  SqlParameterSourceUtils.createBatch(accounts.toArray());
		
		return jdbc.batchUpdate("insert into accounts (name, password, email) values (:name, :password, :email)", params);
	}
}
