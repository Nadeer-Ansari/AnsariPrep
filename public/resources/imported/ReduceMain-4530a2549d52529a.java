package stream_api;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

public class ReduceMain {

	public static void main(String[] args) {
		List<String> messages = 
				Arrays.asList("Hello", "Hi", "Welcome", "Bye");
		Stream<String> streamOfMessages = messages.stream();
		BinaryOperator<String> concatOpr = (message1,message2)->{
			String joinedString =message1.concat(message2);
			return joinedString;
		};
		Optional<String> opResult =
		streamOfMessages.reduce(concatOpr);
		if(opResult.isPresent()) {
			String result = opResult.get();
			System.out.println(result);
		}

	}

}
