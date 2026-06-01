package jp.co.aforce.tool;

import jp.co.aforce.beans.User;

public class Check {
	
	public static boolean IDcheck(String id) {
		return id.matches("\\d+");
	}
	
	public static String showCheckResult(String id, User user) {		
		String message = null;
		
		if(!IDcheck(id)) {
			message= "IDが間違っています。ID番号を入力してください";
			return message;
		}
		
		if (user == null) {
			message= "IDもしくはパスワードが違います。";
			return message;
		} 
		
		if(LoginManager.isLoggedIn(id)) {
			message= "このアカウントは既にログイン中です";
			return message;
		}
		return message;
		
	}
	
	
}
