
public class Outer {	

	private int x  = 10;
	private static int y = 20;
	
	public static class StaticInner {
		public void print() {			
			//System.out.println("X = " + x);Error as x is non-static
			System.out.println("Y = " + y);
		}
	}
	
	public class Nested {
		public void display() {			
			System.out.println("X = " + x);
			System.out.println("Y = " + y);
		}
	}
	
	public void showMessage() {
		class Message {//It is an inner class local to this method
			String getMessage(String name) {
				return "Welcome " + name;
			}
		}
		Message msg = new Message();
		System.out.println(msg.getMessage("Jack"));
	}
}

//StaticInner
//Nested
//Message








