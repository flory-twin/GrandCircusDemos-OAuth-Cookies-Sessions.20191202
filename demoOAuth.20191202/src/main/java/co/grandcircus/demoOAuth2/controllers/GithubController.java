package co.grandcircus.demoOAuth2.controllers;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import co.grandcircus.demoOAuth2.GithubService;

/*
 * Frankencontroller, combined mine and Antonella's.
 */
@Controller
public class GithubController {

	@Autowired
	GithubService gs;
	@Autowired
	HttpSession s;
	
	// Wraps REST call to GH to get auth token.
	//  Will be initially invoked by users navigating to the GitHub auth fetch URL (available as getGithubAccessRequestUrl()).
	//  This will cause GH to call us back on URL ...
	//  Relevant button lies in index.jsp.
	@RequestMapping("/result")
	public ModelAndView handleGithubCallback(String code) {
		// If this is the first time we're hitting the page, inject the GitHub service.
		if (s.getAttribute("gs") == null) {
			s.setAttribute("gs", gs);
		}
		
		
		// Use code to get token from GH. This method hides a REST transaction.
		String token = gs.getGithubAccessToken(code);

		return new ModelAndView("github-auth-token");
	}
	
	// Wraps REST call to GH to get user.
	@RequestMapping("/get-user")
	public ModelAndView getUser() {
		return new ModelAndView("main", "user", gs.getGithubUser());
	}
	
	
}
