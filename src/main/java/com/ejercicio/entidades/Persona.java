package com.ejercicio.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="persona")
public class Persona implements Serializable {

	private static final long serialVersionIID=1L;
	
	@Id
	@Column(name="id_persona")
	private Long idPersona;
	
	@Column(name="nombre_persona")
	private String nombre;
	
	@Column(name="telefono_persona")
	private String telefono;
	
	@Column(name="profesion_persona")
	private String profesion;
	
	@Column(name="tipo_persona")
	private int tipo;
	
	@OneToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="nacimiento_id" , referencedColumnName="id_nacimiento")
	private Nacimiento nacimiento;

	@OneToMany(mappedBy = "duenio",cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	private List<Mascota>listaMascotas;
	
	@ManyToMany
	@JoinTable(name = "persona_productos",
	joinColumns = @JoinColumn(name = "persona_id"),
	inverseJoinColumns = @JoinColumn(name="producto_id"))
	private List<Producto>listaProductos;
	
	
	
	public Persona() {
		this.listaMascotas=new ArrayList<Mascota>();
	}

	public Persona(Long idPersona, String nombre, String releono, String profesion, int tipo, Nacimiento nacimiento) {
		super();
		this.idPersona = idPersona;
		this.nombre = nombre;
		this.telefono = releono;
		this.profesion = profesion;
		this.tipo = tipo;
		this.nacimiento = nacimiento;
		this.listaMascotas=new ArrayList<Mascota>();
	}

	
	
	public List<Mascota> getListaMascotas() {
		return listaMascotas;
	}

	public void setListaMascotas(List<Mascota> listaMascotas) {
		this.listaMascotas = listaMascotas;
	}

	public Long getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(Long idPersona) {
		this.idPersona = idPersona;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getProfesion() {
		return profesion;
	}

	public void setProfesion(String profesion) {
		this.profesion = profesion;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public Nacimiento getNacimiento() {
		return nacimiento;
	}

	public void setNacimiento(Nacimiento nacimiento) {
		this.nacimiento = nacimiento;
	}
	
	

	public List<Producto> getListaProductos() {
		return listaProductos;
	}

	public void setListaProductos(List<Producto> listaProductos) {
		this.listaProductos = listaProductos;
	}

	public  String retornarP(List<Producto> productos) {
		
		String r="";
		ArrayList p=new ArrayList();
		if (productos!=null) {
			int i=0;
			while(i<productos.size()) {
			for (Iterator iterator = productos.iterator(); iterator.hasNext();) {
			Producto producto = (Producto) iterator.next();
			r=producto.getNombreProducto();
			i++;
			p.add(r+"");
			}
			}
			return p.toString();
		
		}else {
			return r;
		}
		
	}
	
public  String retornarM(List<Mascota> mascota) {
		
		String r="";
		ArrayList m=new ArrayList();
		if (mascota!=null) {
			int i=0;
			while(i<mascota.size()) {
			for (Iterator iterator = mascota.iterator(); iterator.hasNext();) {
			Mascota animal = (Mascota) iterator.next();
			r=animal.getNombre();
			i++;
			m.add(r);
			}
			}
			return m.toString();
		
		}else {
			return r;
		}
		
	}
	@Override
	public String toString() {
		return "\n  Documento: " + idPersona + "\n" +"  Nombre: " + nombre +"\n" + "  Telefono: " + telefono +"\n" + "  Profesion: "
				+ profesion + "\n" +"  Tipo: " + tipo + "\n" +"  nacimiento: " + nacimiento
				+ "\n" +"  Nombre de Mascotas: "+retornarM(listaMascotas)+"\n" +"  Productos Comprados: "+retornarP(listaProductos)+"\n\n" ;
	}

	
	
	
	
	
}

