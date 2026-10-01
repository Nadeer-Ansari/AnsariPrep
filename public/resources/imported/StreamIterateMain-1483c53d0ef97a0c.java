package stream_api;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class StreamIterateMain {

	public static void main(String[] args) {
		List<String> courses = 
		Arrays.asList("Java", "Python", "React", "Angular", "AWS");
		//Obtaining a stream on the top of List: courses
		
		//Stream<String> streamOfCourses = courses.stream();
		
		
		//Using Lambda Expression
		/*Consumer<String> courseConsumer = 
				(course) -> System.out.println(course.toUpperCase());
		streamOfCourses.forEach(courseConsumer);*/
		
		
		//Using Method Reference
		/*Consumer<String> courseConsumer = System.out::println;
		streamOfCourses.forEach(courseConsumer);*/
		
		//Using Method Chaining
		
		//courses.stream().forEach(System.out::println);
		
		//OR
		
		courses.stream().
		forEach(course -> System.out.println(course));
		
		
	}
}




