package io_programming;

import java.io.File;
import java.io.IOException;

public class FileOperationsMain {

	public static void main(String[] args) {
		String path = "./src/assets/cartoons.txt";
		String path2 = "./src/assets";
		String path3 = "./src/assets/movies.txt";
		
		File file = new File(path);
		File file2 = new File(path2);
		File file3 = new File(path3);
		
		System.out.println("Path 1 valid? " + file.exists());
		System.out.println("Path 2 valid? " + file2.exists());
		System.out.println("Path 3 valid? " + file3.exists());
		
		System.out.println("-----------");
		
		System.out.println("Path 1 for Dir? " + file.isDirectory());
		System.out.println("Path 1 for File? " + file.isFile());
		
		try {
			file3.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
