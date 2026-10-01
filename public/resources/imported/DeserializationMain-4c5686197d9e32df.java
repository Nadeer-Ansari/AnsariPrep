package io_programming;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class DeserializationMain {

	public static void main(String[] args) {
		String filePath = "./src/assets/movies.txt";
		try(
				FileInputStream fin = new FileInputStream(filePath);
				ObjectInputStream in = new ObjectInputStream(fin)
			){
			Object obj = in.readObject();
			System.out.println(obj);
			Movie mv = (Movie)obj;
			System.out.println(mv.getTitle());
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}

}
