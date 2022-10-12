package kr.co.sppartners.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	/**
	 * @throws Exception
	 * 
	 * 메인화면 
	 */
	@RequestMapping(value="/")
	public String mainView() throws Exception {
		return "main";
	}
	
}
