package co.grandcircus.demoOAuth2.controllers;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SessionCookieController {

	@Autowired
	HttpSession session;
	@Autowired
	HttpServletResponse response;
		
	@RequestMapping("/count-test")
	public ModelAndView sessionTest() {
		String sessionId = session.getId();
		
		// If no client has ever visited, set the visit count in the session.
		if (session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
		}
		
		// Increment session count.
		int newCount = ((int) session.getAttribute("count")) + 1;
		session.setAttribute("count", newCount);
		
		return new ModelAndView("session-demo", "sessionId", sessionId);
	}
	
	@RequestMapping("/cookie-test")
	public ModelAndView cookieTest() {
		// We can delete all session details using session.invalidate().
		
		Cookie cookie = new Cookie("october19cookie", "antonella@grandcircus.co"); //Initial KVP name, KVP value
		// Avoid dashes in Cookie KVP names!! And use javax Cookie, not Spring Cookie.
		
		response.addCookie(cookie);
		// Not really interested in seeing the cookie values...
		return new ModelAndView("cookie-demo");
	}
}
