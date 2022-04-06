package com.ejercicio.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import com.ejercicio.controlador.Coordinador;
import com.ejercicio.entidades.Persona;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTabbedPane;

public class ConsultarPersonas extends JDialog implements ActionListener{

	private JPanel contentPane;
	private JTable tablaPersonas;
	private JButton btnConsultarPersonas;
	private Coordinador miCoordinador;
	private JScrollPane scroll;
	private JTextField txtImprimir;
	private JTextArea area;
	
	
	public ConsultarPersonas() {
		
		setTitle("Consultar Personas");
		setSize(812,365);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
	//	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnConsultarPersonas = new JButton("Consultar Personas");
		btnConsultarPersonas.setBounds(278, 21, 206, 40);
		btnConsultarPersonas.addActionListener(this);
		contentPane.add(btnConsultarPersonas);
		
		
		
		scroll = new JScrollPane ();
		scroll.setBounds(10, 99, 776, 174);
		contentPane.add(scroll);
		
	}

	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnConsultarPersonas) {
			try {
				
		
			List<Persona> lista = miCoordinador.consultarPersonas();
			//ArrayList<Nacimiento>listaNacimiento=miCoordinador.consultarNacimiento();
			
			
			Lista(lista);//,listaNacimiento);
		
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(area, "Ocurrio un error");
		}
		}
	}
	
	public void Lista(List<Persona> personas) {
		String titulos [] = {"Documento", "Nombre", "Profesion", "Telefono", "Tipo", "Ciudad", "Departamento", "Fecha nacimiento", "Pais"};
		System.out.println(personas.size());
		//System.out.println(n.size());
		int celdas;
		if (personas.size()>15) {
			celdas=14;
		} else {
			celdas = personas.size(); 
		}
		//Nacimiento n=miCoordinador.consultarNacimiento(personas.get(i).getNacimiento().getIdNacimiento());
		String cuadro [] [] = new String[celdas][9];
		
		if (personas.size()>0) {
			System.out.println("hola");
			for (int i = 0; i < personas.size(); i++) {
				
				cuadro[i][0] = personas.get(i).getIdPersona()+"";
				cuadro[i][1] = personas.get(i).getNombre();
				cuadro[i][2] = personas.get(i).getProfesion();
				cuadro[i][3] = personas.get(i).getTelefono();
				cuadro[i][4] = personas.get(i).getTipo()+"";
				cuadro[i][5] = personas.get(i).getNacimiento().getCiudadNacimiento();
				cuadro[i][6] = personas.get(i).getNacimiento().getDepartamentoNacimiento();
				cuadro[i][7] = personas.get(i).getNacimiento().getFechaNacimiento()+"";
				cuadro[i][8] = personas.get(i).getNacimiento().getPaisNacimieno();
			
			}
		}else {
			cuadro = new String [14][9];
			
		}
		
		tablaPersonas = new JTable (cuadro,titulos);
		scroll.setViewportView(tablaPersonas);
		
		
	}
	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador= miCoordinador;
	}
}

