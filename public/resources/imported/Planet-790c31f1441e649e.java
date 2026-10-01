package object_class_methods;

import java.util.Objects;

public class Planet {
	private String name;
	private int moons;
	public Planet() {
		name = "Earth";
		moons = 1;
	}
	public Planet(String name, int moons) {
		super();
		this.name = name;
		this.moons = moons;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMoons() {
		return moons;
	}
	public void setMoons(int moons) {
		this.moons = moons;
	}
	@Override
	public String toString() {
		return "Planet [name=" + name + ", moons=" + moons + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(moons, name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Planet other = (Planet) obj;
		return moons == other.moons && Objects.equals(name, other.name);
	}	
	
}






