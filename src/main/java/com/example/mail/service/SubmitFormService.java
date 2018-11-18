package com.example.mail.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.mail.bean.SubmitMailBean;
import com.example.mail.dao.SubmitFormDao;

/**
 * メール送信が行われた際のビジネスロジック
 * @author t.matsuda
 *
 */
@Service
public class SubmitFormService {

	@Autowired SubmitFormDao submitFormDao;

	/**
	 * 入力されたメールの送信処理を行う</br>
	 * アドレスが登録済みであれば送信・アドレスが登録されていなければ、送信できなかった旨のメールを送信
	 * @param sb 入力されたメール情報
	 */
	@Transactional
	public void checkMail(SubmitMailBean sb) {
		List<String> addresses = splitAddress(sb.getAddress());

		for (String address : addresses) {
			if (submitFormDao.isExistAddress(address)) {
				// アドレスが存在する
				submitFormDao.registMail(sb);
				submitFormDao.registMailHist(sb,address);
			} else {
				// アドレスが存在しない
				submitFormDao.registErrorMail(sb,address);
				submitFormDao.registErrorMailHist(address);
			}
		}
	}

	/**
	 * カンマ区切り文字を分割しListで返します
	 * @param addresses カンマつなぎの複数アドレス
	 * @return カンマ区切りで分割後アドレスリスト
	 */
	public List<String> splitAddress(String addresses) {
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