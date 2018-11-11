package com.example.mail.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class ReceptionDao {

	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	public List<Map<String, Object>> getMailList(String userId) {
		
		// SQLópïœêîíËã`
		String mailSql = "";
		// SQLçÏê¨
		mailSql = "SELECT tf.to, tf.from, tf.mailid, tf.read_flg, m.title, m.main, m.recept_date ";
		mailSql += "FROM to_from tf ";
		mailSql += "LEFT JOIN mail m ON m.id = tf.mailid ";
		mailSql += "where tf.to = ?";

		List<Map<String, Object>> list = jdbcTemplate.queryForList(mailSql, userId);
		return list;
	}
}
