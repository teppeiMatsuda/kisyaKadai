package com.example.mail.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.mail.bean.SubmitMailBean;

/**
 * ���[�����MDAO
 * @author t.matsuda
 *
 */
@Repository
public class SubmitFormDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	/** �G���[�^�C�g�� */
	private static final String errorSubject = "WRYYYYYYYYYY�[�[�[�b";
	/** �G���[�{�� */
	private static final String errorMailBody = "���ʖ��ʖ��ʖ��ʖ��ʖ��ʖ��ʖ��ʃ@�[�[�[�b";

	/**
	 * address���o�^����Ă��邩�m�F
	 * @param address
	 * @return �o�^����Ă���:true,�o�^����Ă��Ȃ�:false
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
	 * ���͂��ꂽ���[����o�^
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
	 * ���͂��ꂽ���[���Ɋւ���ڍ׏���o�^</br>
	 * ����
	 * ���茳
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
