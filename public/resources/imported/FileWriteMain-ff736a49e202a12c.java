package nio_programming;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class FileWriteMain {

	public static void main(String[] args) {
		String filePath = "./src/assets/trainings.txt";
		Path pathToFile = Paths.get(filePath);
		String trainings = """
				Blockchain
				DevOps
				""";
		try {
			Files.writeString(pathToFile, trainings, StandardOpenOption.APPEND);
			System.out.println("Data is written to file");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
