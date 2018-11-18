package com.example.mail.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AddressDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * �A�h���X�ꗗ���擾
	 * @return List<Map<String, Object>> �A�h���X���X�g
	 */
	public List<Map<String, Object>> getAddresses() {
		String getAddressSql =
				"SELECT "
				+ "whosaddress AS address,"
				+ "userid AS userId,"
				+ "japanesename AS japaneseName "
				+ "FROM address";


		return jdbcTemplate.queryForList(getAddressSql);

	}
}