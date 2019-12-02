package co.grandcircus.demoOAuth2;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class GitHubServiceKevin {
	
	public static int port = 8080;
	// KDF addition; could also reasonably place in app props.
	public static String sessionCodeUrl = "https://github.com/login/oauth/authorize";
	public static String accessTokenUrl = "https://github.com/login/oauth/access_token";
	
	public static String clientId = "d9fd312167ec28f3c4a6";
	public static String redirectUri = "http://localhost:" + port + "/result";
	
	@Value("github.client_secret")
	private String clientSecret;
	private RestTemplate rt = new RestTemplate();
	
	public String getGithubAccessCode() {
		Map<String, String> requestParameters = new HashMap<>();
		requestParameters.put("client_id", clientId);
		requestParameters.put("redirect_uri", redirectUri);

			
			// KDF: Oooh, pretty. TODO: Pull out into methodology.
			Map<String, String> response = rt.postForObject(sessionCodeUrl, requestParameters, Map.class);
			
			// KDF: TODO Very nice--response properties are broken into Map.
			return response.get("code");

	}
	
	public String getGithubAccessToken(String authSessionCode) {
		Map<String, String> requestParameters = new HashMap<>();
		requestParameters.put("code", authSessionCode);
		requestParameters.put("client_id", clientId);
		requestParameters.put("client_secret", clientSecret);
		
		// KDF: Antonella is creating this rather than a bean to hold the response...
		Map<String, String> response; 
		
		// KDF: Oooh, pretty. TODO: Pull out into methodology.
		response = rt.postForObject(accessTokenUrl, requestParameters, Map.class);
		
		// KDF: TODO Very nice--response properties are broken into Map.
		return response.get("access_token");
	}
	
}
