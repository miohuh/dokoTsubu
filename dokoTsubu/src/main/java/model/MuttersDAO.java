package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/*
 * muttersテーブル(つぶやき)接続DAOクラス
 */
public class MuttersDAO {

	private final String URL = "jdbc:postgresql://localhost:5432/dokoTsubu";
	private final String USER = "postgres";
	private final String PASSWORD = "test";

	// コンストラクタ
	public MuttersDAO() {
		/* JDBCドライバの準備 */
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * つぶやき登録
	 */
	public boolean create(Mutter m) {
		String sql = "insert into mutters(name,text) values (?,?);";
		try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement st = con.prepareStatement(sql);) {

				st.setString(1,m.getUserName());
				st.setString(2,m.getText());

				int result = st.executeUpdate();

				if(result != 1) {
					return false;
				}
			} catch (Exception e) {
				System.out.println("DBアクセス時にエラーが発生しました。");
				e.printStackTrace();
				return false;
			}
		return true;
	}

	/*
	 * つぶやきリストの作成
	 */
	public List<Mutter> findAll(User user) {
		String sql = "select * from mutters;";
		
		List<Mutter> allMutterList = null;
		
		try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
	 			PreparedStatement st = con.prepareStatement(sql);) {

				ResultSet rs = st.executeQuery();
				allMutterList = makeMuttersList(rs);

			} catch (Exception e) {
				System.out.println("DBアクセス時にエラーが発生しました。");
				e.printStackTrace();
			}
		return allMutterList;
	}
	
	/*
	 * SQLの検索結果からListの作成
	 */
	public List<Mutter> makeMuttersList(ResultSet rs) throws Exception{
		List<Mutter> allMutterList = new ArrayList<>();
		
		while(rs.next()) {
			Mutter m = new Mutter(rs.getInt("id"),rs.getString("name"),rs.getString("text") );
			allMutterList.add(m);
		}
		return allMutterList;
	}
	
}
