package com.example.mail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.mail.service.AddressService;



/**
 * アドレス帳一覧コントローラクラスです
 */
@Controller
public class AddressController {

	@Autowired AddressService addressService;

//	@RequestMapping(value="/address")
//	public String getMethod(@ModelAttribute AddressDto dto){
//	  System.out.println("User Name : " + dto.getName());
//	  System.out.println("Email Address : " + dto.getAddress());
//	  return "address";
//	}

	@RequestMapping(value="/address")
	public String getMethod(Model model){
	  model.addAttribute("userName", "あいうえお");

	  return "address";
	}

}