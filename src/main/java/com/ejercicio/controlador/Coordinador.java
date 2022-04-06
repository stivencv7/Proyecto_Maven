package com.ejercicio.controlador;

import java.util.ArrayList;
import java.util.List;

import com.ejercicio.dao.MascotaDao;
import com.ejercicio.dao.PersonaDao;
import com.ejercicio.dao.ProductoDao;
import com.ejercicio.entidades.Mascota;
import com.ejercicio.entidades.Persona;
import com.ejercicio.entidades.PersonasProductos;
import com.ejercicio.entidades.Producto;
import com.ejercicio.gui.ConsultarPersonas;
import com.ejercicio.gui.RegistrarMascotasGui;
import com.ejercicio.gui.RegistrarPersonasGui;
import com.ejercicio.gui.RegistrarProductosGui;
import com.ejercicio.gui.VentanaActalizarProducto;
import com.ejercicio.gui.VentanaActualizarMascota;
import com.ejercicio.gui.VentanaActualizarPersona;
import com.ejercicio.gui.VentanaConsultIndividual;
import com.ejercicio.gui.VentanaConsultarMascotas;
import com.ejercicio.gui.VentanaConsultarProductos;
import com.ejercicio.gui.VentanaEliminar;
import com.ejercicio.gui.VentanaEliminarProductos;
import com.ejercicio.gui.VentanaPrincipal;

public class Coordinador {

	VentanaPrincipal miVentanaPrincipal;
	RegistrarPersonasGui miRegistrarPersonasGui;
	RegistrarMascotasGui miRegistrarMascotasGui;
	PersonaDao miPersonaDao;
	MascotaDao miMascotaDao;
	VentanaConsultIndividual miVentanaConsultIndividual;
	VentanaActualizarPersona miVentanaActualizarPersona;
	ConsultarPersonas consultarPersonas;
	VentanaEliminar miVentanaEliminar;
	VentanaActualizarMascota actualizarMascota;
	VentanaConsultarMascotas miVentanaConsultarMascotas;
	RegistrarProductosGui miRegistrarProductosGui;
	ProductoDao miProductoDao;
	VentanaEliminarProductos miVentanaEliminarP;
	VentanaActalizarProducto actalizarProducto;
	VentanaConsultarProductos miVentanaConsultarProductos;
	
	
	
	public void setMiVentanaConsultarProductos(VentanaConsultarProductos miVentanaConsultarProductos) {
		this.miVentanaConsultarProductos = miVentanaConsultarProductos;
	}

	
	public void setActalizarProducto(VentanaActalizarProducto actalizarProducto) {
		this.actalizarProducto = actalizarProducto;
	}
	
	public void setActualizarMascota(VentanaActualizarMascota actualizarMascota) {
		this.actualizarMascota = actualizarMascota;
	}
	
	public void setMiVentanaConsultarMascotas(VentanaConsultarMascotas miVentanaConsultarMascotas) {
		this.miVentanaConsultarMascotas = miVentanaConsultarMascotas;
	}

	public void setVentanaPrincipal(VentanaPrincipal miVentanaPrincipal) {
		this.miVentanaPrincipal = miVentanaPrincipal;
	}
	public void setRegistrarMascotasGui(RegistrarMascotasGui miRegistrarMascotasGui) {
		this.miRegistrarMascotasGui = miRegistrarMascotasGui;
	}
	public void mostrarRegistroMascotas() {
		miRegistrarMascotasGui.setVisible(true);
	}
	
	public void setRegistrarPersonasGui(RegistrarPersonasGui miRegistrarPersonasGui) {
		this.miRegistrarPersonasGui = miRegistrarPersonasGui;
	}
	
	public void setPersonaDao(PersonaDao miPersonaDao) {
		this.miPersonaDao = miPersonaDao;
	}
	
	public void setMascotaDao(MascotaDao miMascotaDao) {
		this.miMascotaDao = miMascotaDao;
	}
	
	public void setMiVentanaConsultIndividual(VentanaConsultIndividual miVentanaConsultIndividual) {
		this.miVentanaConsultIndividual = miVentanaConsultIndividual;
	}
	
	public void setMiVentanaActualizarPersona(VentanaActualizarPersona miVentanaActualizarPersona) {
		this.miVentanaActualizarPersona = miVentanaActualizarPersona;
	}
	
