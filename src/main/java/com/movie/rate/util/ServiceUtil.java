package com.movie.rate.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.movie.rate.model.Movie;
import com.movie.rate.model.Rating;
import com.movie.rate.model.User;

/**
 * @author HK This class act as service locator Design Pattern to make our class
 *         completely decoupled
 *
 */
public class ServiceUtil {

	public static List<Movie> getMovies(String fileName) {
		String line = "";
		Movie movie = null;
		List<Movie> movieList = new ArrayList<>();
		Scanner sc;
		try {
			File file = new File(fileName);
			sc = new Scanner(file);
			while (sc.hasNextLine()) {
				line = sc.nextLine();
				movie = new Movie();
				movie.setMovieId(Integer.parseInt(RuleUtil.movieSpilt(line)[0]));
				movie.setTitle(RuleUtil.movieSpilt(line)[1]);
				String geners = RuleUtil.movieSpilt(line)[2];
				movie.setGenres(geners);
				movieList.add(movie);
			}
		} catch (FileNotFoundException e) {
			System.out.println(fileName + " :" + e.getMessage());
		}
		return movieList;
	}

	public static List<Rating> getRatings(String fileName) {
		String line = "";
		Rating rating = null;
		List<Rating> ratingList = new ArrayList<>();
		Scanner sc;
		try {
			File file = new File(fileName);
			sc = new Scanner(file);
			while (sc.hasNextLine()) {
				line = sc.nextLine();
				rating = new Rating();
				rating.setUserId(Integer.parseInt(RuleUtil.movieSpilt(line)[0]));
				rating.setMovieId(Integer.parseInt(RuleUtil.movieSpilt(line)[1]));
				rating.setRating(RuleUtil.movieSpilt(line)[2]);
				rating.setTimeStamp(Long.parseLong(RuleUtil.movieSpilt(line)[3]));
				ratingList.add(rating);
			}
		} catch (FileNotFoundException e) {
			System.out.println(fileName + " :" + e.getMessage());
		}
		return ratingList;
	}

	public static List<User> getUsers(String fileName) {
		String line = "";
		User user = null;
		List<User> userList = new ArrayList<>();
		Scanner sc;
		try {
			File file = new File(fileName);
			sc = new Scanner(file);
			while (sc.hasNextLine()) {
				line = sc.nextLine();
				user = new User();
				user.setUserId(Integer.parseInt((RuleUtil.movieSpilt(line)[0])));
				user.setGender((RuleUtil.movieSpilt(line)[1]));
				user.setAge(Integer.parseInt((RuleUtil.movieSpilt(line)[2])));
				user.setOccupation((RuleUtil.movieSpilt(line)[3]));
				user.setZipCode((RuleUtil.movieSpilt(line)[4]));
				userList.add(user);
			}
		} catch (FileNotFoundException e) {
			System.out.println(fileName + " :" + e.getMessage());
		}
		return userList;
	}
}
