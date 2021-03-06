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
	public String deleteAllCds(){
	    Query query = manager.createQuery("DELETE FROM Cd");
	    query.executeUpdate();
        return "{\"message\": \"cds sucessfully deleted\"}";
    }

    @Override
	public String getCdById(Long id){
		Query query = manager.createQuery("Select cd FROM Cd cd WHERE  cd.id=:id").setParameter("id",id);
		Collection<Cd> cds = (Collection<Cd>) query.getResultList();
		return util.getJSONForObject(cds);
	}

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
		Cd updatedCd = util.getObjectForJSON(cd, Cd.class);
		Cd cdInDB = findMovie(id);
		updatedCd.setId(cdInDB.getId());
		if (cdInDB != null) {
			cdInDB = updatedCd;
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
