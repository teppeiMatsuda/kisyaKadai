package com.example.mail;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		return "login";
	}
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/reception", method = RequestMethod.GET)
	public String reception(Locale locale, Model model, HttpServletRequest request) {
		
		String loginId = request.getParameter("loginid");
		
		List<Map<String, Object>> list = jdbcTemplate.queryForList("SELECT * FROM mail");

        model.addAttribute("data", list);
        model.addAttribute("title", list.get(0));
		
		return "reception";
	}
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/submit", method = RequestMethod.GET)
	public String submit(Locale locale, Model model) {
		
		return "submit";
	}
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/address", method = RequestMethod.GET)
	public String address(Locale locale, Model model) {
		
		return "address";
	}
	
}
