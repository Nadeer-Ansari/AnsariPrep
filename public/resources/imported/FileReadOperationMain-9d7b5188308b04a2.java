package io_programming;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

public class FileReadOperationMain {
	public static void main(String[] args) {
		String path = "./src/assets/cartoons.txt";
		File file = new File(path);
		if(file.exists() && file.isFile()) {
			try (
					FileInputStream fin = new FileInputStream(file);
					BufferedInputStream bin = new BufferedInputStream(fin)
				){
				long fileSize = file.length();
				int dim = (int)fileSize;
				byte[] data = new byte[dim];
				bin.read(data);
				String fileData = new String(data);
				System.out.println(fileData);
			}
			catch(Exception ex) {
				ex.printStackTrace();
			}
		}
		else
			System.out.println("Unable to proceed as the specified path is invalid");
	}
}
