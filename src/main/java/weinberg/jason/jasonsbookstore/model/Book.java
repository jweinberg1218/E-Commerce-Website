package weinberg.jason.jasonsbookstore.model;

import java.io.*;

import javax.persistence.*;

@Entity
@Table(name = "Books")
public class Book implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String isbn;
	private String title;
	private String description;
	private String author;
	private String coverArt;
	private float price;
	private String edition;
	
	public Book() {}

	public int getId() {
		return id;
	}

	public String getIsbn() {
		return isbn;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public String getAuthor() {
		return author;
	}

	public String getCoverArt() {
		return coverArt;
	}

	public float getPrice() {
		return price;
	}

	public String getEdition() {
		return edition;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setCoverArt(String coverArt) {
		this.coverArt = coverArt;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}
}
