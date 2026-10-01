
public class Car {
	private String make;
	private String model;
	private MusicSystem musicSystem;
	private Engine engine;
	public Car() {
		// This car does not have Music System
		make = "Hyundai";
		model = "I10";
		engine = new Engine();				
	}
	public Car(String make, String model, MusicSystem musicSystem, Engine engine) {
		super();
		this.make = make;
		this.model = model;
		this.musicSystem = musicSystem;
		this.engine = engine;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public MusicSystem getMusicSystem() {
		return musicSystem;
	}
	public void setMusicSystem(MusicSystem musicSystem) {
		this.musicSystem = musicSystem;
	}
	public Engine getEngine() {
		return engine;
	}
	public void setEngine(Engine engine) {
		this.engine = engine;
	}

}
