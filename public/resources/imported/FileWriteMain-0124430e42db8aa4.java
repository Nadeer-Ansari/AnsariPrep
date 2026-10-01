package io_programming;

import java.io.FileOutputStream;

public class FileWriteMain {

	public static void main(String[] args) {
		String filePath = "./src/assets/cartoons.txt";
		String fileData = """
				5. Chota Bheem
				6. Shin Chan
				""";
		try(
			FileOutputStream fout = new FileOutputStream(filePath, true)
		){
			byte[] data = fileData.getBytes();
			fout.write(data);
			System.out.println("Data is written to file.");
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}

	}

}
