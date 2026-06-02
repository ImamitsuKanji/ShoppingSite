package jp.co.aforce.tool;

import jp.co.aforce.beans.User;

public class Check {
	
	public static boolean IDcheck(String id) {
		return id.matches("\\d+");
	}
	
	public static String loginCheckResult(String id, User user, String userId) {		
		
		if(!IDcheck(id)) {
			return "IDが間違っています。ID番号を入力してください";
		}
		
		if (user == null) {
			return "IDもしくはパスワードが違います。";
		} 
		
		if(LoginManager.isLoggedIn(userId)) {
			return "このアカウントは既にログイン中です";
		}
		return null;
		
	}
	
	public static String logoutCheckResult(User user) {
		
		if(user == null) {
			return "このアカウントは既にログアウトされています";
		}
		
		return null;
	}
	
	public static String isSqlDirty(int line) {
		

		if(line>0) {
			return null;
		}
		
		return "失敗しました";
	}
}
