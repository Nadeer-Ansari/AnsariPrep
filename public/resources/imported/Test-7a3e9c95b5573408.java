
public class Test {
	static {
		testCount = 100;
	}
	private int testId;
	private String testName;
	private static int testCount;
	public Test() {
		testId = 1;
		testName = "Manual Test";
		testCount++;
	}
	public Test(int testId, String testName) {
		this.testId = testId;
		this.testName = testName;
		testCount++;
	}
	public Test(String testName, int testId) {
		this.testName = testName;
		this.testId = testId;
		testCount++;
	}
	//Getters and Setters
	public static int getTestCount() {//This is a static method
		//System.out.println(testId); Error because testId is non-static
		return testCount;
	}
	public int getTestId() {//This is a non-static method
		//System.out.println(testCount);//Accessing static variable
		return testId;
	}
	public String getTestName() {
		return testName;
	}
	public void setTestName(String testName) {
		this.testName = testName;
	}
	public void setTestId(int testId) {
		this.testId = testId;
	}

}








