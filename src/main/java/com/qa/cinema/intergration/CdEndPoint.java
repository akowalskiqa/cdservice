package com.qa.cinema.intergration;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.cinema.business.CdService;

@Path("/cinema")
public class CdEndPoint {

	@Inject
	private CdService service;

	@Path("/json")
	@GET
	@Produces({ "application/json" })
	public String getAllMovies() {
		return service.getAllMovies();
	}

	@Path("/json/{id}")
	@GET
	@Produces({ "application/json" })
	public String getCdById(@PathParam("id") Long id) {
		return  service.getCdById(id);
	}

	@Path("/json")
	@POST
	@Produces({ "application/json" })
	public String addMovie(String cd) {
		return service.createMovie(cd);
	}

	@Path("/json/{id}")
	@PUT
	@Produces({ "application/json" })
	public String updateMovie(@PathParam("id") Long id, String cd) {
		return service.updateMovie(id, cd);
	}

	@Path("/json/")
	@DELETE
	@Produces({ "application/json" })
	public String deleteAllCds(){
		return service.deleteAllCds();
	}

	@Path("/json/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteMovie(@PathParam("id") Long id) {
		return service.deleteMovie(id);
	}
}
