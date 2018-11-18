package com.example.mail.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.mail.bean.SubmitMailBean;

/**
 * メール送信DAO
 * @author t.matsuda
 *
 */
@Repository
public class SubmitFormDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	/** エラータイトル */
	private static final String errorSubject = "WRYYYYYYYYYYーーーッ";
	/** エラー本文 */
	private static final String errorMailBody = "無駄無駄無駄無駄無駄無駄無駄無駄ァーーーッ";

	/**
	 * addressが登録されているか確認
	 * @param address
	 * @return 登録されている:true,登録されていない:false
	 */
	public boolean isExistAddress(String address) {
		Integer count;
		String sql =
				"SELECT COUNT(*) "
				+ "FROM address "
				+ "WHERE whosaddress = ?";
		count = jdbcTemplate.queryForObject(sql,Integer.class,address);
		return (count!=0)?true:false;
	}

	/**
	 * 入力されたメールを登録
	 * @param sb
	 */
	public void registMail(SubmitMailBean sb) {
		String sql =
				"INSERT INTO "
				+ "mail(title,main) "
				+ "VALUES (?,?)";
		jdbcTemplate.update(sql,sb.getSubject(),sb.getMailBody());
	}

	/**
	 * 入力されたメールに関する詳細情報を登録</br>
	 * 宛先
	 * 送り元
	 *
	 * @param sb
	 * @param address
	 */
	public void registMailHist(SubmitMailBean sb, String address) {
		String sql =
				"INSERT INTO "
					+ "to_from (mail_to,mail_from,mailid,to_deleteflg,from_deleteflg,read_flg) "
				+ "SELECT "
					+ " ? , ?, id,'0','0','0' "
				+ "FROM "
					+ "mail "
				+ "ORDER BY id DESC LIMIT 1;";
		jdbcTemplate.update(sql, address, "jojo");
	}

	/**
	 *
	 */
	public void registErrorMail() {

		String sql =
				"INSERT INTO "
				+ "mail(title,main) "
				+ "VALUES (?,?)";
		jdbcTemplate.update(sql,errorSubject,errorMailBody);
	}

	public void registErrorMailHist(String address) {
		String sql =
				"INSERT INTO "
					+ "to_from (mail_to,mail_from,mailid,to_deleteflg,from_deleteflg,read_flg) "
				+ "SELECT "
					+ " ? , ?, id,'0','0','0' "
				+ "FROM "
					+ "mail "
				+ "ORDER BY id DESC LIMIT 1;";
		jdbcTemplate.update(sql, "jojo", "DIO");
	}
}
