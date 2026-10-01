package io_programming;

import java.io.BufferedReader;
import java.io.FileReader;

public class BufferedReaderMain {

	public static void main(String[] args) {
		String filePath = "./src/assets/greetings.txt";
						
		try (
				FileReader fr = new FileReader(filePath);
				BufferedReader br = new BufferedReader(fr)
			){
			while(true) {
				String line = br.readLine();
				if(line == null)
					break;
				System.out.println(line);
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}

	}

}
