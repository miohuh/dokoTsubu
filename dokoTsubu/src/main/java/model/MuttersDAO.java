package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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

	public List<Mutter> findAll() {
		String sql = "select * from mutters;";
		
		List<Mutter> allMutterList = null;
		
		try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
	 			PreparedStatement st = con.prepareStatement(sql);) {

				/* 3) SQL文の実行 */
				ResultSet rs = st.executeQuery();

				/* 4) 結果をリストに移し替える */
				allMutterList = makeMuttersList(rs);

			} catch (Exception e) {
				System.out.println("DBアクセス時にエラーが発生しました。");
				e.printStackTrace();
			}
		return allMutterList;
	}
	
	public List<Mutter> makeMuttersList(ResultSet rs) throws Exception{
		List<Mutter> allMutterList = new ArrayList<>();
		
		while(rs.next()) {
			Mutter m = new Mutter(rs.getInt("id"),rs.getString("name"),rs.getString("text") );
			allMutterList.add(m);
		}
		return allMutterList;
	}
	
}
