package exception_handling;

public class DefaultExceptionHandlerMain {

	public static void main(String[] args) {
		// Program to accept 2 integers as command line arguments and print their division
		String message = "Thank You";
		try {
			
			int n1 = Integer.parseInt(args[0]);
			int n2 = Integer.parseInt(args[1]);
			System.out.println("Hello");
			int div = n1 / n2;
			System.out.println("Division: " + div);
		}
		//This feature in introduced by Java version 7
		
		catch(ArrayIndexOutOfBoundsException | ArithmeticException ex) {
			if(ex instanceof ArrayIndexOutOfBoundsException)
				//System.out.println("Enter at least 2 numbers");
				ex.printStackTrace();
			else
				System.out.println("Enter 2nd number as non-zero");
		}
		
		catch(Exception ex) {
			System.out.println("Unable to proceed. General Error");
		}
		finally {
			System.out.println(message);
		}
		
		
	}

}
