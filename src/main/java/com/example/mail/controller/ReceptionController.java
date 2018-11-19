package com.example.mail.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.mail.service.LoginService;
import com.example.mail.service.ReceptionService;

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
		// �E�����R�[�h�̕ϊ�
		request.setCharacterEncoding("utf-8");

//		int userId = 0;
//		// loginflg�擾
//		String loginflg = request.getParameter("loginflg");
//
//		if(!loginflg.isEmpty()) {
//			// login�p�t�H�[���l�擾(ID)
//			loginId = request.getParameter("loginid");
//			session.setAttribute("loginId", loginId);
//			if(loginId.isEmpty()) {
//				loginId = (String)session.getAttribute("loginId");
//			}
//			// login�p�t�H�[���l�擾(password)
//			String passWord = request.getParameter("password");
//			session.setAttribute("passWord", passWord);
//			if(passWord.isEmpty()) {
//				passWord = (String)session.getAttribute("passWord");
//			}
//			if(loginId.isEmpty() || passWord.isEmpty()) {
//				model.addAttribute("data", "���O�C��ID�������̓p�X���[�h����͂��Ă��������B");
//				return "login";
//			}
//			List<Map<String, Object>> user = LoginService.getUser(loginId, passWord);
//			if(user.size() == 0) {
//				model.addAttribute("data", "���O�C��ID�������̓p�X���[�h���Ԉ���Ă��܂��B");
//				return "login";
//			}
//			// login���[�UID�ϐ���`
//			userId = (Integer) user.get(0).get("id");
//		}

		String userId = "jojo";

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

		// login���[�UID�ϐ���`
		String userId = "jojo";

		String deleteflg = request.getParameter("deleteflg");
		String midokuflg = request.getParameter("midokuflg");
		String maildata[] = request.getParameterValues("maildata");

		ReceptionService.updateMailList(userId, maildata, deleteflg, midokuflg);

		model.addAttribute("deleteflg", deleteflg);
		model.addAttribute("midokuflg", midokuflg);

		return "confilm";
	}
}
