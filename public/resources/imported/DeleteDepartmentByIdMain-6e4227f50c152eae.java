package example.jdbc;

public class DeleteDepartmentByIdMain {

	public static void main(String[] args) {
		DaoInterface<Department, Integer> daoRef = 
				new DepartmentDao();
		daoRef.deleteById(60);

	}

}