	public void setConsultarPersonas(ConsultarPersonas consultarPersonas) {
		this.consultarPersonas = consultarPersonas;
	}
	public void setVentanaEliminar(VentanaEliminar miVentanaEliminar) {
		this.miVentanaEliminar = miVentanaEliminar;
	}
	public void setRegistrarProductosGui(RegistrarProductosGui miRegistrarProductosGui) {
		this.miRegistrarProductosGui = miRegistrarProductosGui;
	}
	public void setProductoDao(ProductoDao miProductoDao) {
		this.miProductoDao = miProductoDao;
	}
	
	public void setVentanaEliminarP(VentanaEliminarProductos miVentanaEliminarProductos) {
		this.miVentanaEliminarP = miVentanaEliminarProductos;
	}

	public void mostrarRegistroPersonas() {
		miRegistrarPersonasGui.setVisible(true);
	}
	
	
	public String registrarPersonas(Persona p) {
		System.out.println("hsd"+p);	
		return miPersonaDao.registrarPersona(p);

	}
	
	public void mostrarConsultaIndividual() {
		miVentanaConsultIndividual.setVisible(true);
	}
	
	public void mostrarVenActualizar() {
		miVentanaActualizarPersona.setVisible(true);
	}
	
	public void mostrarConsultarPersonas() {
		consultarPersonas.setVisible(true);
	}
	public void mostrarActualizarMascota() {
		actualizarMascota.setVisible(true);
	}
	
	public void mostrarEliminarMascotas() {
		miVentanaEliminar.setVisible(true);
	}	
	
	public void mostrarConsultarMascotas() {
		miVentanaConsultarMascotas.setVisible(true);
	}
	
	public void mostrarRegistroProductos() {
		miRegistrarProductosGui.setVisible(true);
	}
	
	public void mostrarEliminarProductos() {
		miVentanaEliminarP.setVisible(true);
	}

	public void mostrarVentanaActualizarProducto() {
		actalizarProducto.setVisible(true);
	}
	
	public Persona buscarPersona(long documento) {
		System.out.println("coordinador: "+documento);

		try {
			Persona p = miPersonaDao.consultarPersona(documento);
			return p;

		} catch (Exception e) {
			return null;

		}

	}
	
	public String registrarMascota(Mascota m) {
		System.out.println(m);
		String resultado = "";
		try {
			resultado = miMascotaDao.registrarMascota(m);
		} catch (Exception e) {
			System.out.println("errror: "+e);
		}
		return resultado;

	}
	public List<Persona> consultarPersonas() {
		try {
			List<Persona> listapersonas = miPersonaDao.consultarListaPersonas();
			return listapersonas;
		} catch (Exception e) {
			return null;
		}
	}
	
	public Mascota buscarMascota(Long idMacota) {
		Mascota m;
		try {
			m = miMascotaDao.consultarMascota(idMacota);

		} catch (Exception e) {
			m = null;
		}
		return m;
	}
	
	public String eliminarMascota(Mascota m) {
		String em = null;
		try {
			em = miMascotaDao.eliminarMascota(m);
		} catch (Exception e) {
			em = "error";
		}

		return em;
	}
	public String actualizarMascota(Mascota miMascota) {
		String r = null;
		try {
			r = miMascotaDao.actualizarMascota(miMascota);
			r = "ok";
			System.out.println(miMascota);
		} catch (Exception e) {
			r = "ERROR";
			miMascota = null;
		}
		return r;
	}
	
