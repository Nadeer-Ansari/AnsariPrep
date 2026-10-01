package example.jdbc;

public class CreateNewDepartmentMain {

	public static void main(String[] args) {
		DaoInterface<Department, Integer> daoRef = 
				new DepartmentDao();
		
		Department dept = new Department(60, "Finance", "Mumbai");
		daoRef.create(dept);

	}

}
