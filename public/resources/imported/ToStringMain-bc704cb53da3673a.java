package object_class_methods;

public class ToStringMain {

	public static void main(String[] args) {
		int planetId = 1;
		System.out.println(planetId);
		
		Planet myPlanet = new Planet();//[Earth, 1]
		//System.out.println(myPlanet.getName());
		//System.out.println(myPlanet.getMoons());
		System.out.println(myPlanet);//Implicit Call
		System.out.println(myPlanet.toString());//Explicit Call
	}

}
