package jp.co.aforce.tool;

import java.util.concurrent.ConcurrentHashMap;

public class LoginManager {
	private static final ConcurrentHashMap<String, String> loginUsers =
			new ConcurrentHashMap<>();
	
	public static boolean  isLoggedIn(String id) {
		return loginUsers.containsKey(id);
	}
	
	public static void login(String id, String sessionId) {
		loginUsers.put(id, sessionId);
	}
	
	public static void logout(String id) {
		loginUsers.remove(id);
	}

}
