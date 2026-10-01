package example.spring.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Customer {
	private String firstName;
	private String lastName;
	@Autowired(required = false)//Making this auto wiring OPTIONAL
	@Qualifier("office")//Qualifies the Address bean with ID: home
	private Address communicationAddress;
	public Customer() {
		// TODO Auto-generated constructor stub
	}
	public Customer(String firstName, String lastName, Address communicationAddress) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.communicationAddress = communicationAddress;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Address getCommunicationAddress() {
		return communicationAddress;
	}
	public void setCommunicationAddress(Address communicationAddress) {
		this.communicationAddress = communicationAddress;
	}
	@Override
	public String toString() {
		return "Customer [firstName=" + firstName + ", lastName=" + lastName + ", communicationAddress="
				+ communicationAddress + "]";
	}

}
