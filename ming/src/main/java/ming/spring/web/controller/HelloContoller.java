package ming.spring.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloContoller {

	@RequestMapping(value = "/")
	public String index() {
		return "index";
	}

	//HTML名稱似乎不能和@RequestMapping的名稱大小寫相同
	@RequestMapping(value = "/user")
	public String user() {
		return "USER";
	}

	@RequestMapping(value = "/admin")
	public String admin() {
		return "ADMIN";
	}

	@RequestMapping(value = "/main")
	public String home() {
		return "Main";
	}
	@RequestMapping(value = "/fail")
	public String Error403() {
		return "error";
	}
	
}
