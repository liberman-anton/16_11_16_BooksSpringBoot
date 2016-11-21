package tel_ran.books.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

@SuppressWarnings("serial")
@Embeddable
public class Address implements Serializable{
	String street;
	String city;
	int bld;
	int aprt;
		
	public Address(String street, String city, int bld, int aprt) {
		super();
		this.street = street;
		this.city = city;
		this.bld = bld;
		this.aprt = aprt;
	}

	public Address() {
		super();
	}

	@Override
	public String toString() {
		return "Address [street=" + street + ", city=" + city + ", bld=" + bld + ", aprt=" + aprt + "]";
	}
}
