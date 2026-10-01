package multithreading;

public class JoinMain {

	public static void main(String[] args) {
		System.out.println("Starting the countdown");
		Thread t1 = new Thread(new Runnable() {			
			@Override
			public void run() {
				for(int count = 10; count >= 1;count--) {
					System.out.println(count);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
		});
		t1.start();
		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Countdown is over");
	}
}
