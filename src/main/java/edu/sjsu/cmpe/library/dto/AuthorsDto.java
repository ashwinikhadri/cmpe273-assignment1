package edu.sjsu.cmpe.library.dto;

import java.util.List;

import edu.sjsu.cmpe.library.domain.Author;

public class AuthorsDto extends LinksDto{
	List<Author> author;

    
    public AuthorsDto(List<Author> author) {
	super();
	this.author = author;
    }

	
	public List<Author> getAuthor() {
		return author;
	}

	
	public void setAuthor(List<Author> author) {
		this.author = author;
	}


}