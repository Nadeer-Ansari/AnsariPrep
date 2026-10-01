package enums;

public class Person {
	private String name;
	private String profession;
	private Nationality nationality;

	public Person() {
		name = "Narendra Modi";
		profession = "Prime Minister";
		nationality = Nationality.INDIAN;
	}

	public Person(String name, String profession, Nationality nationality) {
		super();
		this.name = name;
		this.profession = profession;
		this.nationality = nationality;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public Nationality getNationality() {
		return nationality;
	}

	public void setNationality(Nationality nationality) {
		this.nationality = nationality;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", profession=" + profession + ", nationality=" + nationality + "]";
	}

}
