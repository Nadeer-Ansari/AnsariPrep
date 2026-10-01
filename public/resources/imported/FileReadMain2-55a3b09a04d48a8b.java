package io_programming;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileReadMain2 {

	public static void main(String[] args) {
		//c:/assets/greetings.txt => Absolute Path
		// ./src/assets/greetings.txt => Relative Path
		String filePath = "./src/assets/greetings.txt";
		try (
				FileInputStream fin = new FileInputStream(filePath)
			){
			while(true) {
				int charValue = fin.read();//Stream is Used
				if(charValue == -1)
					break;
				char ch = (char)charValue;
				System.out.print(ch);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				

	}

}
