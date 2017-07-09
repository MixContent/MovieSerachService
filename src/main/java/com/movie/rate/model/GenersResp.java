package com.movie.rate.model;

public class GenersResp {

	private int movieId;
	private String name;
	private int genresCount;

	public GenersResp(int movieId, String name, int genresCount) {
		super();
		this.movieId = movieId;
		this.name = name;
		this.genresCount = genresCount;
	}

	@Override
	public String toString() {
		return "GenersResp [movieId=" + movieId + ", name=" + name
				+ ", genresCount=" + genresCount + "]";
	}

}
