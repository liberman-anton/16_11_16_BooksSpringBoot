package tel_ran.books.dao;

public class PublisherNotFoundException extends Exception {
	String name;

	public PublisherNotFoundException(String name) {
		super("Publisher not found " + name);
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
}
