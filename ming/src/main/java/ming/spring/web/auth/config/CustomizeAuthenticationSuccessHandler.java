package ming.spring.web.auth.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class CustomizeAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
		UserDetails userInfos = (UserDetails) authentication.getPrincipal();

		JSONArray authoritys = new JSONArray();
		for (GrantedAuthority authority : userInfos.getAuthorities()) {
			authoritys.put(authority.getAuthority());
		}
		
		JSONObject func1 = new JSONObject();
		func1.put("func_name", "主檔管理");
		func1.put("func_data", 
				new JSONArray().put(
						new JSONObject().put("name", "人員管理").put("url", "/m0001")).put(
								new JSONObject().put("name", "adminPage2").put("url", "/m0002")));
		
		JSONObject func2 = new JSONObject();
		func2.put("func_name", "查詢類");
		func2.put("func_data", new JSONArray().put(
				new JSONObject().put("name", "sPage1").put("url", "/s0001")).put(
						new JSONObject().put("name", "sPage2").put("url", "/s0002")));
		
		JSONArray functions = new JSONArray();
		functions.put(func1);
		functions.put(func2);
		
		JSONObject obj = new JSONObject();
		obj.put("userName", userInfos.getName());
		obj.put("authoritys", authoritys);
		obj.put("isLogin", true);
		obj.put("functions", functions);

		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().write(obj.toString());

	}

}
