package com.example.mail.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mail.dao.ReceptionDao;

@Service
public class ReceptionService {

	@Autowired
	ReceptionDao ReceptionDao;
	
	public List<Map<String, Object>> getMailList(String userId) {
		
		List<Map<String, Object>> list;
		
		list = ReceptionDao.getMailList(userId);
		
		return list;
	}

}
