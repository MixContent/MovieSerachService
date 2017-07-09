package com.movie.rate.model;

import java.io.Serializable;

public class Movie implements Serializable, Comparable<Movie> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1756248641369538530L;

	private int movieId;
	private String title;
	private String genres;

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenres() {
		return genres;
	}

	public void setGenres(String genres) {
		this.genres = genres;
	}

	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", title=" + title + ", genres=" + genres + "]";
	}

	@Override
	public int compareTo(Movie obj) {
		return this.title.compareTo(obj.title);
	}

}
