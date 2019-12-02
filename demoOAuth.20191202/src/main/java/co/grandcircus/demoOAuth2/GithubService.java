package co.grandcircus.demoOAuth2;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/*
 * Frankenservice, combines mine and Antonella's
 */
@Component // this helps us use Spring's Dependency Injection
public class GithubService {
	
	@Value("${github.client_secret}")
	String clientSecret;
	public static final String clientId = "d9fd312167ec28f3c4a6";
	public static final String redirectUri = "http://localhost:8080/result";
	
	public static final String getAccessCodeUrl = "https://github.com/login/oauth/authorize";
	public static final String getUserBaseUrl = "https://api.github.com/user";
	public String getClientId() {
		return clientId;
	}

	public GitHubUser getUser() {
		return user;
	}

	String code;
	String token;
	GitHubUser user;
	
	RestTemplate rt = new RestTemplate();
	
	public String getGithubAccessRequestUrl() {
		return getAccessCodeUrl + "?client_id=" +
				clientId + "&redirect_uri=" + redirectUri;
	}
	
	public String getGithubAccessToken(String code) {
		
		this.code = code;
		
		Map<String, String> params = new HashMap<>();
		
		params.put("code", code);
		params.put("client_id", clientId);
		params.put("client_secret", clientSecret);
		
		Map<String, String> response = rt.postForObject("https://github.com/login/oauth/access_token", params, Map.class);
		
		token = response.get("access_token");
		return token;
	}
	
	public GitHubUser getGithubUser() {
		GitHubUser ghu = rt.getForObject(getUserBaseUrl + "?access_token=" + token, 
				GitHubUser.class);
		this.user = ghu;
		
		return ghu;
	}	

	public String getClientSecret() {
		return clientSecret;
	}

	public String getCode() {
		return code;
	}

	public String getToken() {
		return token;
	}

}
