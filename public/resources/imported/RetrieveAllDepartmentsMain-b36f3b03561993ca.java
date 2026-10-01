package example.jdbc;

import java.util.Collection;

public class RetrieveAllDepartmentsMain {

	public static void main(String[] args) {
		DaoInterface<Department, Integer> daoRef = 
				new DepartmentDao();
		Collection<Department> allDepts =  daoRef.retrieveAll();
		
		for(Department dept : allDepts)
			System.out.println(dept);
		
		
		//Using Stream API and Lambda Expression
		//allDepts.stream().forEach(dept -> System.out.println(dept));
		
		//Using Stream API and Method Reference
		//allDepts.stream().forEach(System.out::println);
		

	}

}
