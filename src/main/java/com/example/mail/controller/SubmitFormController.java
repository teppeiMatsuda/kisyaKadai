package com.example.mail.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.mail.bean.SubmitMailBean;
import com.example.mail.service.SubmitFormService;

@Controller
public class SubmitFormController {

	@Autowired SubmitFormService submitFormService;

	@RequestMapping(value = "/submitForm", method = RequestMethod.GET)
	public String submitForm(Locale locale, Model model) {
		SubmitMailBean sb = new SubmitMailBean();
		model.addAttribute("submitMailBean", sb);
		return "submitForm";
	}

	@RequestMapping(value = "/submitForm", method = RequestMethod.POST)
	public String submitForm(@ModelAttribute SubmitMailBean sb, Model model, BindingResult result) {
		// 入力されたメールの送信・履歴の作成を行う
		submitFormService.checkMail(sb);

		return "redirect:submitList";

	}

}