package tel_ran.books.entities;


import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Publisher {
	@Id
	String name;
	@Embedded
	Address address;
	
	public Publisher(String name, Address address) {
		super();
		this.name = name;
		this.address = address;
	}
	
	public Publisher() {
		super();
	}
	@Override
	public String toString() {
		return "Publisher [name=" + name + ", address=" + address + "]";
	}
	public String getName() {
		return name;
	}

	public Address getAddress() {
		return address;
	}
}
