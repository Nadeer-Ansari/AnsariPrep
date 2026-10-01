package multithreading;

public class CurrentThreadMain {

	public static void main(String[] args) {
		System.out.println("Welcome to multithreading");
		Thread mainThread = Thread.currentThread();
		String name = mainThread.getName();
		int priority = mainThread.getPriority();
		System.out.println("Thread Name: " + name);
		System.out.println("Thread Priority: " + priority);
		//mainThread.stop();
		//System.out.println("It's over");
	}

}
