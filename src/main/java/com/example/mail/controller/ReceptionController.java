package com.example.mail.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.mail.service.ReceptionService;
import com.example.mail.service.LoginService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class ReceptionController {
	
	@Autowired
	ReceptionService ReceptionService;
	@Autowired
	LoginService LoginService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping(value = "/reception", method = { RequestMethod.GET, RequestMethod.POST })
	public String reception(Locale locale, Model model, HttpServletRequest request) throws UnsupportedEncodingException {
		
		// ・文字コードの変換
		request.setCharacterEncoding("utf-8");
		
		// login用フォーム値取得(ID)
		String loginId = request.getParameter("loginid");
		
		// login用フォーム値取得(password)
		String passWord = request.getParameter("password");
		if(loginId.isEmpty() || passWord.isEmpty()) {
			model.addAttribute("data", "ログインIDもしくはパスワードを入力してください。");
			return "login";
		}
		List<Map<String, Object>> user = LoginService.getUser(loginId, passWord);
		if(user.size() == 0) {
			model.addAttribute("data", "ログインIDもしくはパスワードが間違っています。");
			return "login";
		}
		// loginユーザID変数定義
		String userId = "1";
		
		List<Map<String, Object>> list = ReceptionService.getMailList(userId);

		if(list != null) {
			if(list.size() > 0) {
				model.addAttribute("data", list);
				model.addAttribute("title", list.get(0));
			}
		}
		return "reception";
	}
	
	/**
	 * Simply selects the home view to render by returning its name.
	 * @return 
	 * @throws IOException 
	 */
	@RequestMapping(value = "/update", method = { RequestMethod.GET, RequestMethod.POST })
	public String update(Locale locale, Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		// loginユーザID変数定義
		String userId = "1";
		
		String deleteflg = request.getParameter("deleteflg");
		String midokuflg = request.getParameter("midokuflg");
		String maildata[] = request.getParameterValues("maildata");
		
		ReceptionService.updateMailList(userId, maildata, deleteflg, midokuflg);
		
		model.addAttribute("deleteflg", deleteflg);
		model.addAttribute("midokuflg", midokuflg);
		
		return "confilm";
	}
}
