package java8_features;

public class TestMain {

	public static void main(String[] args) {
		Test ts = new TestImpl();
		ts.doTest();
		ts = new TestImpl2();
		ts.doTest();

	}

}
