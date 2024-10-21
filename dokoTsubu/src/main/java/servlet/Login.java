package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.LoginLogic;
import model.User;
/*
 * ログインサーブレット
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/*
	 * ログイン処理
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		//入力されたパラメータの取得
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		User user = new User(name,pass);
		
		//処理クラスインスタンスの作成
		LoginLogic logic = new LoginLogic();
		
		if (name != null && pass != null) {
			//データベースへ検索
			boolean isLogin = logic.checkLogin(user);
			if (!isLogin) {
				user = null;
			} 
		} else { 
			user = null;
		}

		session.setAttribute("user",user);
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/loginResult.jsp");
		dispatcher.forward(request, response);
	}

}
