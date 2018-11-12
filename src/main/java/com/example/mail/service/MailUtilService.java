package com.example.mail.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * メール送信ユーティリティクラス
 *
 */
@Service
@Transactional
public class MailUtilService {

	/**
	 * カンマ区切り文字を分割しListで返します
	 * @param addresses カンマつなぎの複数アドレス
	 * @return カンマ区切りで分割後アドレスリスト
	 */
	public List<String> splitWord(String addresses) {
		String[] words = addresses.split(",", 0);
		List<String> addressList = new ArrayList<String>();
		for(String word : words) {
			if(word != null) {
				addressList.add(word);
			}
		}
		return addressList;
	}
}