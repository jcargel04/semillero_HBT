package com.hbt.semillero.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.hbt.semillero.dto.RolDTO;
import com.hbt.semillero.entidad.Rol;

/**
 * <b>Descripción:<b> Clase que determina el bean para realizar las gestion de
 * los roles
 * 
 * @author Juan Carlos Argel
 * @version 1.0
 */
@Stateless
public class GestionarRolBean implements IGestionarRolLocal {

	/**
	 * Atributo em que se usa para interacturar con el contexto de persistencia.
	 */
	@PersistenceContext
	private EntityManager entityManager;
	
	
	/**
	 * 
	 * Método para la creación de los roles asociado con RolDto
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	@Override
	public void crearRol(RolDTO rolDTO) {
		Rol rol = convertirDTOEntidad(rolDTO);
		entityManager.persist(rol);
	}
	
	@Override
	public void actualizarRol() {
		
	}
	
	@Override
	public void eliminarRol() {
		
	}
	
	/**
	 * 
	 * Método para la consulta de todos los roles en general
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	@SuppressWarnings("unchecked")
	@Override
	public List<RolDTO> consultarRol() {
		
		String query = "SELECT rol FROM Rol rol";
		
		List<Rol> listaRol = entityManager.createQuery(query).getResultList();
		
		List<RolDTO> listaRolDTO = new ArrayList<>();
		
		for (Rol rol : listaRol) {
			listaRolDTO.add(convertirEntidadDTO(rol));
		}
		return listaRolDTO;
		
	}
	
	
	/**
	 * 
	 * Método para la consulta de los roles según un id ingresado como prámetro
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	@Override
	public List<RolDTO> consultarRol(Long idRol) {

		String query = "SELECT rol FROM Rol rol WHERE rol.id = :idRol";
		
		List<Rol> listaRol = entityManager.createQuery(query).setParameter("idRol", idRol).getResultList();
		
		List<RolDTO> listaRolDTO = new ArrayList<>();
		
		for (Rol rol : listaRol) {
			listaRolDTO.add(convertirEntidadDTO(rol));
		}
		return listaRolDTO;
	}
	
	

	/**
	 * Metodo encargado de transformar un rolDTO a una entidad
	 * @param rolDTO
	 * @return rol
	 */
	private Rol convertirDTOEntidad(RolDTO rolDTO) {
		Rol rol = new Rol();
		
		rol.setId(rolDTO.getId());
		rol.setNombre(rolDTO.getNombre());
		rol.setEstado(rolDTO.getEstado());
		return rol;
	}
	
	
	/**
	 * Metodo encargado de transformar una entidad a un rolDTO
	 * @param rol
	 * @return rolDTO
	 */
	private RolDTO convertirEntidadDTO(Rol rol) {
		RolDTO rolDTO = new RolDTO();
		
		rolDTO.setId(rolDTO.getId());
		rolDTO.setNombre(rolDTO.getNombre());
		rolDTO.setEstado(rolDTO.getEstado());
		return rolDTO;
	}

}
