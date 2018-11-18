package com.example.mail.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.mail.bean.SubmitMailBean;

@Repository
public class SubmitFormDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * address‚ª“o˜^‚³‚ê‚Ä‚¢‚é‚©Šm”F
	 * @param address
	 * @return “o˜^‚³‚ê‚Ä‚¢‚é:true,“o˜^‚³‚ê‚Ä‚¢‚È‚¢:false
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
	 * “ü—Í‚³‚ê‚½ƒ[ƒ‹‚ğ“o˜^
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
	 * “ü—Í‚³‚ê‚½ƒ[ƒ‹‚ÉŠÖ‚·‚éÚ×î•ñ‚ğ“o˜^</br>
	 * ˆ¶æ
	 * ‘—‚èŒ³
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
				+ "ORDER BY recept_date DESC LIMIT 1;";
		jdbcTemplate.update(sql, address, "jojo");
	}
}
