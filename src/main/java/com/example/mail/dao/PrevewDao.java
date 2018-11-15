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
	 * ��M���[���p
	 */
	public List<Map<String, Object>> getMailData(String mailId) {
		
		// SQL�p�ϐ���`
		String mailSql = "";
		
		// SQL�쐬
		mailSql = "SELECT title,main FROM mail WHERE id = ?";

		List<Map<String, Object>> list = jdbcTemplate.queryForList(mailSql, mailId);
		
		// SQL�p�ϐ���`
		String updateSql = "";
		
		updateSql = "UPDATE to_from SET read_flg = 1 WHERE mailid = ?";
		
		jdbcTemplate.update(updateSql, mailId);
		
		return list;
	}
	
	/*
	 * ���M���[���p
	 */
	public List<Map<String, Object>> getMailData(String mailId, int submitFlg) {
		
		// SQL�p�ϐ���`
		String mailSql = "";
		
		// SQL�쐬
		mailSql = "SELECT title,main FROM mail WHERE id = ?";

		List<Map<String, Object>> list = jdbcTemplate.queryForList(mailSql, mailId);
		
		return list;
	}

}
