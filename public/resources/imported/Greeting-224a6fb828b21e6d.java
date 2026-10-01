
public class Greeting {

	public static void main(String[] args) {
		String greeting  = "Welcome";
		String greeting2 = "Welcome";
		String greeting3 = new String("Welcome");
		System.out.println(greeting == greeting2);
		System.out.println(greeting == greeting3);
		
		/*String message = "Hello";
		System.out.println(message);
		message = message + "Hi";
		System.out.println(message);
		message = message + "Bye";
		System.out.println(message);
		
		final float PI = 3.14f;
		final float GRAVITY = 9.8f;
		
		final Test ts = new Test(11, "UAT");
		System.out.println(ts.getTestName());
		ts.setTestName("Manual");
		System.out.println(ts.getTestName());
		
		//ts = new Test(11, "Manual");Error because reference must stay the same
		
		System.out.println("Welcome to Java Programming.");
		Shape sh;
		sh = new Rectangle();
		sh.draw();
		sh = new Circle();
		sh.draw();
		sh.erase();*/
	}

}

abstract class Shape {
	abstract void draw();//Abstract Method
	final void erase() {//Concrete Method
		System.out.println("Erasing the shape using eraser");
	}
	private void m1() {
		
	}
}

final class Rectangle extends Shape {
	//@Override
	//void m1() {	} Error because m1() is private
	
	//@Override
	//public void erase() {} Error because erase() is final
	
	@Override
	void draw() {
		System.out.println("Drawing a rectangle");
		
	}
	
}

//class Rectangle3D extends Rectangle {} Error because class Rectangle is final

class Circle extends Shape {

	@Override
	void draw() {
		System.out.println("Drawing a circle");
		
	}
	
}












