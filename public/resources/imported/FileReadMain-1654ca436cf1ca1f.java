package nio_programming;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileReadMain {

	public static void main(String[] args) {
		String filePath = "./src/assets/greetings.txt";
		Path pathToFile = Paths.get(filePath);
		
		try {
			List<String> allLines = Files.readAllLines(pathToFile);
			for(String line : allLines)
				System.out.println(line);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
