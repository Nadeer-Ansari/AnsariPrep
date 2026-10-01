package example.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import example.jdbc.DaoInterface;
import example.jdbc.Department;
import example.jdbc.DepartmentDao;

/**
 * Servlet implementation class SearchDeptServlet
 */
@WebServlet("/searchDept")
public class SearchDeptServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String deptNo = request.getParameter("deptNo");
		int departmentNo = Integer.parseInt(deptNo);
		
		DaoInterface<Department, Integer> daoRef =
				new DepartmentDao();
		
		Department foundDept = daoRef.retrieveById(departmentNo);
		RequestDispatcher dispatcher = null;
		if(foundDept != null){
			//Available
			dispatcher = 
					request.getRequestDispatcher("showDept");
			request.setAttribute("found_dept", foundDept);
			dispatcher.forward(request, response);
		}
		else {
			//Not Available
			dispatcher = 
			request.getRequestDispatcher("searchDepartment.html");
			out.println("<h1>Department with the given ID does not exist, please try again.</h1>");
			dispatcher.include(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
