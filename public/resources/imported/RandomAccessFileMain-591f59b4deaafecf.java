package io_programming;

import java.io.RandomAccessFile;

public class RandomAccessFileMain {

	public static void main(String[] args) {
		String filePath = "./src/assets/greetings.txt";
		try (
				RandomAccessFile rf = 
				new RandomAccessFile(filePath, "r")
			){
			long fileSize = rf.length();
			long midPosition = fileSize / 2;
			rf.seek(midPosition);//Placing the file pointer at the mid position
			while(true) {
				int charValue = rf.read();
				if(charValue == -1)
					break;
				char ch = (char)charValue;
				System.out.print(ch);
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}

	}

}






