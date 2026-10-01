package example.hibernate.associations.one_to_one.unidirectional.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Person_Master")
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "person_id")
	private Integer personId;
	@Column(name = "person_name", length = 20)
	private String name;
	@Column(name = "person_email", length = 40)
	private String email;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "passport_no")//It is the foreign key column from Person_Master table that refers to primary key of Passport_Master table.
	private Passport passport;
	public Person() {
		// TODO Auto-generated constructor stub
	}
	public Integer getPersonId() {
		return personId;
	}
	public void setPersonId(Integer personId) {
		this.personId = personId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Passport getPassport() {
		return passport;
	}
	public void setPassport(Passport passport) {
		this.passport = passport;
	}
	public Person(Integer personId, String name, String email, Passport passport) {
		super();
		this.personId = personId;
		this.name = name;
		this.email = email;
		this.passport = passport;
	}
	@Override
	public String toString() {
		return "Person [personId=" + personId + ", name=" + name + ", email=" + email + ", passport=" + passport + "]";
	}

}
