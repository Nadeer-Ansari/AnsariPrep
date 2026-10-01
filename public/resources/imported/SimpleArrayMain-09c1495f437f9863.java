
public class SimpleArrayMain {

	public static void main(String[] args) {
		int[] numbers = new int[3];
		numbers[0] = 20;
		numbers[1] = 32;
		numbers[2] = 7;
		int size = numbers.length;
		for(int index = 0; index < 3; index++) {
			int number = numbers[index];
			System.out.println(number);
		}
		System.out.println("-------------");
		String[] names = {"Akash", "Smriti", "Abhishek"};
		for(String name : names) {
			System.out.println(name.toUpperCase());
		}

	}

}
