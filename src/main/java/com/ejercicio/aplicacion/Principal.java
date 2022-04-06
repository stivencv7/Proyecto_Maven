package com.ejercicio.aplicacion;

import javax.swing.JOptionPane;

import com.ejercicio.controlador.Relaciones;
import com.google.protobuf.TextFormat.ParseException;

import clases.GestionMascota;
import clases.GestionPersonas;
import clases.GestionProducto;

public class Principal {

	public static void main(String[] args) throws Exception{
		
	Relaciones misRelaciones = new Relaciones();
		
		
		
		/**
		String menu = "Menu De Opciones\n\n";
		menu += "1. Gestionar Personas\n";
		menu += "2. Gestionar Mascotas\n";
		menu += "3. Gestionar Productos\n";
		menu += "4. Salir\n\n";

		int opc = 0;

		while (opc != 3) {
			opc = Integer.parseInt(JOptionPane.showInputDialog(menu));

			switch (opc) {
			case 1:new GestionPersonas();break;
			case 2:new GestionMascota();break;
			case 3:new GestionProducto();break;
			}
		}
	**/
	}

}
