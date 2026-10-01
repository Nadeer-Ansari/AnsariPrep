package api_enhancements;

import java.util.ArrayList;
import java.util.HashSet;

public class EnhancementMain {
	
	
	/*private void m1(var x) error{
		
	}*/

	public static void main(String[] args) {
		//var names = new ArrayList<String>();
		//var numbers = new HashSet<Integer>();
		
		//int rating = 1;
		/*switch(rating) {
		case 1: System.out.println("Poor");
		break;
		case 2: System.out.println("Average");
		break;
		case 3: System.out.println("Good");
		break;
		case 4: System.out.println("Very Good");
		//break;
		case 5: System.out.println("Excellent");
		break;
		default:System.out.println("Invalid Rating");
		
		}*/
		int rating = 2;
		switch(rating) {
		case 1 -> System.out.println("Poor");
		case 2 -> System.out.println("OK");
		case 3 -> System.out.println("Excellent");
		default -> System.out.println("Invalid");
		}
		
		String currentRating = switch(rating) {
		case 1 -> "Not Satisfied";
		case 2 -> {
			String reply = "Satisfied";
			yield reply;
		}
		case 3 -> "Highly Satisfied";
		default -> "Invalid";
		};
		System.out.println(currentRating);
		
		String message = "Welcome";
		doProcess(4);
		

	}
	private static void doProcess(Object obj) {
		if(obj instanceof String str) {
			System.out.println(str.toUpperCase());
		}
		else if(obj instanceof Integer num) {
			System.out.println(num * num);
		}
	}

}
interface Test {
	private void m1() {
		
	}
	static void m2() {
		
	}
	default void m3() {
		m1();
	}
}

sealed class A permits B, C{
	
}

non-sealed class B extends A {
	
}
final class C extends A {
	
}

//class E extends A { } ==> Error
/*sealed class D extends A permits .....{
	
}*/













