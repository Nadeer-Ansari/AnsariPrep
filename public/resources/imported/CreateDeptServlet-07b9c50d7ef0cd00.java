package example.servlet;

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
 * Servlet implementation class CreateDeptServlet
 */
@WebServlet("/createDept")
public class CreateDeptServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		//Capturing Department data values sent by client
		String deptNo = request.getParameter("deptNo");
		String deptName = request.getParameter("deptName");
		String deptLoc = request.getParameter("deptLoc");
		//Building an object of Department class based upon these values
		int departmentNo = Integer.parseInt(deptNo);
		Department currentDept = 
				new Department(departmentNo, deptName, deptLoc);
		//Sending a Department class object to DepartmentDao's create method for record insertion
		DaoInterface<Department, Integer> daoRef =
				new DepartmentDao();
		daoRef.create(currentDept);
		out.println("<h1>Department created successfully</h1>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
