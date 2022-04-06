package com.ejercicio.controlador;

import org.hibernate.tool.schema.ast.SqlScriptParserException;

import com.ejercicio.dao.MascotaDao;
import com.ejercicio.dao.PersonaDao;
import com.ejercicio.dao.ProductoDao;
import com.ejercicio.entidades.Persona;
import com.ejercicio.entidades.Producto;
import com.ejercicio.gui.*;
import com.google.protobuf.TextFormat.ParseException;

public class Relaciones {
	
	
	public Relaciones() throws Exception{
	
	
	//Se declaran las clases que van a representar instancias unicas
		
	
		VentanaPrincipal miVentanaPrincipal;
		Coordinador miCoordinador;
		RegistrarPersonasGui miRegistrarPersonasGui;
		RegistrarMascotasGui miRegistrarMascotasGui;
		PersonaDao miPersonaDao;
		MascotaDao miMascotaDao;
		VentanaConsultIndividual miVentanaConsultIndividual;
		VentanaActualizarPersona miVentanaActualizarPersona;
		ConsultarPersonas consultarPersonas;
		VentanaEliminar miVentanaEliminar;
		VentanaActualizarMascota actualizarMascota;
		VentanaConsultarMascotas miConsultarMascotas;
		RegistrarProductosGui miRegistrarProductosGui;
		ProductoDao miProductoDao;
		VentanaEliminarProductos miVentanaEliminarP;
		VentanaActalizarProducto miVentanaActalizarProducto;
		VentanaConsultarProductos miVentanaConsultarProductos;
		
	/**
			
			
			
			
			
			
			
			**/
			
			//Se instancian por unica ocasión las clases declaradas
			
			miVentanaPrincipal= new VentanaPrincipal();
			miRegistrarPersonasGui= new RegistrarPersonasGui(miVentanaPrincipal, true);
			miRegistrarMascotasGui= new RegistrarMascotasGui(miVentanaPrincipal, true,"");
			miVentanaConsultIndividual=new VentanaConsultIndividual();
			miVentanaActualizarPersona=new VentanaActualizarPersona(miVentanaPrincipal,true);
			miCoordinador= new Coordinador();
			miPersonaDao= new PersonaDao();
			miMascotaDao= new MascotaDao();
			consultarPersonas = new ConsultarPersonas();
			miVentanaEliminar = new VentanaEliminar();
			actualizarMascota=new VentanaActualizarMascota(miVentanaPrincipal, true);
			miConsultarMascotas=new VentanaConsultarMascotas();
			miRegistrarProductosGui= new RegistrarProductosGui(miVentanaPrincipal, true);
			miProductoDao= new ProductoDao();
			miVentanaEliminarP = new VentanaEliminarProductos();	
			miVentanaActalizarProducto =new VentanaActalizarProducto(miVentanaPrincipal, true);
			miVentanaConsultarProductos=new VentanaConsultarProductos();
			
			//Se establece la relación entre el coordinador y cada instancia unica
			//Al coordinador se le asigna el control de cada clase unica
			
			miCoordinador.setVentanaPrincipal(miVentanaPrincipal);
			miCoordinador.setRegistrarPersonasGui(miRegistrarPersonasGui);
			miCoordinador.setPersonaDao(miPersonaDao);
			miCoordinador.setRegistrarMascotasGui(miRegistrarMascotasGui);
			miCoordinador.setMascotaDao(miMascotaDao);
			miCoordinador.setMiVentanaConsultIndividual(miVentanaConsultIndividual);
			miCoordinador.setMiVentanaActualizarPersona(miVentanaActualizarPersona);
			miCoordinador.setConsultarPersonas(consultarPersonas);
			miCoordinador.setVentanaEliminar(miVentanaEliminar);
			miCoordinador.setActualizarMascota(actualizarMascota);
			miCoordinador.setMiVentanaConsultarMascotas(miConsultarMascotas);
			miCoordinador.setRegistrarProductosGui(miRegistrarProductosGui);
			miCoordinador.setProductoDao(miProductoDao);
			miCoordinador.setVentanaEliminarP(miVentanaEliminarP);
			miCoordinador.setActalizarProducto(miVentanaActalizarProducto);
			miCoordinador.setMiVentanaConsultarProductos(miVentanaConsultarProductos);
			
			//A cada clase unica se le asigna la unica instancia del coordinador
			miVentanaPrincipal.setCoordinador(miCoordinador);
			miRegistrarPersonasGui.setCoordinador(miCoordinador);
			miPersonaDao.setCoordinador(miCoordinador);
			miRegistrarMascotasGui.setCoordinador(miCoordinador);
			miVentanaConsultIndividual.setMiCoordinador(miCoordinador);
			miVentanaActualizarPersona.setCoordinador(miCoordinador);
			consultarPersonas.setCoordinador(miCoordinador);
			miVentanaEliminar.setCoordinador(miCoordinador);
			actualizarMascota.setCoordinador(miCoordinador);
			miMascotaDao.setCoordinador(miCoordinador);
			miConsultarMascotas.setCoordinador(miCoordinador);
			miRegistrarProductosGui.setCoordinador(miCoordinador);
			miProductoDao.setCoordinador(miCoordinador);
			miVentanaEliminarP.setCoordinador(miCoordinador);
			miVentanaActalizarProducto.setCoordinador(miCoordinador);
			miVentanaConsultarProductos.setCoordinador(miCoordinador);
		
			/**
			
			
			
			
			
			
			
			
			
			
			
			

			//Se muestra la ventana principal.
			 * 
			 */
			miVentanaPrincipal.setVisible(true);
		}
		
}
