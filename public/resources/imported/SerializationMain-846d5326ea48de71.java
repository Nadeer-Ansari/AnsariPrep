package io_programming;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class SerializationMain {

	public static void main(String[] args) {
		String filePath = "./src/assets/movies.txt";
		try (
				FileOutputStream fout = new FileOutputStream(filePath);
				ObjectOutputStream out = new ObjectOutputStream(fout)
			){
			Movie movieObject = new Movie("Fighter", "Action", 2024);
			out.writeObject(movieObject);
			System.out.println("Movie object has been serialized.");
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}






