package ming.spring.web.enums;

import java.util.List;

import org.springframework.util.CollectionUtils;

public enum Role {

	ADMIN("ROLE_ADMIN"), USER("ROLE_USER");

	private String role;
	
	private Role(String role) {
		this.role = role;
	}


	public String getRole() {
		return this.role;
	}
	
	public static boolean isAdmin(List<String> authorityList) {
		if(CollectionUtils.isEmpty(authorityList)) return false;
		if(authorityList.contains(ADMIN.getRole())) return true;
		return false;
	}
	
	public static boolean isUser(List<String> authorityList) {
		if(CollectionUtils.isEmpty(authorityList)) return false;
		if(authorityList.contains(USER.getRole())) return true;
		return false;
	}
}
