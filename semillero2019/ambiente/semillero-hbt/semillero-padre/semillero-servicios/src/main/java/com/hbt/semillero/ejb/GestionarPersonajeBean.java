package com.hbt.semillero.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.hbt.semillero.dto.PersonajeDTO;
import com.hbt.semillero.entidad.Comic;
import com.hbt.semillero.entidad.Personaje;


@Stateless
public class GestionarPersonajeBean implements IGestionarPersonajesLocal {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void crearPersonaje(PersonajeDTO personajeDTO) {
		Personaje personaje = convertirDTOEntidad(personajeDTO);
		entityManager.persist(personaje);
	}
	
	@Override
	public void actualizarPersonaje() {
		
	}
	
	@Override
	public void eliminarPersonaje() {
		
	}
	
	@Override
	public void consultarPersonaje() {
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<PersonajeDTO> consultarPersonajes() {
		
		String query = "SELECT personaje FROM Personaje personaje";
		
		List<Personaje> listaPersonajes = entityManager.createQuery(query).getResultList();
		
		List<PersonajeDTO> listaPersonajeDTO = new ArrayList<>();
		
		for (Personaje personaje : listaPersonajes) {
			listaPersonajeDTO.add(convertirEntidadDTO(personaje));
		}
		return listaPersonajeDTO;
		
	}
	
	
	@Override
	public List<PersonajeDTO> consultarPersonajes(Long idComic) {

		String query = "SELECT personaje FROM Personaje personaje WHERE personaje.comic.id = :idComic";
		
		List<Personaje> listaPersonajes = entityManager.createQuery(query).setParameter("idComic", idComic).getResultList();
		
		List<PersonajeDTO> listaPersonajeDTO = new ArrayList<>();
		
		for (Personaje personaje : listaPersonajes) {
			listaPersonajeDTO.add(convertirEntidadDTO(personaje));
		}
		return listaPersonajeDTO;
	}
	
	
	
	private Personaje convertirDTOEntidad(PersonajeDTO personajeDTO) {
		Personaje personaje = new Personaje();
		
		personaje.setId(personajeDTO.getId());
		personaje.setNombre(personajeDTO.getNombre());
		personaje.setComic(new Comic());
		personaje.getComic().setId(personajeDTO.getIdcomic());
		personaje.setEstado(personajeDTO.getEstado());
		personaje.setSuperPoder(personajeDTO.getSuperPoder());
		return personaje;
	}
	
	
	private PersonajeDTO convertirEntidadDTO(Personaje personaje) {
		PersonajeDTO personajeDTO = new PersonajeDTO();
		
		personajeDTO.setId(personajeDTO.getId());
		personajeDTO.setNombre(personajeDTO.getNombre());
		personajeDTO.setIdcomic(personaje.getComic().getId());
		personajeDTO.setEstado(personajeDTO.getEstado());
		personajeDTO.setSuperPoder(personajeDTO.getSuperPoder());
		return personajeDTO;
	}


	
}
