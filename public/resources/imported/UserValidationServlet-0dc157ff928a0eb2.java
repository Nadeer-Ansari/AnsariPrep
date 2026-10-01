package example.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import example.bean.User;
import example.bean.UserValidator;

/**
 * Servlet implementation class UserValidationServlet
 */
@WebServlet("/doValidate")
public class UserValidationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String successResponse = 
		"<h1 style='color:green'>Hey, welcome to our website</h1>";
		String failureResponse = 
		"<h1 style='color:red'>Oh, sorry, access denied due to invalid credentials</h1>";
		
		String userId = request.getParameter("uid");
		String userPwd = request.getParameter("pwd");
		
		User userObj = new User(userId, userPwd);
		boolean valid = UserValidator.isValid(userObj);
		if(valid)
			out.println(successResponse);
		else
			out.println(failureResponse);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
