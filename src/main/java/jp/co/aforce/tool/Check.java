package jp.co.aforce.tool;

import jp.co.aforce.beans.User;

public class Check {
	//ログイン
	public static boolean IDcheck(String id) {
		return id.matches("\\d+");
	}
	
	public static String loginCheckResult(String id, User user) {		
		if(!IDcheck(id)) {
			return "IDが間違っています。ID番号を入力してください";
		}
		
		if (user == null) {
			return "IDもしくはパスワードが違います。";
		} 
		
		if(LoginManager.isLoggedIn(id)) {
			return "このアカウントは既にログイン中です";
		}
		System.out.println("ok");
		return null;
	}
	
	
	
	//実行確認
	public static String isSqlDirty(int line) {
		if(line ==0) {
			return "失敗しました";
		}
		System.out.println("ok");
		
		return  null;
	}
	
	//削除
	public static String UserCheck(User user) {
		if(user == null) {
			return "そのIDは存在しません";
		}
		return null;
	}
	
	//ログアウト
	public static String logoutCheckResult(User user) {
		if(user == null) {
			return "このアカウントは既にログアウトされています";
		}
		System.out.println("ok");
		
		return null;
	}
}
