package java8_features;

public class CountDownMain {

	public static void main(String[] args) {
		Runnable rn = CountdownImpl::doRun;
		Thread t1 = new Thread(rn);
		t1.start();

	}

}
