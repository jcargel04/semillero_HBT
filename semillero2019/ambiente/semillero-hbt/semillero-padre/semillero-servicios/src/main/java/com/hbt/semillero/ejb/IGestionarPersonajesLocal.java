package com.hbt.semillero.ejb;

import java.util.List;

import javax.ejb.Local;

import com.hbt.semillero.dto.PersonajeDTO;

@Local
public interface IGestionarPersonajesLocal {
	
	public void crearPersonaje(PersonajeDTO personajeDTO);

	public void actualizarPersonaje();

	public void eliminarPersonaje();
	
	public void consultarPersonaje();
	
	public List<PersonajeDTO> consultarPersonajes();
	
	public List<PersonajeDTO> consultarPersonajes(Long idComic);
	
}
