package servlet;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.GetMutterListLogic;
import model.Mutter;
import model.PostMutterLogic;
import model.User;
/*
 * メインサーブレット
 */
@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/*
	 * ログイン後の初期メイン画面
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		HttpSession session = request.getSession();
		//ログインしたユーザー情報の取得
		User user = (User)session.getAttribute("user");
		
		//つぶやき処理クラスのインスタンス
		GetMutterListLogic getMutterListLogic = new GetMutterListLogic();
		
		if (user != null) {
			//つぶやきリストの取得
			List<Mutter> mutterList = getMutterListLogic.execute(user);
			// リストの並び変え
			if (mutterList != null) {
				Collections.reverse(mutterList);
			}
			//リクエストスコープへ保存
			request.setAttribute("mutterList", mutterList);
			//フォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/main.jsp");
			dispatcher.forward(request, response);
		} else {
			//リダイレクト
			response.sendRedirect("index.jsp");
		}

	}
	/*
	 * つぶやき処理
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//ユーザー情報取得
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		//パラメータの取得
		String text = request.getParameter("text");
		
		String error = "";
		
		if(text != null && text.length() != 0) {
			Mutter mutter = new Mutter();
			mutter.setText(text);
			mutter.setUserName(user.getName());
			//処理クラスインスタンス作成
			PostMutterLogic postMutterLogic = new PostMutterLogic();
			//登録処理
			boolean result = postMutterLogic.execute(mutter);

			if (!result) {
				error += "エラー発生";
			}
		} else {
			 error += "つぶやきが入力されていません";
		}
		//つぶやきリスト取得処理クラスインスタンス
		GetMutterListLogic getMutterListLogic = new GetMutterListLogic();
		//つぶやきリストの取得
		List<Mutter> mutterList = getMutterListLogic.execute(user);
		// リストの並び変え
		if (mutterList != null) {
			Collections.reverse(mutterList);
		}
		//リクエストスコープへ保存
		request.setAttribute("mutterList", mutterList);
		//エラーメッセージ
		request.setAttribute("error",error);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/main.jsp");
		dispatcher.forward(request, response);
	}

}
