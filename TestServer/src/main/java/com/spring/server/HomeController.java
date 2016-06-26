package com.spring.server;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	/*@RequestMapping(value="/{name}", method=RequestMethod.GET)
	public String userName(@PathVariable String name, HttpServletRequest request, HttpSession session)
	{
		logger.info("Username is {}.",name);
		request.setAttribute("username", name);
		return "user";
	}*/
	
	@RequestMapping(value="/json", method = RequestMethod.GET)
	@ResponseBody
	public HashMap<String, Object> json()
	{
		HashMap<String, Object> hsm = new HashMap<String, Object>();
		
		hsm.put("user_id", "dhkim");
		hsm.put("user_pw", "usm");
		hsm.put("user_name", "kimdonghyun");
		
		return hsm;
	}
	
}
