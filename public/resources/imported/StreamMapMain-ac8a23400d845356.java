package stream_api;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

public class StreamMapMain {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(78, 81, 9, 22, 36);
		Stream<Integer> streamOfNumbers = numbers.stream();
		Function<Integer, Double> fnSqrt = num -> {
			double squareRoot = Math.sqrt(num);
			return squareRoot;
		};
		Stream<Double> streamOfSquareRoots = 
		streamOfNumbers.map(fnSqrt);
		Consumer<Double> sqrtConsumer = System.out::println;
		streamOfSquareRoots.forEach(sqrtConsumer);

	}

}
