package com.movie.rate.model;

import java.io.Serializable;

public class Rating implements Serializable {

	private static final long serialVersionUID = 2599936362793290076L;

	private int userId;
	private int movieId;
	private String rating;
	private long timeStamp;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}

}
