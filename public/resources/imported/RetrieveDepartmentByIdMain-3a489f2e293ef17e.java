package example.jdbc;

public class RetrieveDepartmentByIdMain {

	public static void main(String[] args) {
		DaoInterface<Department, Integer> daoRef = 
				new DepartmentDao();
		Department dept = daoRef.retrieveById(25);
		if(dept != null)
			System.out.println(dept);
		else
			System.out.println("Department with given ID does not exist.");
			//throw new RuntimeException("Deparment not found as the given ID is invalid");

	}

}
