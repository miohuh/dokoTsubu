package model;
/*
 * つぶやき登録処理クラス
 */
public class PostMutterLogic {

	/*
	 * 登録処理
	 */
	public boolean execute(Mutter mutter) {
		MuttersDAO dao = new MuttersDAO();
		return dao.create(mutter);
	}
}
