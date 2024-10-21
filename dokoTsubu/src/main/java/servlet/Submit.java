package servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.LoginLogic;

@WebServlet("/Submit")
public class Submit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/submit.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		
		if(name.length() == 0 || pass.length() == 0) {
			String submit = "ユーザー名、パスワードは必須項目です";
			request.setAttribute("submit", submit);
		}else {
			LoginLogic logic = new LoginLogic();
			ServletContext application = getServletContext();
			Map<String,String> userMap = (Map<String,String>) application.getAttribute("userMap");

			if(userMap == null) {
				userMap = new HashMap<>();
				String submit = logic.saveUser(userMap, name, pass);
				request.setAttribute("submit",submit);
			}else {
				String submit = logic.checkUser(userMap,name,pass);
				request.setAttribute("submit",submit);
			}

			application.setAttribute("userMap",userMap);
			
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/submit.jsp");
		dispatcher.forward(request, response);
	}

}
