package com.qa.cinema.business;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.qa.cinema.persistence.Cd;
import com.qa.cinema.util.JSONUtil;

@Stateless
@Default
public class CdServiceDBImpl implements CdService {

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil util;










































	@Override
	public String getAllMovies() {
		Query query = manager.createQuery("Select m FROM Cd m");
		Collection<Cd> cds = (Collection<Cd>) query.getResultList();
		return util.getJSONForObject(cds);
	}

	@Override
	public String createMovie(String cd) {
		Cd aMovie = util.getObjectForJSON(cd, Cd.class);
		manager.persist(aMovie);
		return "{\"message\": \"cd sucessfully added\"}";
	}

	@Override
	public String updateMovie(Long id, String cd) {
		Cd updatedMovie = util.getObjectForJSON(cd, Cd.class);
		Cd cdInDB = findMovie(id);
		if (cdInDB != null) {
			cdInDB = updatedMovie;
			manager.merge(cdInDB);
		}
		return "{\"message\": \"cd sucessfully updated\"}";
	}

	@Override
	public String deleteMovie(Long id) {
		Cd cdInDB = findMovie(id);
		if (cdInDB != null) {
			manager.remove(cdInDB);
		}
		return "{\"message\": \"cd sucessfully deleted\"}";
	}

	private Cd findMovie(Long id) {
		return manager.find(Cd.class, id);
	}

}
