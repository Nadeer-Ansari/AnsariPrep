package java8_features;

public class GreetMain {

	public static void main(String[] args) {
		//Creating a reference to a non-static method
		GreetImpl grImpl = new GreetImpl();
		Greet gr = grImpl::doGreetUser;
		gr.doGreet("James");
		System.out.println("-----------------");
		gr = GreetImpl::doGreetUserAgain;
		gr.doGreet("Jack");
	}

}
