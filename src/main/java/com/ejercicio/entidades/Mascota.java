package com.ejercicio.entidades;

import java.io.Serializable;

import javax.persistence.*;


@Entity
@Table(name="mascotas")
public class Mascota implements Serializable {
	
	private static final long serialVersionUID=1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id_mascota")
	private Long idMascorta;
	
	@Column(name="nombre",nullable = false, length=45)
	private String nombre;
	
	@Column(name="raza",length=45)
	private String raza;
	
	@Column(name="color",length=45)
	private String colorMascota;
	
	@Column(name="sexo",length=45)
	private String sexo;

	@ManyToOne
	@JoinColumn(name="persona_id",referencedColumnName = "id_persona")
	private Persona duenio;
	
	
	
	public Mascota() {
		super();
		// TODO Auto-generated constructor stub
	}




	public Mascota(String nombre, String raza, String colorMascota, String sexo,Persona duenio) {
		super();
		this.nombre = nombre;
		this.raza = raza;
		this.colorMascota = colorMascota;
		this.sexo = sexo;
		this.duenio=duenio;
	}




	public Long getIdMascorta() {
		return idMascorta;
	}




	public void setIdMascorta(Long idMascorta) {
		this.idMascorta = idMascorta;
	}




	public String getNombre() {
		return nombre;
	}




	public void setNombre(String nombre) {
		this.nombre = nombre;
	}




	public String getRaza() {
		return raza;
	}




	public void setRaza(String raza) {
		this.raza = raza;
	}




	public String getColorMascota() {
		return colorMascota;
	}




	public void setColorMascota(String colorMascota) {
		this.colorMascota = colorMascota;
	}




	public String getSexo() {
		return sexo;
	}




	public void setSexo(String sexo) {
		this.sexo = sexo;
	}




	public Persona getDuenio() {
		return duenio;
	}




	public void setDuenio(Persona duenio) {
		this.duenio = duenio;
	}




	@Override
	public String toString() {
		return "Mascota [idMascorta=" + idMascorta + ", nombre=" + nombre + ", raza=" + raza + ", colorMascota="
				+ colorMascota + ", sexo=" + sexo +" dueño: "+duenio.getNombre()+ "]";
	}
	
	
	
	

}
