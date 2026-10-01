package multithreading;

public class GreetingThreadMain {

	public static void main(String[] args) {
		Thread t1 = new GreetingThread("Welcome", 1000);
		Thread t2 = new GreetingThread("Hello", 500);
		t1.start();
		t2.start();
	}
}
