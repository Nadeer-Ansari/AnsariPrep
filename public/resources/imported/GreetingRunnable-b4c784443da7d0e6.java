package multithreading;

public class GreetingRunnable implements Runnable{
	private String message;
	private int timeGap;
	
	public GreetingRunnable(String message, int timeGap) {
		this.message = message;
		this.timeGap = timeGap;
	}

	@Override
	public void run() {
		for(int x = 1; x <= 10; x++) {
			System.out.println(message);
			try {
				Thread.sleep(timeGap);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
