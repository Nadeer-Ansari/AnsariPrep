package java8_features;
@FunctionalInterface
public interface Test {
	void doTest();
	default void doTestAgain() {
		//Here the keyword [default] means default implementation.
		//The access modifier of this method is still public because the interface is public.
		System.out.println("Testing again.");
	}
	static void doFinalTest() {
		System.out.println("Doing final test");
	}
}
