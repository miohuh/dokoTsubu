package model;

import java.util.List;
/*
 * つぶやきリスト処理クラス
 */
public class GetMutterListLogic {

	public List<Mutter> execute(User user) {
		MuttersDAO dao = new MuttersDAO();
		List<Mutter> allMutterList = dao.findAll(user);
		
		return allMutterList;
	}
}
