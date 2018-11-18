package com.example.mail.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.mail.dao.AddressDao;
import com.example.mail.dto.AddressDto;

/**
 * アドレス帳一覧サービスクラスです
 */
@Service
@Transactional
public class AddressService {

	@Autowired AddressDao addressDao;

	/**
	 * addressテーブルより全データ取得
	 * @return List<AddressDao> アドレスDtoList
	 */
	public List<AddressDto> getAllAddress() {
		List<AddressDto> AddressDaoList = new ArrayList<AddressDto>();
		// アドレス一覧を取得
		List<Map<String, Object>> listMap = addressDao.getAddresses();
		for(int i = 0;i <listMap.size();i++) {
			AddressDto dto = new AddressDto();
			dto.setAddress(listMap.get(i).get("address"));
			dto.setJapaneseName(listMap.get(i).get("japaneseName"));
			dto.setUserId(listMap.get(i).get("userId"));
			AddressDaoList.add(dto);
		}
		return AddressDaoList;
	}
}