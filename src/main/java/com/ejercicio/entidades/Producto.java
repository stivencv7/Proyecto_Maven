package com.ejercicio.entidades;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.ejercicio.controlador.Coordinador;
import com.ejercicio.gui.ConsultarPersonas;

@Entity
@Table(name="productos")
public class Producto implements  Serializable{
	
	private static final long serialVersionIID=1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_producto")
	private Long idProducto;
	

	@Column(name="nombre_producto",nullable = false,length = 45)
	private String nombreProducto;
	
	
	@Column(name="precio_producto")
	private Double precioProducto;
	
	@ManyToMany(mappedBy = "listaProductos")
	private List<Persona>listaPersona;

	
	
	
	public Producto() {
	
	}




	public Producto(Long idProducto, String nombreProducto, Double precioProducto, List<Persona> listaProductos) {
		super();
		this.idProducto = idProducto;
		this.nombreProducto = nombreProducto;
		this.precioProducto = precioProducto;
		this.listaPersona = listaProductos;
	}




	public Long getIdProducto() {
		return idProducto;
	}




	public void setIdProducto(Long idProducto) {
		this.idProducto = idProducto;
	}




	public String getNombreProducto() {
		return nombreProducto;
	}




	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}




	public Double getPrecioProducto() {
		return precioProducto;
	}




	public void setPrecioProducto(Double precioProducto) {
		this.precioProducto = precioProducto;
	}




	public List<Persona> getListaPersonas() {
		return listaPersona;
	}



	public void setListaProductos(List<Persona> listaProductos) {
		this.listaPersona = listaProductos;
	}


	public  String retornarPersona(List<Persona> persona) {
		
		String r="";
		ArrayList persona1=new ArrayList();
		if (persona!=null) {
			int i=0;
			while(i<persona.size()) {
			//for (Iterator iterator = persona.iterator(); iterator.hasNext();) {
			//Persona per = (Persona) iterator.next();
			for(Persona per:persona) {
			r=per.getNombre();
			i++;
			persona1.add(r);
			}
			}
			return persona1.toString();
		
		}else {
			return r;
		}
	}
		
	
	

	@Override
	public String toString() {
		
		return "ID: "+ idProducto +"\n" +"Nombre Producto: " + nombreProducto + "\n" +"Precio: "
				+ precioProducto+retornarPersona(listaPersona)+"\n"+"\n" ;
		
		
	}




	



	
	
	
}
