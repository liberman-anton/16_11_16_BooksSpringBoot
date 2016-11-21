package tel_ran.books.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Deal {
	@Id
	@GeneratedValue
	int id;
	int discount;
	Date date;
	@ManyToOne
	Buyer buyer;
	
	public Deal(int discount, Date date) {
		super();
		this.discount = discount;
		this.date = date;
	}

	public Deal() {
		super();
	}

	public Buyer getBuyer() {
		return buyer;
	}

	public void setBuyer(Buyer buyer) {
		this.buyer = buyer;
	}

	public int getDiscount() {
		return discount;
	}

	public Date getDate() {
		return date;
	}

	@Override
	public String toString() {
		return "Deal [discount=" + discount + ", date=" + date + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Deal other = (Deal) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
}
