package co.grandcircus.demoOAuth2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GitHubUser {



		private String name;
		private Long id;
		private String email;
		@JsonProperty("avatar_url")
		private String avatarUrl;
		private String login;

		public GitHubUser() {
			super();
			// TODO Auto-generated constructor stub
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getAvatarUrl() {
			return avatarUrl;
		}

		public void setAvatarUrl(String avatarUrl) {
			this.avatarUrl = avatarUrl;
		}

		public String getLogin() {
			return login;
		}

		public void setLogin(String login) {
			this.login = login;
		}

		@Override
		public String toString() {
			return "GithubUser [name=" + name + ", id=" + id + ", email=" + email + ", avatarUrl=" + avatarUrl + ", login="
					+ login + "]";
		}

}
