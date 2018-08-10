package ming.spring.config;

import java.util.Date;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SessionListener implements HttpSessionListener {
 
    @Override
    public void sessionCreated(HttpSessionEvent event) {
    	//30分鐘 session timeout
    	event.getSession().setMaxInactiveInterval(5*60);
    	System.out.println("==== Session is created ====");
    	System.out.println(new Date());
    }
 
    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        System.out.println("==== Session is destroyed ====");
        System.out.println(new Date());
    }
}

