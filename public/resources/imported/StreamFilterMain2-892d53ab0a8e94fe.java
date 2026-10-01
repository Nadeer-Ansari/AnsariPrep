package stream_api;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamFilterMain2 {

	public static void main(String[] args) {
		Employee e1 = new Employee(101, "Ankit Singh", 55654.32f);
		Employee e2 = new Employee(102, "Ravi Kumar", 37321.12f);
		Employee e3 = new Employee(103, "Dinesh Vaidya", 75654.32f);
		Employee e4 = new Employee(104, "Preeti Sharma", 63654.32f);
		Employee e5 = new Employee(105, "Priyanka Verma", 23654.32f);
		
		List<Employee> employees = Arrays.asList(e1,e2,e3,e4,e5);
		Stream<Employee> streamOfEmployees =  employees.stream();
		Predicate<Employee> prHighSal = emp -> {
			float empSal = emp.getSal();
			boolean highlyPaid = false;
			if(empSal > 50000)
				highlyPaid = true;
			return highlyPaid;			
		};
		
		Stream<Employee> streamOfHighlyPaidEmployees =
				streamOfEmployees.filter(prHighSal);
		
		Consumer<Employee> empConsumer = emp -> {
			String empName = emp.getName();
			System.out.println(empName);
		};
		
		streamOfHighlyPaidEmployees.forEach(empConsumer);
		

	}

}







