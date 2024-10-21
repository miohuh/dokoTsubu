package model;

import java.util.Map;

public class LoginLogic {

	public boolean execute(User user) {
		if (user.getPass().equals("1234")) {
			return true;
		}
		return false;
	}
	
	public boolean checkLogin(Map<String,String> userMap,String name,String pass) {
		if (userMap.get(name).equals(pass)) {
			return true;
		}else {
			return false;
		}
	}
	
	public String saveUser(Map<String, String> user,String name,String pass) {
		user.put(name, pass);
		String save = "登録完了しました";
		return save;
	}
	
	
	public String checkUser(Map<String, String> user,String name,String pass) {
		String error = "";
		if(user.containsKey(name)) {
			return error = "そのユーザーは既に登録されています";
		}else {
			return saveUser(user,name,pass);
		}
	}
}
