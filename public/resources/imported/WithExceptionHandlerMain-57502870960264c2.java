package exception_handling;

public class WithExceptionHandlerMain {

	public static void main(String[] args) {
		String[] flowers = 
			{"Rose", "Lotus", "Lilly", "Jasmine", "Sunflower"};
		int size = flowers.length;
		for(int index = 0; index <= size; index++) {
			try {
				String flower = flowers[index];
				System.out.println(flower);
			}
			catch(ArrayIndexOutOfBoundsException ex) {
				System.out.println("Index limit is over.");
			}
			
		}

	}

}
