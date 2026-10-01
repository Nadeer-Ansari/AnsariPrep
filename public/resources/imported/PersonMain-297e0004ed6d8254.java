package enums;

import java.util.Arrays;
import java.util.List;

public class PersonMain {

	public static void main(String[] args) {
		Person p1 = new Person();
		Person p2 = new Person("Donald Trumph", "President", Nationality.US);
		Person p3 = new Person("Bear Grylls", "Reality Showman", Nationality.BRITISH);
		Person p4 = new Person("Boris Becker", "Tennis Player", Nationality.GERMAN);
		Person p5 = new Person("Pat Cummins", "Cricket Player", Nationality.OTHER);
		
		List<Person> allPersons = 
		Arrays.asList(p1,p2,p3,p4,p5);
		
		//Print all persons except with nationality: OTHER
		for(Person currentPerson : allPersons) {
			Nationality currentNationality = 
			currentPerson.getNationality();
			if(!currentNationality.equals(Nationality.OTHER))
				System.out.println(currentPerson);			
		}
	}
}
