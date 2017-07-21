package com.qa.cinema.business;

public interface CdService {
	String getAllMovies();

	String createMovie(String cd);

	String updateMovie(Long id, String cd);

	String deleteMovie(Long id);
}
