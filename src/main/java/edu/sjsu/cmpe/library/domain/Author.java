package edu.sjsu.cmpe.library.domain;

import org.hibernate.validator.constraints.NotEmpty;

public class Author {
	int id;
	String name;

	/**private static int authorid;*/

/**	public Author() {
*		this.id = ++authorid;
	}*/


	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id  = id;
	} 
	
	@NotEmpty(message="Required field")
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}




}