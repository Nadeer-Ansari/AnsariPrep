
public class TestMain {
	static {
		System.out.println("Main class loaded.");
	}
	public static void main(String[] args) {
		System.out.println("Execution begins");
		Test test1 = new Test();
		Test test2 = new Test(2, "Automation Test");
		Test test3 = new Test("Integration Test", 3);
		System.out.println("Current Test Count: " + Test.getTestCount());
		//Creating 3 more Test objects
		for(int x=1;x<=3;x++) {
			new Test();
		}
		System.out.println("New Test Count: " + Test.getTestCount());
		//Creating 4 more Test objects
		for(int x=1;x<=4;x++) {
			new Test();
		}
		System.out.println("Final Test Count: " + Test.getTestCount());
		System.out.println("ID of 1st test: " + test1.getTestId());
	}

}
