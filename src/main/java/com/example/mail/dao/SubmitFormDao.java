package com.example.mail.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.mail.bean.SubmitMailBean;

/**
 * メール作成DAO
 * @author t.matsuda
 *
 */
@Repository
public class SubmitFormDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	/** 送信者不明時タイトル */
	private static final String errorSubject = "WRYYYYYYYYYYーーーッ";
	/** 送信者不明時本文 */
	private static final String errorMailBody = "無駄無駄無駄無駄無駄無駄無駄無駄ァーーーッb";

	/**
	 * address
	 * @param address
	 * @return アドレス存在時:true,アドレス非存在時:false
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
	 * メール内容登録
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
	 * 送信されたメールの詳細を登録</br>
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
	 * 宛先不明時に返すエラーメール登録
	 * @param address
	 */
	public void registErrorMail(SubmitMailBean sb, String address) {

		String mailBody =
				address+"への送信は"+errorMailBody
				+ "\r\n"
				+"subject:"+sb.getSubject()
				+ "\r\n"
				+"Mail Body:"+sb.getMailBody();
		String sql =
				"INSERT INTO "
				+ "mail(title,main) "
				+ "VALUES (?,?)";
		jdbcTemplate.update(sql,errorSubject,mailBody);
	}

	/**
	 * 宛先不明時に送信するメールの履歴登録
	 * @param address
	 */
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
