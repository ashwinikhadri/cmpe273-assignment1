package edu.sjsu.cmpe.library.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import edu.sjsu.cmpe.library.domain.Reviews;

@JsonPropertyOrder({"reviews", "links"})
public class ReviewsDto extends LinksDto{
	List<Reviews> review;

    
    public ReviewsDto(List<Reviews> review) {
	super();
	this.review = review;
    }

	
	public List<Reviews> getReview() {
		return review;
	}

	
	public void setReview(List<Reviews> review) {
		this.review = review;
	}

}