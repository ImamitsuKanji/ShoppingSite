package jp.co.aforce.tool;

import java.util.concurrent.ConcurrentHashMap;

public class LoginManager {
	private static final ConcurrentHashMap<String, String> loginUsers =
			new ConcurrentHashMap<>();
	
	public static boolean  isLoggedIn(String userId) {
		return loginUsers.containsKey(userId);
	}
	
	public static void login(String userId, String sessionId) {
		loginUsers.put(userId, sessionId);
	}
	
	public static void logout(String userId) {
		loginUsers.remove(userId);
	}

}
