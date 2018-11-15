package com.example.mail.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mail.dao.SubmitDao;

@Service
public class SubmitService {

	@Autowired
	SubmitDao SubmitDao;
	
	public List<Map<String, Object>> getMailList(String userId) {
		
		List<Map<String, Object>> list;
		
		list = SubmitDao.getMailList(userId);
		
		return list;
	}

	public boolean updateMailList(String userId, String maildata[], String deleteflg) {
		
		SubmitDao.updateMailList(userId, maildata, deleteflg);
		
		return true;
	}

}
