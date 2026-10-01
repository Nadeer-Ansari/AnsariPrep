package example.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class GreetingServlet
 */
@WebServlet(name = "myGreetingServlet", urlPatterns = {"/doGreet"})
public class GreetingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// This method gets called when the servlet is requested.
		//Therefore, this method is used to provide logic for the servlet
		System.out.println("Inside doGet()");
		String responseText = 
		"<h1 style='color:red'>Welcome to Servlets</h1>";
		
		String contentType = "text/html"; //MIME (Multipurpose Internet Mail Extension)
		response.setContentType(contentType);
		
		PrintWriter out = response.getWriter();
		out.println(responseText);
	}
	
	@Override
	public void init() {
		System.out.println("Inside init()");
	}
	
	@Override
	public void destroy() {
		System.out.println("Inside destroy()");
	}

}






