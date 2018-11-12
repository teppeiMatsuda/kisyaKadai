package com.example.mail.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * ���[�����M���[�e�B���e�B�N���X
 *
 */
@Service
@Transactional
public class MailUtilService {

	/**
	 * �J���}��؂蕶���𕪊���List�ŕԂ��܂�
	 * @param addresses �J���}�Ȃ��̕����A�h���X
	 * @return �J���}��؂�ŕ�����A�h���X���X�g
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