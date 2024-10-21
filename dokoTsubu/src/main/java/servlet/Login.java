package servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.LoginLogic;
import model.User;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		User user = new User();
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		user.setName(name);
		user.setPass(pass);
		LoginLogic logic = new LoginLogic();
		
		//1234の時
//		boolean isLogin = logic.execute(user);	
		
		//【追加課題】ユーザー登録
		ServletContext application = getServletContext();
		Map<String,String> userMap = (Map<String,String>)application.getAttribute("userMap");
		if (userMap != null) {
			boolean isLogin = logic.checkLogin(userMap,name,pass);

			if (isLogin) {
				HttpSession session = request.getSession();
				session.setAttribute("user",user);
			}
			
		}else { 
			HttpSession session = request.getSession();
			session.setAttribute("user",null);
		}
		

		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/loginResult.jsp");
		dispatcher.forward(request, response);
	}

}
