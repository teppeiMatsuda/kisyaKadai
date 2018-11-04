package com.example.mail;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class PrevewController {
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/prevew", method = RequestMethod.GET)
	public String Prevew(Locale locale, Model model, HttpServletRequest request) {
		
		String mailid = request.getParameter("id");
		
		List<Map<String, Object>> maildata = jdbcTemplate.queryForList("SELECT * FROM mail WHERE id = ?", mailid);

        model.addAttribute("title", maildata.get(0));
		
		return "prevew";
	}
}
