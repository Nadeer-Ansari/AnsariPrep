package java8_features;

public class LambdaExpressionsMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SayGreeting greeting = () -> System.out.println("Welcome");
		greeting.doGreet();
		
		UnaryCalculator squareCalc = (n) -> n * n;
		System.out.println(squareCalc.doCalculate(7));
		
		UnaryCalculator cubeCalc = num -> {
			int cube = num * num * num;
			return cube;
		};
		System.out.println(cubeCalc.doCalculate(7));
		
		BinaryCalculator multiplier = (a,b) -> a * b;
		System.out.println(multiplier.doProcess(10.23, 7.15));
		
		BinaryCalculator divider = (a,b) -> {
			double division = a/b;
			return division;
		};
		System.out.println(divider.doProcess(32.12, 7.12));
	}

}
interface SayGreeting {
	void doGreet();
}
interface UnaryCalculator {
	int doCalculate(int num);
}

interface BinaryCalculator {
	double doProcess(double x, double y);
}
