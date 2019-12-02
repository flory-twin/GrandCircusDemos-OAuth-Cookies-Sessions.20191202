package co.grandcircus.demoOAuth2.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import co.grandcircus.demoOAuth2.GithubService;

@Controller
public class IndexController {
	@Autowired
	HttpSession s;
	@Autowired
	GithubService gs;
	
	// Map "/" to index.jsp.
	//   Button in main handles bringing up GH screen. This then returns on /result.
	@RequestMapping("/")
	public ModelAndView displayIndex() 
	{
		s.setAttribute("gs", gs);
		return new ModelAndView("index");
	}
}
