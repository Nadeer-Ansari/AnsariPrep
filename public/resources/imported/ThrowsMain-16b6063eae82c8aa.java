package exception_handling;

public class ThrowsMain {
	private static void methodA() throws Exception{
		//This method may fire an exception: Exception
		//but not willing to handle it.
		//It must be handled by its caller
	}
	private static void methodB() {
		//This method invokes methodA() that means it is a caller
		//of methodA()
		//It must handle the exception and it has done.
		try {
			methodA();
		}
		catch(Exception ex) {
			
		}
	}
	private static void methodC() throws Exception{
		//This method invokes methodA() that means it is a caller
		//of methodA()
		//It must handle the exception but actually it is also not
		//willing to handle it rather it wants its caller to handle it
		methodA();
	}
	private static void methodD() throws ArithmeticException {
		//This method may fire an exception: Exception
		//but not willing to handle it.
	}

	public static void main(String[] args) {
		methodB();
		try {
			methodC();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();//Used for debugging as it shows the entire stack trace of exception propagation
			//Must be used in DEVELOPMENT phase but not in PRODUCTION.
		}
		methodD();//Can be called without adding try-catch or even
		//throws for main() as the exception type used is an UNCHECKED exception

	}

}


class Base {
	 void m1() throws Exception {
		 //Puts a restriction on the caller to handle the exception
	 }
	 void m2() {
		 //Does not put any restriction on the caller
	 }
}

class Derived extends Base {
	 void m1()  {
		 //Removes the restriction and widens the scope
	 }
	 /*void m2() throws Exception {
		 Trying to add a restriction on the caller which is 
		 not allowd as it is narrowing the scope
	 }*/
}












