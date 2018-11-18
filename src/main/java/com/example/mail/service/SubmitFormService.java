package com.example.mail.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.mail.bean.SubmitMailBean;
import com.example.mail.dao.SubmitFormDao;

/**
 * ���[�����M���s��ꂽ�ۂ̃r�W�l�X���W�b�N
 * @author t.matsuda
 *
 */
@Service
public class SubmitFormService {

	@Autowired SubmitFormDao submitFormDao;

	/**
	 * ���͂��ꂽ���[���̑��M�������s��</br>
	 * �A�h���X���o�^�ς݂ł���Α��M�E�A�h���X���o�^����Ă��Ȃ���΁A���M�ł��Ȃ������|�̃��[���𑗐M
	 * @param sb ���͂��ꂽ���[�����
	 */
	@Transactional
	public void checkMail(SubmitMailBean sb) {
		List<String> addresses = splitAddress(sb.getAddress());

		for (String address : addresses) {
			if (submitFormDao.isExistAddress(address)) {
				// �A�h���X�����݂���
				submitFormDao.registMail(sb);
				submitFormDao.registMailHist(sb,address);
			} else {
				// �A�h���X�����݂��Ȃ�
				submitFormDao.registErrorMail(sb,address);
				submitFormDao.registErrorMailHist(address);
			}
		}
	}

	/**
	 * �J���}��؂蕶���𕪊���List�ŕԂ��܂�
	 * @param addresses �J���}�Ȃ��̕����A�h���X
	 * @return �J���}��؂�ŕ�����A�h���X���X�g
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