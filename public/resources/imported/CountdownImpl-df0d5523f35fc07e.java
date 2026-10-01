package java8_features;

public class CountdownImpl {
	public static void doRun() {
		for(int count = 10; count >= 1; count--) {
			System.out.println(count);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}