	public List<Mascota> consultarMascotas() {
		System.out.println("buscando lista de mascotas");
		try {
			List<Mascota> listaMascota = miMascotaDao.consultarListaMascotas();
			System.out.println(listaMascota);
			return listaMascota;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	public List<Mascota> consultarPorsexo(String m) {
		System.out.println("buscando lista de mascotas");
		try {
			List<Mascota> listaMascota = miMascotaDao.consultarListaMascotasPorSexo(m);
			System.out.println(listaMascota);
			return listaMascota;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	public String registrarProductos(Producto p) {
		String registrar = "";
		try {

			registrar = miProductoDao.registrarProducto(p);

		} catch (Exception e) {
			registrar = "NO SE HA REGISTRADO";
		}
		return registrar;

	}
	public Producto buscarProducto(Long idProducto) {
		Producto p;
		try {
			p = miProductoDao.consultarProducto(idProducto);

		} catch (Exception e) {
			p = null;
		}
		return p;
	}

	public String eliminarProducto(Producto p) {
		String em = null;
		try {
			em = miProductoDao.eliminarProducto(p);

		} catch (Exception e) {
			System.out.println("error en el proceso");
		}

		return em;
	}
	
	public String comprarProduct(PersonasProductos p) {
		return miProductoDao.registrarCompra(p);
		
	}
	
	public String actualizarProducto(Producto miProducto) {
		String r = "";
		try {
			r = miProductoDao.actualizarProducto(miProducto);
			
			System.out.println(miProducto);
		} catch (Exception e) {
			r = "ERROR";
			
		}
		return r;
	}

/**
	
		
	
	
	

	

	public long registrarNacimiento(Nacimiento n) {
		Long f = null;
		try {

			f = miNacimientoDao.registrarNacimiento(n);
		} catch (Exception e) {
			f = null;
		}
		return f;
	}

	

	

	public PersonaVo buscarPersona(long documento) {

		try {
			PersonaVo p = miPersonaDao.consultarPersona(documento);
			return p;

		} catch (Exception e) {
			return null;

		}

	}

	

	

	

	
	

	

	

	

	public String eliminarProductoPersona(Long id_persona) {
		String validar = "";
		try {
			validar = miPersonaProductoDao.borrarProductosPersona(id_persona);
			System.out.println(validar);
		} catch (Exception e) {
			validar = "error con eliminar persona producto dao";
		}
		return validar;
	}

	public PersonasProductosVo buscarPersonaProducto(Long id_persona) {
		PersonasProductosVo p = null;
		try {
			p = miPersonaProductoDao.consultarPersonasProductos(id_persona);

		} catch (Exception e) {
			System.out.println("Error en cordinador");

		}
		return p;
	}
	
	public PersonasProductosVo buscarPersonaPro(Long id_producto) {
		PersonasProductosVo p = null;
		try {
			p = miPersonaProductoDao.consultarPersonaproducto(id_producto);

		} catch (Exception e) {
			System.out.println("Error en cordinador");

		}
		return p;
	}

	public String eliminarProduct(Long id_persona) {
		String em = "";
		try {
			em = miProductoDao.borrarProduct(id_persona);

		} catch (Exception e) {
			System.out.println("error en el proceso");
		}

		return em;
	}

	public String actualizarNacimiento(Nacimiento encontradoNacimiento) {
		String encontrado = "";
		try {
			encontrado = miNacimientoDao.actualizarNacimiento(encontradoNacimiento);
		} catch (Exception e) {
			System.out.println("error al actualizar el nacimiento");
		}
		return encontrado;
	}



	public ArrayList<PersonaVo> consultarPersonas() {
		try {
			ArrayList<PersonaVo> LISTApersonas = miPersonaDao.consultarListaPersona();
			return LISTApersonas;
		} catch (Exception e) {
			return null;
		}
	
	}

	
	public ArrayList<Nacimiento> consultarNacimiento() {
		try {
			ArrayList<Nacimiento> listaN = miNacimientoDao.consultarListaNacimientos();
			return listaN;
		} catch (Exception e) {
			return null;
		}
		
	}
	
	public ProductoVo bucarProductoID(Long idProducto) {
		ProductoVo p=null;
		System.out.println("++++++++++"+idProducto);
		try {
			p = miProductoDao.consultarProductoId(idProducto);
			System.out.println("error al encontrar el producto: "+p);
		} catch (Exception e) {
			p = null;
			System.out.println("EEerror al encontrar el producto: "+p);
		}
		return p;
	}
	
	
	public String eliminarMascotaNo(String nombre) {
		String em = "";
		try {
			em = miMascotaDao.borrarMascotaN(nombre);
		} catch (Exception e) {
			em = "error";
		}
		return em;
	}

	
	**/
	public String actualizaPersona(Persona encontrado) {
		String resultado = "";
		try {
			resultado = miPersonaDao.actualizarPersona(encontrado);
		} catch (Exception e) {
			resultado = "error en cordinador al actualizar";
		}
		return resultado;
	}
	
	
	public String eliminarPersona(Persona p) {
		String validar = "";
		try {
			validar = miPersonaDao.eliminarPersona(p);
			System.out.println(validar);
		} catch (Exception e) {
			validar = "error al eliminar personavo";
		}
		return validar;
	}

	public void mostrarVentanaConsultarProductos() {
		miVentanaConsultarProductos.setVisible(true);
		
	}

	public List<Producto> consultarProductos() {
		
		return miProductoDao.consultarListaProductos();
	}

	public void cerrar() {
		 miProductoDao.close();
		
	}
	
	public void cerrarPersonaDao() {
		 miPersonaDao.close();;
	}

	
}
