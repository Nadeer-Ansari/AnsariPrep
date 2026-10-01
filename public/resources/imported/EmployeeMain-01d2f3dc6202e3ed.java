
public class EmployeeMain {

	public static void main(String[] args) {
		Employee emp = new Employee(2000, "Mark", 15000);
		//emp.assignValues(1234, "Tim", 65200);
		
		String empInfo = emp.getValues();
		System.out.println(empInfo);
		/*System.out.println("----------");
		System.out.println(emp.getValues());
		System.out.println("***********");
		emp.setBasicSalary(70000);
		System.out.println(emp.getValues());
		System.out.println("Basic Sal: " + emp.getBasicSalary());*/
	}

}










