package edu.sjsu.cmpe.library.dto;

import edu.sjsu.cmpe.library.domain.Reviews;

public class ReviewDto extends LinksDto{
	private Reviews review;

	public ReviewDto(Reviews review) {
		super();
		this.review = review;
	}

	public Reviews getReview() {
		return review;
	}

	public void setReview(Reviews review) {
		this.review = review;
	}
	

}
