package stream_api;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamCollectMain {

	public static void main(String[] args) {
		Employee e1 = new Employee(101, "Ankit Singh", 60000);
		Employee e2 = new Employee(102, "Ravi Kumar", 50000);
		Employee e3 = new Employee(103, "Dinesh Vaidya", 70000);
		Employee e4 = new Employee(104, "Preeti Sharma", 80000);
		Employee e5 = new Employee(105, "Priyanka Verma", 40000);
		
		List<Employee> employees = Arrays.asList(e1,e2,e3,e4,e5);
		Stream<Employee> streamOfEmployees =  employees.stream();
		
		Function<Employee, EmployeeIncome> fnEmpIncome = 
				emp -> {
					String name = emp.getName();
					float sal = emp.getSal();
					float annualSal = sal * 12;
					EmployeeIncome empIncome = 
							new EmployeeIncome(name, annualSal);
					return empIncome;
				};
		Stream<EmployeeIncome> streamOfEmpIncome = 
		streamOfEmployees.map(fnEmpIncome);
		
		//Obtaining a List based upon Stream
		
		List<EmployeeIncome> listOfEmpIncome =
		streamOfEmpIncome.collect(Collectors.toList());
		for(EmployeeIncome income : listOfEmpIncome)
			System.out.println(income);
		
	}

}






