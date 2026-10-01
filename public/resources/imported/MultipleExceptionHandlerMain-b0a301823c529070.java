package exception_handling;

public class MultipleExceptionHandlerMain {

	public static void main(String[] args) {
		// Program to accept 2 integers as command line arguments and print their division
		try {
			int n1 = Integer.parseInt(args[0]);
			int n2 = Integer.parseInt(args[1]);
			int div = n1 / n2;
			System.out.println("Division: " + div);
		}
		//This feature in introduced by Java version 7
		/*catch(ArrayIndexOutOfBoundsException | ArithmeticException ex) {
			if(ex instanceof ArrayIndexOutOfBoundsException)
				System.out.println("Enter at least 2 numbers");
			else
				System.out.println("Enter 2nd number as non-zero");
		}*/
		catch(ArithmeticException ex) {
			System.out.println("Enter 2nd number as non-zero");
		}
		catch(ArrayIndexOutOfBoundsException ex) {
			System.out.println("Enter at least 2 numbers");
		}
		
		
	}

}
//java MultipleExceptionHandlerMain 100 50 => 2