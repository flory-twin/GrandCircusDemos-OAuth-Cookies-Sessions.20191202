package co.grandcircus.demoOAuth2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

//import co.grandcircus.demoOAuth2.GitHubService;

@Controller
public class MainController {

	/*
	// KDF TODO: B/c it's a Component, we can do this!
	@Autowired
	GitHubService gs;
	
	@RequestMapping("/")
	public ModelAndView directToMain() {
		return new ModelAndView("main");
	}
	
	@RequestMapping("/code")
	public ModelAndView handleGithubCodeCallback() {
		return new ModelAndView("main", "code", gs.getGithubAccessCode());
	}
	
	@RequestMapping("/result")
	public ModelAndView handleGithubCallback(@RequestParam String code) {
		// Step 1: Get code.
		System.out.println(code);
		
		// Step 2: Exchange code for access token
		String accessToken = gs.getGithubAccessToken(code);
		
		return new ModelAndView("github-results", "token", accessToken);
	}
	*/
	
	
}
