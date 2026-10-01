
public class ObjectsArrayMain {
	
	private static String[] getTestNames(Test[] testArrayCopy) {
		int size = testArrayCopy.length;
		String[] testNames = new String[size];
		int index = 0;
		for(Test testObj : testArrayCopy) {
			String testName = testObj.getTestName();
			testNames[index] = testName;
			index++;
		}
		return testNames;
	}
	public static void main(String[] args) {
		int size = 3;
		Test[] testArray = new Test[size];
		testArray[0] = new Test();
		testArray[1] = new Test(2, "Integration");
		testArray[2] = new Test("Automation", 3);
		
		String[] names = getTestNames(testArray);
		for(String name : names)
			System.out.println(name);
		
		/*
		 Test t1 = new Test();
		 testArray[0]= t1;
		 */

	}

}
