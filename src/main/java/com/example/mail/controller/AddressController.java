package com.example.mail.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.mail.service.AddressService;

/**
 * アドレス帳一覧コントローラクラスです
 * @author t.matsuda
 */
@Controller
public class AddressController {

	@Autowired AddressService addressService;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/address", method = RequestMethod.GET)
	public String address(Locale locale, Model model) {
		model.addAttribute("addressList",addressService.getAllAddress());
		return "address";
	}

}