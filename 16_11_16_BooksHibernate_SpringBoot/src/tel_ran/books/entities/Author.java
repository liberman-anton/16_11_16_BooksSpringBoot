package tel_ran.books.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Author {
	@Id
	String name;
	Date birthdate;
	@ManyToMany(mappedBy = "authors")//back connection
	Set<Book> books;
	
	public Author() {
		super();
	}

	public Author(String name, Date birthdate) {
		super();
		this.name = name;
		this.birthdate = birthdate;
	}

	public String getName() {
		return name;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	@Override
	public String toString() {
		return "Author [name=" + name + ", birthdate=" + birthdate + "]";
	}

	public Set<Book> getBooks() {
		return books;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Author other = (Author) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}	
}
