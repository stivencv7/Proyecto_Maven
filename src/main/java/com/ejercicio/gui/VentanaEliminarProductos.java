package com.ejercicio.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import com.ejercicio.controlador.Coordinador;
import com.ejercicio.entidades.Persona;
import com.ejercicio.entidades.PersonasProductos;
import com.ejercicio.entidades.Producto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaEliminarProductos extends JDialog implements ActionListener {

	private JPanel contentPane = new JPanel();
	private JLabel nombre, precio, etiNombre, etiPrecio, etiId;
	private JTextField txtNombre, txtPrecio, txtNombre2, txtIdProducto;
	private JButton btnEliminarP, btnBuscar, btnComprar, btnaCancelar;
	private Coordinador miCoordinador;

	public VentanaEliminarProductos() {
		setSize(412, 400);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());

		setTitle("Eliminar y Venta");
		iniciarComponentes();
	}

	private void iniciarComponentes() {
		getContentPane().add(contentPane, BorderLayout.CENTER);
		contentPane.setLayout(null);

		JLabel lblTitulo = new JLabel("Elimminar Producto");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
		lblTitulo.setBounds(10, 10, 372, 28);
		contentPane.add(lblTitulo);

		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBounds(10, 49, 380, 200);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel documento = new JLabel("ID_Producto");
		documento.setBounds(24, 11, 71, 21);
		panel.add(documento);

		txtIdProducto = new JTextField();
		txtIdProducto.setBounds(100, 11, 100, 20);
		panel.add(txtIdProducto);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(24, 50, 71, 21);
		panel.add(lblNombre);

		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setEditable(false);
		;
		txtNombre.setBounds(88, 50, 86, 20);
		panel.add(txtNombre);

		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(214, 50, 71, 21);
		panel.add(lblPrecio);

		txtPrecio = new JTextField();
		txtPrecio.setColumns(10);
		txtPrecio.setEditable(false);
		txtPrecio.setBounds(269, 50, 86, 20);
		panel.add(txtPrecio);

		JSeparator separator = new JSeparator();
		separator.setBounds(24, 95, 331, 12);
		panel.add(separator);

		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(this);
		btnBuscar.setBounds(271, 11, 89, 23);
		panel.add(btnBuscar);

		btnComprar = new JButton("Comprar");
		btnComprar.addActionListener(this);
		btnComprar.setBounds(160, 120, 97, 23);
		btnComprar.setEnabled(false);
		panel.add(btnComprar);

		btnEliminarP = new JButton("Eliminar");
		btnEliminarP.addActionListener(this);
		btnEliminarP.setBounds(50, 120, 89, 23);
		btnEliminarP.setEnabled(false);
		panel.add(btnEliminarP);

		btnaCancelar = new JButton("Cancelar");
		btnaCancelar.addActionListener(this);
		btnaCancelar.setBounds(271, 120, 89, 23);
		btnaCancelar.setEnabled(false);
		panel.add(btnaCancelar);

	}

	
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnEliminarP) {

			Producto p = miCoordinador.buscarProducto(Long.parseLong(txtIdProducto.getText()));
			System.out.println("JJJ" + p);

			
			String respuesta = miCoordinador.eliminarProducto(p);

			if (respuesta.equals("Producto Eliminado")) {
				JOptionPane.showMessageDialog(null, "Producto eliminado exitosamente");
			} else {
				JOptionPane.showMessageDialog(null, "No se ha eliminado, Ha ocurrido un error");
			}

		} else if (e.getSource() == btnBuscar) {

			try {

				Producto miProducto = miCoordinador.buscarProducto(Long.parseLong(txtIdProducto.getText()));
				if (miProducto != null) {
					txtIdProducto.setEnabled(false);
					txtNombre.setText(miProducto.getNombreProducto());
					txtPrecio.setText(String.valueOf(miProducto.getPrecioProducto()));
					btnComprar.setEnabled(true);
					btnEliminarP.setEnabled(true);
					btnaCancelar.setEnabled(true);

				} else {
					JOptionPane.showMessageDialog(null, "Confirme si el ID del  producto existe ");

				}
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "Verifique el campo ID del producto y vuelva a intentarlo ");
			}

		} else if (e.getSource() == btnComprar) {
			Long id = Long
					.parseLong(JOptionPane.showInputDialog("Ingrese el id de la persona que va a comprar el producto"));
			Persona p = miCoordinador.buscarPersona(id);
			if (p != null) {
				
				PersonasProductos persona_Prod= new PersonasProductos();

				persona_Prod.setPersonaId(id);
				persona_Prod.setProductoId(Long.parseLong(txtIdProducto.getText()));
				
				Producto miProducto= miCoordinador.buscarProducto(persona_Prod.getProductoId());
				Persona miPersona = miCoordinador.buscarPersona(persona_Prod.getPersonaId());
				
				miProducto.getListaPersonas().add(miPersona);
				miPersona.getListaProductos().add(miProducto);
				String compra=miCoordinador.comprarProduct(persona_Prod);
				
				if(compra.equalsIgnoreCase("ok")) {
				
				
					JOptionPane.showMessageDialog(null, "La compra se ha hecho con exito");
				
				txtIdProducto.setEnabled(true);
				txtNombre.setText("");
				txtPrecio.setText("");
				btnComprar.setEnabled(true);
				btnEliminarP.setEnabled(true);
				btnaCancelar.setEnabled(false);
				}

			} else {
				JOptionPane.showMessageDialog(null, "Error",
						"Verifique que la persona este registrada en la base de datos", JOptionPane.ERROR_MESSAGE);
			}
		} else if (e.getSource() == btnaCancelar) {
			txtIdProducto.setText("");
			txtIdProducto.setEnabled(true);
			txtNombre.setText("");
			txtPrecio.setText("");
			btnaCancelar.setEnabled(false);
			btnComprar.setEnabled(false);
			btnEliminarP.setEnabled(false);

		}

	}

	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador = miCoordinador;
	}

}

