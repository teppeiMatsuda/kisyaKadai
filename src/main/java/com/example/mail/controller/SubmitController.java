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

import com.example.mail.service.SubmitService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class SubmitController {

	@Autowired
	SubmitService SubmitService;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/submitList", method = { RequestMethod.GET, RequestMethod.POST })
	public String submitList(Locale locale, Model model, HttpServletRequest request) {

		String userId = "jojo";

		List<Map<String, Object>> list = SubmitService.getMailList(userId);

		if(list != null) {
			if(list.size() > 0) {
				model.addAttribute("data", list);
				model.addAttribute("title", list.get(0));
			}
		}
		return "submit";
	}

	/**
	 * Simply selects the home view to render by returning its name.
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/submitUpdate", method = { RequestMethod.GET, RequestMethod.POST })
	public String update(Locale locale, Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {

		String userId = "jojo";

		String deleteflg = request.getParameter("deleteflg");
		String maildata[] = request.getParameterValues("maildata");

		SubmitService.updateMailList(userId, maildata, deleteflg);

		model.addAttribute("deleteflg", deleteflg);

		return "confilm";
	}

}
