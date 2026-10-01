
public class ContainmentMain {

	public static void main(String[] args) {
		Car simpleCar, premiumCar;
		simpleCar = new Car();
		
		Engine premiumEngine = new Engine("2600 CC", "Diesel");
		MusicSystem premiumMusicSystem =
				new MusicSystem("Sony", "Dolby 3D");
		premiumCar = 
		new Car("Toyota", "Innova", premiumMusicSystem, premiumEngine);
		//Fetching make of simple car
		System.out.println(simpleCar.getMake());
		
		//Fetching power of an engine available in simple car
		//Using Explicit Reference
		Engine simpleEngine = simpleCar.getEngine();
		String simpleEnginePower = simpleEngine.getPower();
		System.out.println(simpleEnginePower);
		
		//Fetching power of an engine available in premium car
		//Using Object Graph Navigation
		String premiumEnginePower = premiumCar.getEngine().getPower();
		System.out.println(premiumEnginePower);
		
		//Fetching sound effect of music system available in premium car
		/*String premiumSoundEffect =
		premiumCar.getMusicSystem().getSoundEffect();
		System.out.println(premiumSoundEffect);
		*/
		premiumMusicSystem = premiumCar.getMusicSystem();
		if(premiumMusicSystem != null) { //If music system exists
			String soundEffect = premiumMusicSystem.getSoundEffect();
			System.out.println(soundEffect);
		}
		else
			System.out.println("This car does not have music system");
		
		

	}

}
