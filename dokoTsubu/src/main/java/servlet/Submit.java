package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.LoginLogic;
import model.User;
/*
 * ユーザー登録サーブレット
 */
@WebServlet("/Submit")
public class Submit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/submit.jsp");
		dispatcher.forward(request, response);
	}

	/*
	 * ユーザー登録処理
	 * submit.jspのformから
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//formの戻り値の取得
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		User user = new User(name,pass);
		//処理クラスインスタンス生成
		LoginLogic logic = new LoginLogic();
		
		String submit = "";
		
		//未入力チェック
		if(name.length() == 0 || pass.length() == 0) {
			submit = "ユーザー名、パスワードは必須項目です";
		}else {
			//登録済確認
			boolean checkSubmit = logic.checkUser(user);
			if (checkSubmit) {
				boolean saveSubmit = logic.saveUser(user);
				if(!saveSubmit) {
					submit = "登録できませんでした";
				}else {
					submit += "登録完了";
				}
			}else {
				submit = "既に登録済みのユーザーです";
			}
		}
		request.setAttribute("submit", submit);
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/submit.jsp");
		dispatcher.forward(request, response);
	}

}
