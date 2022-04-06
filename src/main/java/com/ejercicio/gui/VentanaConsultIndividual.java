package com.ejercicio.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.ejercicio.controlador.Coordinador;
import com.ejercicio.dao.PersonaDao;
import com.ejercicio.entidades.Nacimiento;
import com.ejercicio.entidades.Persona;

public class VentanaConsultIndividual extends JDialog implements ActionListener {

	private JTextField txtDocumento;
	private JButton btnConsultar, btnEliminarPersona;
	private JPanel panel;
	private JTextArea area;
	private JScrollPane scroll;

	Coordinador miCoordinador;

	public VentanaConsultIndividual() {
		setSize(624, 423);
		setLayout(null);
		setTitle("Consulta y eliminacion persona");
		setLocationRelativeTo(null);
		iniciarComponentes();

	}

	public void iniciarComponentes() {

		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setLayout(null);

		setContentPane(panel);

		JLabel etiDocumento = new JLabel("Documento");
		etiDocumento.setBounds(100, 40, 150, 24);

		panel.add(etiDocumento);

		txtDocumento = new JTextField();
		txtDocumento.setBounds(230, 40, 150, 24);
		panel.add(txtDocumento);

		btnConsultar = new JButton("Buscar");
		btnConsultar.setBounds(400, 40, 100, 24);
		btnConsultar.addActionListener(this);
		panel.add(btnConsultar);

		btnEliminarPersona = new JButton("Eliminar");
		btnEliminarPersona.setBounds(100, 310, 100, 24);
		btnEliminarPersona.setEnabled(false);
		btnEliminarPersona.addActionListener(this);
		panel.add(btnEliminarPersona);

		area = new JTextArea();
		area.setFont(new Font("arial", 3, 15));
		area.setEditable(false);

		scroll = new JScrollPane(area);
		scroll.setBounds(100, 100, 350, 200);
		panel.add(scroll);

	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnConsultar) {
			try {
				
			
			Persona p = miCoordinador.buscarPersona(Long.parseLong(txtDocumento.getText()));
			System.out.println("bventana consul: "+p);
			if (p != null) {
				area.setText("\tDATOS DE LA PESONA\n\n" + p);
				btnEliminarPersona.setEnabled(true);
			}else {
				JOptionPane.showMessageDialog(null, "Compruebe el Numero de Documento");
			}
			
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "Error verifique el campo");
			}
		} else if (e.getSource() == btnEliminarPersona) {

			Persona p = miCoordinador.buscarPersona(Long.parseLong(txtDocumento.getText()));
			System.out.println(p);
			String respuesta = miCoordinador.eliminarPersona(p);

		}
	}

	
	


	public void setMiCoordinador(Coordinador miCoordinador) {
		this.miCoordinador = miCoordinador;
	}

}
