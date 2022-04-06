package com.ejercicio.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.swing.JOptionPane;

import com.ejercicio.aplicacion.JPAUtil;
import com.ejercicio.controlador.Coordinador;
import com.ejercicio.entidades.Mascota;
import com.ejercicio.entidades.Persona;

public class PersonaDao {
	
	EntityManager entityManager=JPAUtil.getEntityManagerFactory().createEntityManager();
	private Coordinador miCoordinador;
	
	
	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador=miCoordinador;
	}
	
	public String registrarPersona(Persona miPersona) {
		
		try {
			
		
		entityManager.getTransaction().begin();
		entityManager.persist(miPersona);
		entityManager.getTransaction().commit();
		
		String respuesta="Persona Registrada";
		return respuesta;
		} catch (Exception e) {
			System.out.println(e+":ees ta ");
		}
		return "";
	
	}
	
	public Persona consultarPersona(Long idPersona) {
			System.out.println("personaDao: "+idPersona);
			//Persona miPersona=entityManager.find(Persona.class, idPersona);
			Persona miPersona=entityManager.find(Persona.class, idPersona);
			
			System.out.println("personaDao: "+miPersona);
			if(miPersona!=null) {
				System.out.println(miPersona);
				return miPersona;
			
			}else {
				return null;
			}
			
		
	}

	public List<Persona> consultarListaPersonas() {
		List<Persona>listPersonas=new ArrayList<Persona>();
		Query query=entityManager.createQuery("Select p FROM Persona p");
		listPersonas=query.getResultList();
		return listPersonas;
	}

	public String actualizarPersona(Persona miPersona) {
		entityManager.getTransaction().begin();
		entityManager.merge(miPersona);
		entityManager.getTransaction().commit();
		
		String respuesta="Persona Actualizada";
		return respuesta;
	}

	public String eliminarPersona(Persona miPersona) {
		String respuesta="";
		try {

			entityManager.getTransaction().begin();
			entityManager.remove(miPersona);
			entityManager.getTransaction().commit();
			
			 respuesta="Persona Eliminada";
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No se puede eliminar la persona"
					+"verifique que no tenga registros peendientes","Error",JOptionPane.ERROR_MESSAGE);
		}
		
		return respuesta;
	}

	
	public void close() {
		entityManager.close();
		JPAUtil.shutdown();
	}

	
	

}
