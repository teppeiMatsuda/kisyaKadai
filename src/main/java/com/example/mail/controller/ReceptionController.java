package com.example.mail.controller;

import java.io.IOException;
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

/**
 * Handles requests for the application home page.
 */
@Controller
public class ReceptionController {
	
	@Autowired
	ReceptionService ReceptionService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/reception", method = { RequestMethod.GET, RequestMethod.POST })
	public String reception(Locale locale, Model model, HttpServletRequest request) {
		
		// login用フォーム値取得(ID)
		String loginId = request.getParameter("loginid");
		
		// login用フォーム値取得(password)
		String passWord = request.getParameter("password");

		// loginユーザID変数定義
		String userId = "1";
		
		List<Map<String, Object>> list = ReceptionService.getMailList(userId);

        model.addAttribute("data", list);
        model.addAttribute("title", list.get(0));
		
		return "reception";
	}
	
	/**
	 * Simply selects the home view to render by returning its name.
	 * @return 
	 * @throws IOException 
	 */
	@RequestMapping(value = "/update", method = { RequestMethod.GET, RequestMethod.POST })
	public String update(Locale locale, Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		
		String deleteflg = request.getParameter("deleteflg");
		String maildata[] = request.getParameterValues("maildata");
		String midoku = request.getParameter("midoku");
		model.addAttribute("midoku", midoku);
		model.addAttribute("deleteflg", deleteflg);
		model.addAttribute("maildata", maildata);
		
		return "confilm";
	}
}
