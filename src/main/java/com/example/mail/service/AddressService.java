package com.example.mail.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;

import com.example.mail.dto.AddressDto;

/**
 * アドレス帳一覧サービスクラスです
 */
@Controller
public class AddressService {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * addressテーブより全データ取得
	 * @return List<AddressDto> アドレスDtoList
	 */
	public List<AddressDto> getAllAddress() {
		List<AddressDto> addressDtoList = new ArrayList();
		String getAddressSql =
				"SELECT "
				+ "whosaddress AS address,"
				+ "userid AS userId,"
				+ "japanesename AS japaneseName "
				+ "FROM address";
		List<Map<String, Object>> listMap = jdbcTemplate.queryForList(getAddressSql);
		for(int i = 0;i <listMap.size();i++) {
			AddressDto dto = new AddressDto();
			dto.setAddress(listMap.get(i).get("address"));
			dto.setJapaneseName(listMap.get(i).get("japaneseName"));
			dto.setUserId(listMap.get(i).get("userId"));
			addressDtoList.add(dto);
		}
		return addressDtoList;
	}
}