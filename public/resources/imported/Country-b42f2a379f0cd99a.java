package collections_framework;

import java.util.Objects;

public class Country {
	private String name;
	private String capital;
	public Country() {
		name = "India";
		capital = "New Delhi";
	}
	public Country(String name, String capital) {
		super();
		this.name = name;
		this.capital = capital;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCapital() {
		return capital;
	}
	public void setCapital(String capital) {
		this.capital = capital;
	}
	@Override
	public String toString() {
		return "Country [name=" + name + ", capital=" + capital + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(capital, name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Country other = (Country) obj;
		return Objects.equals(capital, other.capital) && Objects.equals(name, other.name);
	}
}
