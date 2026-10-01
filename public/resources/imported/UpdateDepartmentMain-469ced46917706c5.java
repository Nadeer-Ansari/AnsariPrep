package example.jdbc;

public class UpdateDepartmentMain {

	public static void main(String[] args) {
		DaoInterface<Department, Integer> daoRef = 
				new DepartmentDao();
		Department dept = daoRef.retrieveById(40);
		if(dept != null) {
			dept.setName("HR Admin");
			dept.setLocation("Chennai");
			daoRef.update(dept);
		}
			
		else
			System.out.println("Department with given ID does not exist.");
			//throw new RuntimeException("Deparment not found as the given ID is invalid");

	}

}
