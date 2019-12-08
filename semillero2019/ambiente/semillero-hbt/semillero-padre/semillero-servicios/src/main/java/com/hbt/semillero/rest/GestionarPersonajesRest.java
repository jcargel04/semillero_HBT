package com.hbt.semillero.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import com.hbt.semillero.dto.PersonajeDTO;
import com.hbt.semillero.ejb.GestionarPersonajeBean;

@Path("/GestionarPersonaje")
public class GestionarPersonajesRest {
	
	@EJB
	private GestionarPersonajeBean gestionarPersonajesBean;
	
	@POST
	@Path("/crear")
	public void crearPersonaje(PersonajeDTO personajeDTO) {
		gestionarPersonajesBean.crearPersonaje(personajeDTO);
	}
	
	
	@GET
	@Path("/consultarPersonajes")
	public List<PersonajeDTO> consultarPersonaje() {
		return gestionarPersonajesBean.consultarPersonajes();
	}
	
	@GET
	@Path("/consultarPersonajes")
	public List<PersonajeDTO> consultarPersonajes(@QueryParam("idComic") Long idComic){
		return gestionarPersonajesBean.consultarPersonajes(idComic);
		
	}
}
