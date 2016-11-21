package tel_ran.books.entities;

import java.util.Set;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Buyer {
	@Id
	long identity;
	String name;
	int birthYear;
	@Embedded
	Address address;
	String phoneNumber;
	String mail;
	@OneToMany(mappedBy = "buyer")
	Set<Deal> deals;
	public Buyer(long identity, String name, int birthYear, Address address, String phoneNumber, String mail) {
		super();
		this.identity = identity;
		this.name = name;
		this.birthYear = birthYear;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.mail = mail;
	}
	public Buyer() {
		super();
	}
	public Set<Deal> getDeals() {
		return deals;
	}
	public void setDeals(Set<Deal> deals) {
		this.deals = deals;
	}
	public long getIdentity() {
		return identity;
	}
	public String getName() {
		return name;
	}
	public int getBirthYear() {
		return birthYear;
	}
	public Address getAddress() {
		return address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public String getMail() {
		return mail;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (identity ^ (identity >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Buyer other = (Buyer) obj;
		if (identity != other.identity)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Buyer [identity=" + identity + ", name=" + name + ", birthYear=" + birthYear + ", address=" + address
				+ ", phoneNumber=" + phoneNumber + ", mail=" + mail + ", deals=" + deals + "]";
	}
	
	

}
