package edu.sjsu.cmpe.library.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import edu.sjsu.cmpe.library.domain.Book;
import edu.sjsu.cmpe.library.domain.BookLinks;

@JsonPropertyOrder(alphabetic = true)
public class BookDto extends LinksDto {
    private BookLinks book;

    /**
     * @param book
     */
    public BookDto(BookLinks book) {
	super();
	this.book = book;
    }

    /**
     * @return the book
     */
    public BookLinks getBook() {
	return book;
    }

    /**
     * @param book
     *            the book to set
     */
    public void setBook(BookLinks book) {
	this.book = book;
    }
}
