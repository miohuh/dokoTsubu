package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/*
 * ログアウトサーブレット
 */
@WebServlet("/Logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/*
	 * ログアウト処理
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ユーザー名のスコープの削除
		HttpSession session = request.getSession();
		session.removeAttribute("user");
		
		//トップ画面へフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/logout.jsp");
		dispatcher.forward(request,response);
	}

}
