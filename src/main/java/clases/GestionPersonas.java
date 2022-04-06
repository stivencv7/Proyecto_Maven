package clases;

import java.awt.Label;
import java.time.LocalDate;
import java.util.List;

import javax.swing.JOptionPane;

import com.ejercicio.dao.PersonaDao;
import com.ejercicio.entidades.Mascota;
import com.ejercicio.entidades.Nacimiento;
import com.ejercicio.entidades.Persona;

public class GestionPersonas {
	
	PersonaDao miPersonaDao=new PersonaDao();
	
	public GestionPersonas(){
	
	String menu= "MENU DE OPCIONES - GESTION MASCOTAS\n\n";
	menu += "1. Registrar Persona\n";
	menu += "2. Consultar Persona\n";
	menu += "3. Consultar Lista de Personas\n";
	menu += "4. Actualizar Persona\n";
	menu += "5. Eliminar Persona\n";
	menu += "6. Salir\n";

	int opc = 0;
	while (opc != 6) {
		opc=Integer.parseInt(JOptionPane.showInputDialog(menu));
		switch (opc) {
		case 1:registrar(); break;
		case 2:consultar(); break;
		case 3:consultarLista(); break;
		case 4:actualizarNombre(); break;
		case 5:eliminar(); break;
		case 6:miPersonaDao.close();break;
}
}
}
	private void registrar() {
		Persona miPersona=new Persona();
		miPersona.setIdPersona(Long.parseLong(JOptionPane.
				showInputDialog("ingrese el documento de la persona")));
		miPersona.setNombre(JOptionPane.showInputDialog("Ingrese el nombre de la Persona"));
		miPersona.setTelefono(JOptionPane.showInputDialog("Ingrese el Telefono de la Persona"));
		miPersona.setProfesion(JOptionPane.showInputDialog("Ingrese la profesion de la persona "));
		miPersona.setTipo(Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tipo de la Persona")));
		
		miPersona.setNacimiento(obtenerDatosNacimiento());
		
		int opc=0;
		do {
			opc=Integer.parseInt(JOptionPane.showInputDialog("Desea Registrar una Mascota?"+"\n1. SI\n2.NO"));
			if(opc==1) {
				Mascota miMascota=new Mascota();
				miMascota.setIdMascorta(null);
				miMascota.setNombre(JOptionPane.showInputDialog("Ingrese el nombre de la mascota"));
				miMascota.setRaza(JOptionPane.showInputDialog("Ingrese la Raza de la mascota"));
				miMascota.setColorMascota(JOptionPane.showInputDialog("Ingrese el color de la mascota"));
				miMascota.setSexo(JOptionPane.showInputDialog("Ingrese el sexo de la mascota"));
				miMascota.setDuenio(miPersona);
				
				miPersona.getListaMascotas().add(miMascota);
			}
		}while (opc!=2);
		
		System.out.println(miPersonaDao.registrarPersona(miPersona));
		System.out.println();
	}
	
	private Nacimiento obtenerDatosNacimiento() {
		int dia=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el Dia de Nacimiento"));
		int mes=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el Mes de Nacimiento"));
		int anio=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el Año de Nacimiento"));
		Nacimiento datosNacimiento=new Nacimiento();
		datosNacimiento.setIdNacimiento(null);
		datosNacimiento.setFechaNacimiento(LocalDate.of(anio, mes,dia));
		datosNacimiento.setCiudadNacimiento(JOptionPane.showInputDialog("Ingrese la ciudad de nacimmiento"));
		datosNacimiento.setDepartamentoNacimiento(JOptionPane.showInputDialog("Ingrese el Departamento de nacimiento"));
		datosNacimiento.setPaisNacimieno(JOptionPane.showInputDialog("Ingrese el Pais de nacimiento"));
		
		
	
		return datosNacimiento;
	}
	
	private void consultar() {
		Long idPersona=Long.parseLong(JOptionPane.showInputDialog("Ingrese el id de la persona"));
	
	Persona miPersona=miPersonaDao.consultarPersona(idPersona);
	
	if(miPersona!=null) {
		System.out.println(miPersona);
		System.out.println();
	}else {
		System.out.println();
		System.out.println("No se encontro la Persona");
	}
	System.out.println();
	
	}
	
	private  void consultarLista() {
		System.out.println("Lista de Personas");
		List<Persona>listaPersonas=miPersonaDao.consultarListaPersonas();
		
		for(Persona persona:listaPersonas) {
			System.out.println(persona);
		}
	}
	
	private void actualizarNombre() {
		Long idPersona=Long.parseLong(JOptionPane.showInputDialog("Ingrese el id de la persona para actualizar su nombre"));
		Persona miPersona=miPersonaDao.consultarPersona(idPersona);
		if(miPersona!=null) {
			System.out.println(miPersona);
			System.out.println();
			miPersona.setNombre(JOptionPane.showInputDialog("Ingese el nombre de la persona"));
			int opc=0;
			do {
				opc=Integer.parseInt(JOptionPane.showInputDialog("Desea Registrar una Mascota?"+"\n1. SI\n2.NO"));
				if(opc==1) {
					Mascota miMascota=new Mascota();
					miMascota.setIdMascorta(null);
					miMascota.setNombre(JOptionPane.showInputDialog("Ingrese el nombre de la mascota"));
					miMascota.setRaza(JOptionPane.showInputDialog("Ingrese la Raza de la mascota"));
					miMascota.setColorMascota(JOptionPane.showInputDialog("Ingrese el color de la mascota"));
					miMascota.setSexo(JOptionPane.showInputDialog("Ingrese el sexo de la mascota"));
					miMascota.setDuenio(miPersona);
					
					miPersona.getListaMascotas().add(miMascota);
				}
			}while (opc!=2);
			System.out.println(miPersonaDao.actualizarPersona(miPersona));
			System.out.println();
		}else {
			System.out.println();
			System.out.println("No se encontro la Persona");
		}
		System.out.println();
	}
	
	private void eliminar() {
		Long idPersona=Long.parseLong(JOptionPane.showInputDialog("Ingrese el id de la persona para eliminar"));
		Persona miPersona=miPersonaDao.consultarPersona(idPersona);
		if(miPersona!=null) {
			System.out.println(miPersona);
			System.out.println();
		
			System.out.println(miPersonaDao.eliminarPersona(miPersona));
			System.out.println();
		}else {
			System.out.println();
			System.out.println("No se encontro la Persona");
		}
		System.out.println();
	}
	
	
}

