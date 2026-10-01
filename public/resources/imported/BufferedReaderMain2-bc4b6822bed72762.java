package io_programming;

import java.io.BufferedReader;
import java.io.FileReader;

public class BufferedReaderMain2 {

	public static void main(String[] args) {
		String filePath = "./src/assets/persons.txt";
		
		try (
				FileReader fr = new FileReader(filePath);
				BufferedReader br = new BufferedReader(fr)
			){
			Person[] allPersons = new Person[5];
			int index = 0;
			while(true) {
				String line = br.readLine();
				if(line == null)
					break;
				String[] tokens = line.split(":");
				
				String name = tokens[0];
				String nickName = tokens[1];
				int age = Integer.parseInt(tokens[2]);
				
				allPersons[index] = new Person(name, nickName, age);
				index++;
			}
			for(Person currentPerson : allPersons)
				System.out.println(currentPerson);
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}

	}

}
