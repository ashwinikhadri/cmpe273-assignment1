package edu.sjsu.cmpe.library.repository;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import java.util.concurrent.ConcurrentHashMap;

import edu.sjsu.cmpe.library.domain.Book;
import edu.sjsu.cmpe.library.domain.Author;
import edu.sjsu.cmpe.library.domain.Reviews;

import java.util.List;
//import java.util.ArrayList;


public class BookRepository implements BookRepositoryInterface {
    /** In-memory map to store books. (Key, Value) -> (ISBN, Book) */
    private final ConcurrentHashMap<Long, Book> bookInMemoryMap;

    /** Never access this key directly; instead use generateISBNKey() */
    private long isbnKey;
    private int authidkey;
    private int revidkey;

    public BookRepository(ConcurrentHashMap<Long, Book> bookMap) {
	checkNotNull(bookMap, "bookMap must not be null for BookRepository");
	bookInMemoryMap = bookMap;
	isbnKey = 0;
    }

    /**
     * This should be called if and only if you are adding new books to the
     * repository.
     * 
     * @return a new incremental ISBN number
     */
    private final Long generateISBNKey() {
	// increment existing isbnKey and return the new value
	return Long.valueOf(++isbnKey);
    }
	
	private final int generateAuthorID() {
    	// increment AuthorID and return the new value
    	return ++authidkey;
    }
	
	private final int genID(){
		return ++revidkey;
	}

    /**
     * This will auto-generate unique ISBN for new books.
     * 
     * 
     */
	
    @Override
    public Book saveBook(Book newBook) {
	checkNotNull(newBook, "newBook instance must not be null");
	
	List<Author> author = newBook.getAuthors();
	// Generate new ISBN
	Long isbn = generateISBNKey();
	newBook.setIsbn(isbn);
	for(int i=0; i<author.size();i++){
		Author atemp = author.get(i);
		atemp.setId(generateAuthorID());
	}
	
	bookInMemoryMap.putIfAbsent(isbn, newBook);

	return newBook;
    }

    /**
     * @see edu.sjsu.cmpe.library.repository.BookRepositoryInterface#getBookByISBN(java.lang.Long)
     */
    @Override
    public Book getBookByISBN(Long isbn) {
	checkArgument(isbn > 0,
		"ISBN was %s but expected greater than zero value", isbn);
	return bookInMemoryMap.get(isbn);
    }
    
    @Override
    public Book deleteBookByISBN(Long isbn){
    	if(bookInMemoryMap.containsKey(isbn))
    	{
    		return bookInMemoryMap.remove(isbn);
    		
    		
    		
    		}
    		
		return null;
    }
    
    @Override
    public void updateBookByISBN(Long isbn, String status)
    {
    	checkArgument(isbn > 0,
    			"ISBN was %s but expected greater than zero value", isbn);
    	checkNotNull(status, "status must not be null");
    	Book book = bookInMemoryMap.get(isbn);
    	checkNotNull(book, "book instance must not be null");
    	book.setStatus(status);
    	bookInMemoryMap.put(isbn, book);
    }
    
    
    public Book getAuthorByISBN(Long isbn, int id) {
	checkArgument(isbn > 0,
		"ISBN was %s but expected greater than zero value", isbn);
	return bookInMemoryMap.get(isbn);
    }
    
    @Override
	public Book getAuthorByID(Long isbn, int id) {
		// TODO Auto-generated method stub
		return null;
	}
  	
    	  	
     	
	@Override
	public Reviews getReviewByID(Long isbn, int id) {
		Book book = bookInMemoryMap.get(isbn);
		List<Reviews> review = book.getReviews();
		for(int i=0; i<review.size();i++){
			if(review.get(i).getId()==id){
				return review.get(i);
				}
		}
		
		

		return null;
		
		
	}

	

}
