package exception_handling;

public class ThrowMain {
	private static int divide(int x, int y) {
		if(y == 0) {
			//Raise an exception: RuntimeException
			RuntimeException rx = 
					new RuntimeException("Unable to divide as denominator is 0");
			throw rx;
		}
		return x / y;
	}

	public static void main(String[] args) {
		try {
			System.out.println(divide(15,3));
			System.out.println(divide(25,0));
		}
		catch(RuntimeException rx) {
			String errorMessage = rx.getMessage();
			System.out.println(errorMessage);
		}
	}
}
