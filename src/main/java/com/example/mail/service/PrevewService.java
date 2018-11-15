package com.example.mail.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mail.dao.PrevewDao;

@Service
public class PrevewService {

	@Autowired
	PrevewDao PrevewDao;
	
	/*
	 * ��M���[���v���r���[�f�[�^�擾�p���\�b�h
	 */
	public List<Map<String, Object>> getMailData(String mailId) {
		
		List<Map<String, Object>> list;
		
		list = PrevewDao.getMailData(mailId);
		
		return list;
	}
	
	/*
	 * ���M���[���v���r���[�f�[�^�擾�p���\�b�h
	 */
	public List<Map<String, Object>> getMailData(String mailId, int submitFlg) {
		
		List<Map<String, Object>> list;
		
		list = PrevewDao.getMailData(mailId, submitFlg);
		
		return list;
	}


}
