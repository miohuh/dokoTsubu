package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/*
 * ユーザーテーブルへ接続DAOクラス
 */
public class UsersDAO {

	private final String URL = "jdbc:postgresql://localhost:5432/dokotsubu";
	private final String USER = "postgres";
	private final String PASSWORD = "test";

	// コンストラクタ
	public UsersDAO() {
		/* JDBCドライバの準備 */
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * ログイン検索
	 */
	public boolean login(String id,String pass) {
		String sql = "SELECT * FROM users WHERE id = ? AND pass = ?;";

		try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement st = con.prepareStatement(sql);) {
			
			st.setString(1,id);
			st.setString(2,pass);
			ResultSet rs = st.executeQuery();
			
			if(rs.next()) {
				return true;
			} else {
				return false;
			}
			
		}catch(Exception e) {
			System.out.println("データベース接続時にエラー発生しました");
			e.printStackTrace();
			return false;
		}
	}
	
	/*
	 * 同じIDが登録されているか検索
	 */
	public boolean nameCheck(User user) {
		String sql = "SELECT * FROM users WHERE id = ?;";

		try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement st = con.prepareStatement(sql);) {
			
			st.setString(1,user.getName());
			ResultSet rs = st.executeQuery();
			
			if(rs.next()) {
				return false;
			} else {
				return true;
			}
			
		}catch(Exception e) {
			System.out.println("データベース接続時にエラー発生しました");
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean saveUser(User user) {
		String sql = "INSERT INTO users(id,pass) VALUES (?,?);";
		
		try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement st = con.prepareStatement(sql);) {
			
			st.setString(1, user.getName());
			st.setString(2, user.getPass());
			
			int update = st.executeUpdate();
			
			if (update != 1) {
				return false;
			}
			return true;
			
		} catch (Exception e) {
			System.out.println("データベース接続時にエラー発生しました");
			e.printStackTrace();
			return false;
		}
	}
	
}
