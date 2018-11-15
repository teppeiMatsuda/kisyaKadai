package com.example.mail.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class LoginDao {

	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	public List<Map<String, Object>> getUser(String loginId, String passWord) {
		
		// SQL用変数定義
		String userSql = "";
		// SQL作成
		userSql = "SELECT id,userid ";
		userSql += "FROM user ";
		userSql += "where userid = ? AND password = ? ";

		List<Map<String, Object>> list = jdbcTemplate.queryForList(userSql, loginId, passWord);
		return list;
	}

}
