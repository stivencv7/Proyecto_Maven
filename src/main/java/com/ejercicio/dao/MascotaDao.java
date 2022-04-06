package com.ejercicio.dao;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.swing.JOptionPane;

import com.ejercicio.aplicacion.JPAUtil;
import com.ejercicio.controlador.Coordinador;
import com.ejercicio.entidades.Mascota;
import com.ejercicio.entidades.Persona;

public class MascotaDao {
	private Coordinador miCoordinador;
	private Persona miPersona;
	
	EntityManager entityManager=JPAUtil.getEntityManagerFactory().createEntityManager();

	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador = miCoordinador;
	}
	
	public String registrarMascota(Mascota miMascota) {
		System.out.println("masdoa"+miMascota);
		String respuesta="";
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(miMascota);
			entityManager.getTransaction().commit();
			
			 respuesta="Mascota Registrada";
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No se puede registrar"
					+"la mascota verifique que el dueño exista","Error",JOptionPane.ERROR_MESSAGE);
		}
		
		return respuesta;
	}

	public Mascota consultarMascota(Long idMascota) {
		Mascota miMascota=entityManager.find(Mascota.class, idMascota);
		
		if(miMascota!=null) {
			return miMascota;
		}else {
			return null;
		}
		
	}

	public List<Mascota> consultarListaMascotas() {
		List<Mascota>listMascotas=new ArrayList<Mascota>();
		Query query=entityManager.createQuery("Select m FROM Mascota m");
		listMascotas=query.getResultList();
		System.out.println(listMascotas);
		return listMascotas;
	}

	

	public List<Mascota> consultarListaMascotasPorSexo(String sexo) {
		List<Mascota>listMascotas=new ArrayList<Mascota>();
		String sentecia="SELECT  m FROM Mascota m WHERE m.sexo= :sexoMascota";
		Query query=entityManager.createQuery(sentecia);
			query.setParameter("sexoMascota",sexo);
			listMascotas=query.getResultList();
			System.out.println("hola"+listMascotas);
		return listMascotas;
	}

	public String actualizarMascota(Mascota miMascota) {
		
		String respuesta="";
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(miMascota);
			entityManager.getTransaction().commit();
			
			 respuesta="Mascota Actualizada";
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No se puede Actualizar"
					+"la mascota verifique que el dueño exista","Error",JOptionPane.ERROR_MESSAGE);
		}
		
		return respuesta;
	}

	public String eliminarMascota(Mascota miMascota) {
		entityManager.getTransaction().begin();
		entityManager.remove(miMascota);
		entityManager.getTransaction().commit();
		
		String respuesta="Mascota Eliminada";
		return respuesta;
	
	}
	
	public void close() {
		entityManager.close();
		JPAUtil.shutdown();
	}
	 
}
