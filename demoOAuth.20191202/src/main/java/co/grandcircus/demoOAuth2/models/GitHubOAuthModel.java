package co.grandcircus.demoOAuth2.models;

// Mine
public class GitHubOAuthModel {
	public static String url = "https://github.com/login/oauth/authorize";
	public static String clientId = "d9fd312167ec28f3c4a6";
	public static String redirectUri = "http://localhost:8081/result";
	private static String clientSecret = "536a9fc1afe1c65d6fcd9830e96ba9714e5bea6a";
	
	private String code;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	public String buildOAuthRequestOneUrl() {
		return url + "?client_id=" + clientId + "&redirect_uri=" + redirectUri;
	}
	
	public String buildOAuthRequestTwoUrl(String code) {
		return "";
	}
}
