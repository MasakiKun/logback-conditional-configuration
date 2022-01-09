package kr.ayukawa.logbackexample.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@GetMapping(value="/Home")
	@ResponseBody
	public String home() {
		logger.info("/Home req");
		return "OK";
	}
}
