package com.hbt.semillero.ejb;

import javax.ejb.Local;

import com.hbt.semillero.dto.ComicDTO;


/**
 * Expone los métodos del EJB GestionarPersonajes. 
 * 
 * @author Juan Carlos Argel
 *
 */

@Local
public interface IGestionarPersonajesLocal {
	
	/**
	 * 
	 * Metodo encargado de crear un comic y persistirlo
	 * 
	 * @author Juan Carlos Argel
	 * 
	 * @param comicNuevo informacion nueva a crear
	 */
	public void crearPersonaje(ComicDTO comicNuevo);

	/**
	 * 
	 * Metodo encargado de consultar un comic modificarlo y guardarlo
	 * 
	 * @author Juan Carlos Argel
	 * 
	 * @param comicModificar informacion nueva a modificar
	 */
	public void modificarPersonaje();

	/**
	 * 
	 * Metodo encargado de eliminar un comic modificarlo y guardarlo
	 * 
	 * @author Juan Carlos Argel
	 * 
	 * @param comicEliminar informacion a eliminar
	 */
	public void eliminarPersonaje();

	/**
	 * 
	 * Metodo encargado de retornar la informacion de un comic
	 * 
	 * @param idComic identificador del comic a ser consultado
	 * @return comic Resultado de la consulta
	 * @throws Exception si no se recibe idComic
	 */
	
	public void consultarPersonaje();
	
}
