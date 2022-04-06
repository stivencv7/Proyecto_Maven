package com.ejercicio.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;

import com.ejercicio.controlador.Coordinador;
import com.ejercicio.entidades.Mascota;
import com.ejercicio.entidades.Persona;
import com.ejercicio.entidades.Producto;

public class VentanaConsultarProductos extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTable tablaPersonas;
	private JButton btnConsultarProductos,btnActualizar;
	private Coordinador miCoordinador;
	private JScrollPane scroll;
	private JTextField txtImprimir;
	private JTextArea area;
	private JList produc;
	
	
	public VentanaConsultarProductos()  {
		
		setTitle("Consultar Productos");
		setSize(812,365);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
	//	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnConsultarProductos = new JButton("Consultar Productos");
		btnConsultarProductos.setBounds(478, 21, 170, 40);
		btnConsultarProductos.addActionListener(this);
		contentPane.add(btnConsultarProductos);
		
		area = new JTextArea();
		area.setFont(new Font("arial", 3, 15));
		area.setEditable(false);

		btnActualizar = new JButton("Actualizar Lista");
		btnActualizar.setBounds(20, 21, 170, 40);
		btnActualizar.addActionListener(this);
		btnActualizar.setEnabled(false);
		contentPane.add(btnActualizar);

		
		
		scroll = new JScrollPane (area);
		scroll.setBounds(10, 99, 776, 174);
		contentPane.add(scroll);
		
	}

	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnConsultarProductos) {
			try {
			List<Producto> lista = miCoordinador.consultarProductos();
			//Lista(lista);
			area.setText(""+lista);
			btnConsultarProductos.setEnabled(false);
			btnActualizar.setEnabled(true);
			
		
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(area, "Ocurrio un error");
			System.out.println(e2);
		}
		}if (e.getSource() == btnActualizar) {
			
			List<Producto> lista = miCoordinador.consultarProductos();
			//Lista(lista);
			area.setText("");
			btnConsultarProductos.setEnabled(true);
			btnActualizar.setEnabled(false);
		}
	

}
	
	/**
	
	public void Lista(List<Producto> producto) {
		String titulos [] = {"ID", "Nombre", "Presio","lista Personas"};
		System.out.println(producto.size());
		//System.out.println(n.size());
		int celdas;
		if (producto.size()>15) {
			celdas=14;
		} else {
			celdas = producto.size(); 
		}
		
		String cuadro [] [] = new String[celdas][4];
		
		if (producto.size()>0) {
			System.out.println("hola");
	
			ListModel j;
			int i=0;
			
			//for (int i = 0; i < producto.size(); i++) {
			while (i<producto.size()) {
				for (Producto produ : producto) {
					
					
					
				for (int p = 0;  p<producto.size(); p++) {				
				
				cuadro[i][0] = producto.get(i).getIdProducto()+"";
				cuadro[i][1] = producto.get(i).getNombreProducto();
				cuadro[i][2] = producto.get(i).getPrecioProducto()+"";
				cuadro[i][3] =(producto.get(i).retornarPersona(producto.get(i).getListaPersonas()));
				
				i++;
				}
				break;
				}
				
			}
			
			System.out.println("este es j: ");
			
			
		}else {
			cuadro = new String [14][9];
			
		}
		
		tablaPersonas = new JTable (cuadro,titulos);
		scroll.setViewportView(tablaPersonas);
		
		
		
	}
	**/
	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador= miCoordinador;
	}
}

