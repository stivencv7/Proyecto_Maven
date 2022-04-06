package com.ejercicio.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;

import com.ejercicio.controlador.Coordinador;
import com.ejercicio.entidades.Mascota;
import com.ejercicio.entidades.Persona;

public class VentanaConsultarMascotas extends JDialog implements ActionListener {

	private JPanel contentPane;
	private JTable tablaPersonas;
	private JButton btnConsultarMascotas,btnconsultar;
	private Coordinador miCoordinador;
	private JScrollPane scroll;
	private JTextField txtImprimir;
	private JTextField txtSexo;
	private JTextArea area;
	
	
	public VentanaConsultarMascotas() {
		
		setTitle("Consultar Mascotas");
		setSize(812,365);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
	//	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnConsultarMascotas = new JButton("Consultar Mascotas");
		btnConsultarMascotas.setBounds(478, 21, 170, 40);
		btnConsultarMascotas.addActionListener(this);
		contentPane.add(btnConsultarMascotas);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(50, 22, 71, 23);
		
		contentPane.add(lblSexo);

		txtSexo = new JTextField();
		txtSexo.setColumns(10);
		txtSexo.setBounds(90, 22, 120, 23);
		contentPane.add(txtSexo);
		
		btnconsultar = new JButton("Consultar");
		btnconsultar.setBounds(212, 22, 90, 23);
		btnconsultar.addActionListener(this);
		contentPane.add(btnconsultar);
		
		scroll = new JScrollPane ();
		scroll.setBounds(10, 99, 776, 174);
		contentPane.add(scroll);
		
	}

	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnConsultarMascotas) {
			try {
			List<Mascota> lista = miCoordinador.consultarMascotas();
			Lista(lista);
		
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(area, "Ocurrio un error");
		}
		}
	
	else if (e.getSource() == btnconsultar) {
		try {
		List<Mascota> lista = miCoordinador.consultarPorsexo(txtSexo.getText());
		Lista(lista);
	
	} catch (Exception e2) {
		JOptionPane.showMessageDialog(area, "Ocurrio un error");
	}
	}

}
	
	
	
	public void Lista(List<Mascota> mascota) {
		String titulos [] = {"ID", "Nombre", "Color", "Raza", "Sexo","Dueño"};
		System.out.println(mascota.size());
		//System.out.println(n.size());
		int celdas;
		if (mascota.size()>15) {
			celdas=14;
		} else {
			celdas = mascota.size(); 
		}
		//Nacimiento n=miCoordinador.consultarNacimiento(personas.get(i).getNacimiento().getIdNacimiento());
		String cuadro [] [] = new String[celdas][6];
		
		if (mascota.size()>0) {
			System.out.println("hola");
			for (int i = 0; i < mascota.size(); i++) {
				
				cuadro[i][0] = mascota.get(i).getIdMascorta()+"";
				cuadro[i][1] = mascota.get(i).getNombre();
				cuadro[i][2] = mascota.get(i).getColorMascota();
				cuadro[i][3] = mascota.get(i).getRaza();
				cuadro[i][4] = mascota.get(i).getSexo();
				cuadro[i][5] = mascota.get(i).getDuenio().getNombre();
				
				
			
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
