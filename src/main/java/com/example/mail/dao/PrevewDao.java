package com.example.mail.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class PrevewDao {

	@Autowired
    private JdbcTemplate jdbcTemplate;

	/*
	 * 受信メール用
	 */
	public List<Map<String, Object>> getMailData(String mailId) {
		
		// SQL用変数定義
		String mailSql = "";
		
		// SQL作成
		mailSql = "SELECT title,main FROM mail WHERE id = ?";

		List<Map<String, Object>> list = jdbcTemplate.queryForList(mailSql, mailId);
		
		// SQL用変数定義
		String updateSql = "";
		
		updateSql = "UPDATE to_from SET read_flg = 1 WHERE mailid = ?";
		
		jdbcTemplate.update(updateSql, mailId);
		
		return list;
	}
	
	/*
	 * 送信メール用
	 */
	public List<Map<String, Object>> getMailData(String mailId, int submitFlg) {
		
		// SQL用変数定義
		String mailSql = "";
		
		// SQL作成
		mailSql = "SELECT title,main FROM mail WHERE id = ?";

		List<Map<String, Object>> list = jdbcTemplate.queryForList(mailSql, mailId);
		
		return list;
	}

}
