package edu.sjsu.cmpe.library.domain;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class Reviews {
	int id;
	
	int rating;
	
	String comment;
	private static int revid;
	
	public Reviews()
	{
		this.id = ++revid;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getRating() {
		return rating;
	}
	
	public void setRating(int rating) {
		this.rating = rating;
	}
	
	public String getComment() {
		return comment;
	}
	
	public void setComment(String comment) {
		this.comment = comment;
	}
	//Check Rating
		public boolean checkRating(){
			if (rating<1 || rating>5)
				return false;
			else
				return true;
		}
		
		//Check Comment
		public boolean checkComment(){
			if (comment == "" || comment == null)
				return false;
			else
				return true;
		}
	
	

}
