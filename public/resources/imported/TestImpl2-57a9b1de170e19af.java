package java8_features;

public class TestImpl2 implements Test{

	@Override
	public void doTest() {
		System.out.println("Testing the 2nd functionality");
		doTestAgain();
		
		Test.doFinalTest();
		
	}

}

