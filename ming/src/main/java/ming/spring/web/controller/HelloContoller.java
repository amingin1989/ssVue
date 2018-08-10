package ming.spring.web.controller;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	@RequestMapping(value = "/functions", method = RequestMethod.GET)
	public @ResponseBody String getFunctions() {
		JSONArray results = new JSONArray();
		JSONObject manageB = new JSONObject();
		JSONArray manageM = new JSONArray();
		JSONObject manageS1 = new JSONObject();
		manageS1.put("name", "adminPage1");
		manageS1.put("url", "admin");
		
		JSONObject manageS2 = new JSONObject();
		manageS2.put("name", "adminPage2");
		manageS2.put("url", "admin");
		manageM.put(manageS1);
		manageM.put(manageS2);
		
		manageB.put("func_name", "主檔管理");
		manageB.put("func_data", manageM);
		
		results.put(manageB);
		
		JSONObject searchB = new JSONObject();
		JSONArray searchM = new JSONArray();
		JSONObject sr1 = new JSONObject();
		sr1.put("name", "srPage1");
		sr1.put("url", "user");
		JSONObject sr2 = new JSONObject();
		sr2.put("name", "srPage2");
		sr2.put("url", "user");
		searchM.put(sr1);
		searchM.put(sr2);
		
		searchB.put("func_name", "查詢類");
		searchB.put("func_data", searchM);
		results.put(searchB);
		
		JSONObject operationB = new JSONObject();
		operationB.put("func_name", "操作類");
		operationB.put("func_data", new JSONObject());
		results.put(operationB);
		
		return results.toString();
	}
}
