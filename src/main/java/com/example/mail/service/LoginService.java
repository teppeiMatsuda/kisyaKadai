package com.example.mail.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mail.dao.LoginDao;

@Service
public class LoginService {

	@Autowired
	LoginDao LoginDao;
	
	public List<Map<String, Object>> getUser(String loginId, String passWord) {
		
		List<Map<String, Object>> list;
		
		list = LoginDao.getUser(loginId, passWord);
		
		return list;
	}

}
