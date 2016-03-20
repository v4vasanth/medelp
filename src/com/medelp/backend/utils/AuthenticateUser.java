package com.medelp.backend.utils;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

import com.google.appengine.api.oauth.OAuthRequestException;
import com.google.appengine.api.oauth.OAuthService;
import com.google.appengine.api.oauth.OAuthServiceFactory;
import com.google.appengine.api.oauth.OAuthServiceFailureException;
import com.google.appengine.api.users.User;
import com.medelp.backend.Constants;

public class AuthenticateUser {
	
	private static final Logger log = Logger.getLogger(AuthenticateUser.class.getName());

	OAuthService oauth = OAuthServiceFactory.getOAuthService();
	String scope = "https://www.googleapis.com/auth/userinfo.email";
	Set<String> allowedClients = new HashSet<>();
	
	private static AuthenticateUser authUser = new AuthenticateUser();
	
	
	public static AuthenticateUser getInstance() {
		return authUser;
	}

	private AuthenticateUser() {
		allowedClients.add(Constants.ANDROID_CLIENT_ID);
		allowedClients.add(Constants.IOS_CLIENT_ID);
		allowedClients.add(Constants.API_EXPLORER_CLIENT_ID);
		allowedClients.add(Constants.WEB_CLIENT_ID);
		allowedClients.add(Constants.ANDROID_WEB_CLIENT_ID);
		allowedClients.add(Constants.ANDROID_AUDIENCE_ID);
	}

	public User authenticate() throws OAuthRequestException, OAuthServiceFailureException {
		User user = oauth.getCurrentUser(scope);
		log.info("user: " + user);
		if (user == null) {
			throw new OAuthRequestException("Authorization required");
		}
		String tokenAudience = oauth.getClientId(scope);
		log.info("audience: " + tokenAudience);
		for (String ac : allowedClients) {
			log.info("allowedClient: " + ac);
		}
		if (!allowedClients.contains(tokenAudience)) {
			throw new OAuthRequestException(
					"audience of token '" + tokenAudience + "' is not in allowed list " + allowedClients);
		}
		return user;
	}

}
