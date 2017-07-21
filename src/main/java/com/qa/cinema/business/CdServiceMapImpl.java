package com.qa.cinema.business;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;

@ApplicationScoped
@Alternative
public class CdServiceMapImpl implements CdService {

	@Override
	public String getCdById(Long id){
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String deleteAllCds(){
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAllMovies() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String createMovie(String cd) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateMovie(Long id, String cd) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteMovie(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
