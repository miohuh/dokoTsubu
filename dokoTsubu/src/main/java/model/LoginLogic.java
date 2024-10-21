package model;

/*
 * ログイン処理クラス
 */
public class LoginLogic {

	/*
	 * ユーザー名とパスワードのチェック
	 */
	public boolean checkLogin(User user) {
		UsersDAO dao = new UsersDAO(); 
		return dao.login(user.getName(),user.getPass());
	}
	
	/*
	 * ユーザー登録
	 */
	public boolean saveUser(User user) {
		UsersDAO dao = new UsersDAO(); 
		return dao.saveUser(user);
	}
	
	/*
	 * ユーザー名検索
	 */
	public boolean checkUser(User user) {
		UsersDAO dao = new UsersDAO(); 
		return dao.nameCheck(user);
	}
}
