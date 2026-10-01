package exception_handling;

public class WithoutExceptionHandlerMain {

	public static void main(String[] args) {
		String[] flowers = 
			{"Rose", "Lotus", "Lilly", "Jasmine", "Sunflower"};
		int size = flowers.length;
		for(int index = 0; index <= size; index++) {
			String flower = flowers[index];
			System.out.println(flower);
		}

	}

}
