package com.example.mail;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.mail.service.AddressService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	@Autowired
    private JdbcTemplate jdbcTemplate;

	@Autowired
	private AddressService addressService;

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
	@RequestMapping(value = "/reception", method = { RequestMethod.GET, RequestMethod.POST })
	public String reception(Locale locale, Model model, HttpServletRequest request) {

		// login用フォーム値取得(ID)
		String loginId = request.getParameter("loginid");

		// login用フォーム値取得(password)
		String passWord = request.getParameter("password");

		// loginユーザID変数定義
		String userId = "1";

		// SQL用変数定義
		String mailSql = "";

		// SQL作成
		mailSql = "SELECT tf.to, tf.from, tf.mailid, tf.read_flg, m.title, m.main, m.recept_date ";
		mailSql += "FROM to_from tf ";
		mailSql += "LEFT JOIN mail m ON m.id = tf.mailid ";
		mailSql += "where tf.to = ?";

		List<Map<String, Object>> list = jdbcTemplate.queryForList(mailSql, userId);

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
		model.addAttribute("addressList",addressService.getAllAddress());
		return "address";
	}

}
