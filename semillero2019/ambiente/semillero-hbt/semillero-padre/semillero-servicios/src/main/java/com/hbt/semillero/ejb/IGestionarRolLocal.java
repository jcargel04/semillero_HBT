package com.hbt.semillero.ejb;

import java.util.List;

import javax.ejb.Local;

import com.hbt.semillero.dto.RolDTO;


/**
 * Interface que expone sus métodos para que puedan ser implementados por la clase GestionarRolBean
 * @author Juan Carlos Argel
 * @version 1.0
 */

@Local
public interface IGestionarRolLocal {

	/**
	 * 
	 * Metodo encargado de crear un rol y persistirlo
	 * @author Juan Carlos Argel
	 */
	public void crearRol(RolDTO rolDTO);

	
	/**
	 * 
	 * Metodo encargado de actualizar un rol modificarlo y guardarlo
	 * @author Juan Carlos Argel
	 */
	public void actualizarRol();

	
	/**
	 * 
	 * Metodo encargado de eliminar un rol
	 * @author Juan Carlos Argel
	 */
	public void eliminarRol();
	
	
	/**
	 * 
	 * Metodo encargado de consultar todos los roles de la base de datos
	 * @author Juan Carlos Argel
	 */
	public List<RolDTO> consultarRol();
	
	
	/**
	 * 
	 * Metodo encargado de consultar un rol en particular dependiendo de su id
	 * @author Juan Carlos Argel
	 */
	public List<RolDTO> consultarRol(Long idRol);
	
	
}
