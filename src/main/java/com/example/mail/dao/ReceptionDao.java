package com.example.mail.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public class ReceptionDao {

	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	public List<Map<String, Object>> getMailList(String userId) {
		
		// SQL用変数定義
		String mailSql = "";
		// SQL作成
		mailSql = "SELECT tf.mail_to, tf.mail_from, tf.mailid, tf.read_flg, m.title, m.main, m.recept_date ";
		mailSql += "FROM to_from tf ";
		mailSql += "LEFT JOIN mail m ON m.id = tf.mailid ";
		mailSql += "where tf.mail_to = ? AND to_deleteflg = 0";

		List<Map<String, Object>> list = jdbcTemplate.queryForList(mailSql, userId);
		return list;
	}

	@Transactional(rollbackFor = Exception.class)
	public void updateMailList(String userId, String maildata[], String deleteflg, String midokuflg) {
		
		// SQL用変数定義
		String mailSql = "";
		
		// SQLバインド変数
		Map<String, Object> bind = new HashMap<String, Object>();
		bind.put("to", userId);
		if(deleteflg != null) {
			if(deleteflg.equals("1")) {
				// SQL作成
				mailSql = "UPDATE to_from tf";
				mailSql += " SET tf.to_deleteflg = 1";
			}
		}
		if(midokuflg != null) {
			if(midokuflg.equals("1")) {
				// SQL作成
				mailSql = "UPDATE to_from tf";
				mailSql += " SET tf.read_flg = 0";
			}
		}
		mailSql += " WHERE tf.mail_to = " + userId;
		
		String mailIdList = "";
		int i = 0;
		if(maildata != null) {
			for(String mail : maildata){
				if(i == 0) {
					mailIdList += mail;
				}else {
					mailIdList += ", " + mail;
				}
				i++;
			}
			mailSql += " AND tf.mailid IN (" + mailIdList + ")";
			jdbcTemplate.update(mailSql);
		}

		return;
	}
}
