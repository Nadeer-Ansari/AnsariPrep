
public class ParameterPassingMain {
	
	private static void changeX(int xCopy) {
		xCopy = 20;
	}
	
	private static void changeTest(Test tsCopy) {
		tsCopy.setTestId(21);
		tsCopy.setTestName("User Acceptance Test");
	}

	public static void main(String[] args) {
		int x = 10;
		System.out.println("Value before change: " +  x);
		changeX(x);
		System.out.println("Value after change: " +  x);
		
		System.out.println("----------------------------");
		
		Test ts = new Test(11, "Manual Test");
		System.out.println("Test Values before change: ");
		System.out.println(ts.getTestId() + ", " + ts.getTestName());
		changeTest(ts);
		System.out.println("Test Values after change: ");
		System.out.println(ts.getTestId() + ", " + ts.getTestName());
	}

}


