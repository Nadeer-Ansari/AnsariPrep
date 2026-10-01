package stream_api;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamFilterMain {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(65,77,88,92,93);
		
		
		Stream<Integer> streamOfNumbers = numbers.stream();
		Predicate<Integer> prEven = num -> num % 2 == 0;
		Stream<Integer> streamOfEvenNumbers = 
				streamOfNumbers.filter(prEven);
		Consumer<Integer> numConsumer = System.out::println;
		streamOfEvenNumbers.forEach(numConsumer);
		
		//numbers.stream().filter(num -> num % 2 ==0).forEach(System.out::println);

	}

}






