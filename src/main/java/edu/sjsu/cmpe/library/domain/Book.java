package edu.sjsu.cmpe.library.domain;

import java.util.List;
import java.util.ArrayList;

import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Book {
	private long isbn;
	@NotNull
	@NotEmpty	
	private String title;
	
	@NotNull
	@NotEmpty
	@JsonProperty("publication-date")
	private String publicationDate;
	
	private String language;
	
	@JsonProperty("num-pages")
	private int numpages;
	
	private String status;
	
	@NotNull
	@NotEmpty
	List<Author> authors;
	
	
	List<Reviews> reviews = new ArrayList<Reviews>();
	String available;

	// add more fields here

	/**
	 * @return the isbn
	 */
	public long getIsbn() {
		return isbn;
	}

	
	public String getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationdate(String publicationDate) {
		this.publicationDate = publicationDate;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public int getNumpages() {
		return numpages;
	}

	public void setNumpages(int numpages) {
		this.numpages = numpages;
	}

	/**
	 * @param isbn
	 *            the isbn to set
	 */
	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		if(status.isEmpty())
		{
			
			this.status = available;
		}
		else
		{
		this.status = status;
	}
	}


	public List<Author> getAuthors() {
		return authors;
	}


	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}


	public List<Reviews> getReviews() {
		return reviews;
	}


	public void setReviews(List<Reviews> reviews) {
		this.reviews = reviews;
	}
	
	public boolean checkStatus(String status){
    	String bookStatus=status.toLowerCase();
    	if (bookStatus.equals("lost") || bookStatus.equals("checked-out")|| bookStatus.equals("in-queue") || bookStatus.equals("available"))
    		return true;    		
    	else if (status.isEmpty()) 
    		return true;
    	else
    		return false;
    }
	
}
