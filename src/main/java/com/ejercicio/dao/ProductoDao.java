package com.ejercicio.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import javax.swing.text.html.HTMLDocument.Iterator;

import com.ejercicio.aplicacion.JPAUtil;
import com.ejercicio.controlador.Coordinador;
import com.ejercicio.entidades.Persona;
import com.ejercicio.entidades.PersonasProductos;
import com.ejercicio.entidades.Producto;

public class ProductoDao {
	
	EntityManager entityManager=JPAUtil.getEntityManagerFactory().createEntityManager();
	
	private Coordinador miCoordinador;

	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador=miCoordinador;
	}
	
//=================================================================================================================================	
	
	public String registrarProducto(Producto miProducto) {
		
		entityManager.getTransaction().begin();
		entityManager.persist(miProducto);
		entityManager.getTransaction().commit();
		
		String respuesta="Producto Registrado";
		
		return respuesta;
		
		
	}
//====================================================================================================================
	
	public Producto consultarProducto(Long idProducto) {
		
		Producto miProducto=entityManager.find(Producto.class, idProducto);
		
		if(miProducto!=null) {
			return miProducto;
		}else {
			return null;
		}
		
		
	}

	
//=======================================================================================================================	
	
	
	public List<Producto> consultarListaProductos() {
		List<Producto>listProducto=new ArrayList<Producto>();
		Query query=entityManager.createQuery("Select p FROM Producto p");
		listProducto=query.getResultList();
		/**
		for (Producto producto : listProducto) {
			for (Persona producto2 : producto.getListaPersonas()) {
				
				System.out.println("dao: "+producto2.getNombre());	
			}
		}
		**/
		return listProducto;
		
	}
	
	
	

	
//========================================================================================================	
	
	
	
	public String registrarCompra(PersonasProductos producto) {
		String respuesta="";
		try {

			entityManager.getTransaction().begin();
			entityManager.persist(producto);
			entityManager.getTransaction().commit();
			
			respuesta="ok";
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No se pude registrar"
					+"la compra del Producto","Error",JOptionPane.ERROR_MESSAGE);
		}
		
		return respuesta;
	}

//==========================================================================================================================

	public String actualizarProducto(Producto miProducto) {
		entityManager.getTransaction().begin();
		entityManager.merge(miProducto);
		entityManager.getTransaction().commit();
		
		String respuesta="Producto Actualizado";
		return respuesta;
		
	}


//================================================================================================================


	public String eliminarProducto(Producto miProducto) {
		
		String respuesta="";
		try {

			entityManager.getTransaction().begin();
			entityManager.remove(miProducto);
			entityManager.getTransaction().commit();
			
			 respuesta="Producto Eliminado";
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No se puede eliminar el producto"
					+"verifique que no tenga registros peendientes","Error",JOptionPane.ERROR_MESSAGE);
		}
		
		return respuesta;
	}
	


//========================================================================================

	
	public void close() {
		entityManager.close();
		JPAUtil.shutdown();
		
	}
	





	






	
}
