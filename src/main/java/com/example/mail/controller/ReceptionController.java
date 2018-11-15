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
import javax.servlet.http.HttpSession;

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
	public String reception(Locale locale, Model model, HttpServletRequest request, HttpSession session) throws UnsupportedEncodingException {
		
		String loginId = "";
		// ・文字コードの変換
		request.setCharacterEncoding("utf-8");
		
//		int userId = 0;
//		// loginflg取得
//		String loginflg = request.getParameter("loginflg");
//		
//		if(!loginflg.isEmpty()) {
//			// login用フォーム値取得(ID)
//			loginId = request.getParameter("loginid");
//			session.setAttribute("loginId", loginId);
//			if(loginId.isEmpty()) {
//				loginId = (String)session.getAttribute("loginId");
//			}
//			// login用フォーム値取得(password)
//			String passWord = request.getParameter("password");
//			session.setAttribute("passWord", passWord);
//			if(passWord.isEmpty()) {
//				passWord = (String)session.getAttribute("passWord");
//			}
//			if(loginId.isEmpty() || passWord.isEmpty()) {
//				model.addAttribute("data", "ログインIDもしくはパスワードを入力してください。");
//				return "login";
//			}
//			List<Map<String, Object>> user = LoginService.getUser(loginId, passWord);
//			if(user.size() == 0) {
//				model.addAttribute("data", "ログインIDもしくはパスワードが間違っています。");
//				return "login";
//			}
//			// loginユーザID変数定義
//			userId = (Integer) user.get(0).get("id");
//		}
		
		int userId = 1;
		
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
