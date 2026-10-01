package object_class_methods;

public class EqualsMain {

	public static void main(String[] args) {
		int a = 10;
		int b = 10;
		System.out.println("Is a = b ? " + (a == b));
		
		Planet biggestPlanet = new Planet("Jupiter", 16);
		Planet largestPlanet = new Planet("Jupiter", 16);
		System.out.println("Is biggestPlanet = largestPlanet ? " + (biggestPlanet == largestPlanet));
		
		System.out.println("Is biggestPlanet equal to largestPlanet ? " + 
		(biggestPlanet.equals(largestPlanet)));

	}

}








