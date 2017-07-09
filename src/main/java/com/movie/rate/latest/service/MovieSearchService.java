package com.movie.rate.latest.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.movie.rate.model.Constants;
import com.movie.rate.model.GenersResp;
import com.movie.rate.model.Movie;
import com.movie.rate.model.Rating;
import com.movie.rate.model.ThrilarM;
import com.movie.rate.model.User;
import com.movie.rate.util.RuleUtil;
import com.movie.rate.util.ServiceUtil;

public class MovieSearchService {
	// Requirement : 1
	public static List<GenersResp> getMostGenMovies(List<Movie> movies) {
		List<String> movieList = new ArrayList<>();
		List<GenersResp> lGenersResps = new ArrayList<>();
		Map<Integer, Integer> movieMap = new HashMap<>();
		for (Movie movie : movies) {
			if (movie.getGenres().contains("|")) {
				for (String s : movie.getGenres().replace("|", ":").split(":")) {
					movieList.add(s);
				}
				movieMap.put(movie.getMovieId(), movieList.size());
				movieList.clear();
				continue;
			} else {
				movieMap.put(movie.getMovieId(), 1);
			}
		}
		Map<Integer, Integer> sortMap = RuleUtil.sortedMap(movieMap);
		int maxCount = (int) sortMap.values().toArray()[0];
		Set<Entry<Integer, Integer>> set = sortMap.entrySet();
		Iterator<Entry<Integer, Integer>> itr = set.iterator();
		while (itr.hasNext()) {
			Map.Entry<Integer, Integer> map = itr.next();
			if (map.getValue() == maxCount) {
				for (Movie m : movies) {
					if (m.getMovieId() == map.getKey()) {
						lGenersResps.add(new GenersResp(m.getMovieId(), m
								.getTitle(), maxCount));
					}
				}
			}
		}

		System.out.println("Total Number of movie :" + lGenersResps.size());
		return lGenersResps;
	}

	// Requirement : 2
	public static List<Movie> getHorrorList(List<Movie> movies) {
		List<Movie> movieList = new ArrayList<>();
		for (Movie movie : movies) {
			if (movie.getGenres().toLowerCase().contains("horror")) {
				int year = Integer.parseInt(movie.getTitle().replaceAll(
						"[^0-9]", ""));
				if (year >= 1985 && year < 1995) {
					movieList.add(movie);
				}
			}
		}
		return movieList;
	}

	public static List<ThrilarM> getThrilarList(List<Movie> movies) {
		List<Movie> movieList = new ArrayList<>();
		List<ThrilarM> thrilMovie = new ArrayList<>();
		// userId and rating
		Map<Integer, String> ratingMap = new HashMap<>();
		for (Movie movie : movies) {
			if (movie.getGenres().toLowerCase().contains("thriller")) {
				movieList.add(movie);
			}
		}
		List<Rating> ratings = ServiceUtil
				.getRatings(Constants.RATING_FILE_PATH);
		for (Rating rating : ratings) {
			for (Movie movie : movieList) {
				if (rating.getMovieId() == movie.getMovieId()) {
					ratingMap.put(rating.getUserId(), rating.getRating());
				}
				List<User> userss = ServiceUtil
						.getUsers(Constants.USER_FILE_PATH);
				for (User user : userss) {
					for (int userId : ratingMap.keySet()) {
						if (userId == user.getUserId()) {
							if (user.getAge() >= 12) {
								thrilMovie.add(new ThrilarM(movie.getMovieId(),
										movie.getTitle(), ratingMap.get(user
												.getUserId())));
							}
						}
					}
				}
			}

		}
		return thrilMovie;

	}

	public static void main(String[] args) {
		/*
		 * System.out.println(getMostGenMovies(ServiceUtil
		 * .getMovies(Constants.MOVIES_FILE_PATH)));
		 *//*
		System.out.println(getHorrorList(ServiceUtil
				.getMovies(Constants.MOVIES_FILE_PATH)));*/
		
		System.out.println(getThrilarList(ServiceUtil
				.getMovies(Constants.MOVIES_FILE_PATH)));
	}
}
