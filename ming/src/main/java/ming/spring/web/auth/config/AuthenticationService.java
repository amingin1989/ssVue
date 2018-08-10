package ming.spring.web.auth.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import ming.spring.web.bean.UserInfo;
import ming.spring.web.dao.UserDAO;

@Service
public class AuthenticationService implements UserDetailsService {

	@Autowired
	private UserDAO userDAO;

	@Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		List<UserInfo> userInfos = userDAO.getUserInfos(userId);
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

		if (!CollectionUtils.isEmpty(userInfos)) {
			for (UserInfo userInfo : userInfos) {
				GrantedAuthority authority = new SimpleGrantedAuthority(userInfo.getRole());
				authorities.add(authority);
			}
		}

		UserInfo userInfo = userInfos.get(0);
		UserDetails userDetails = (UserDetails) new User(userInfo.getUserName(), userInfo.getPassword(),
				userInfo.isEnabled(), true, true, true, authorities);

		return userDetails;
	}
}
