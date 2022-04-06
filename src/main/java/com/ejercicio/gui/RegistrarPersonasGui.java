package com.ejercicio.gui;



import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import com.ejercicio.controlador.Coordinador;
import com.ejercicio.dao.PersonaDao;
import com.ejercicio.entidades.Nacimiento;
import com.ejercicio.entidades.Persona;

//import VO.Nacimiento;
//import VO.PersonaVo;
//import controlador.Coordinador;

import javax.swing.JSeparator;



public class RegistrarPersonasGui extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtDocumento;
	private JTextField txtNombre;
	private JTextField txtTelefono;
	private JTextField txtProfesion;
	private JTextField txtTipo;
	private JTextField txtDia;
	private JTextField txtMes;
	private JTextField txtAnio;
	private JTextField txtCiudad;
	private JTextField txtDepartamento;
	private JTextField txtPais;
	private JButton btnAgregarMascotas;
	private JButton btnCancelar;
	private JButton btnRegistrar;
	private Coordinador miCoordinador;
	MaskFormatter mascara1, mascara2, mascara3;
	Nacimiento miNacimiento;
	
	/**
	 * Create the dialog.
	 * 
	 * @param b
	 * @param ventanaPrincipal
	 * @throws ParseException
	 */
	public RegistrarPersonasGui(VentanaPrincipal ventanaPrincipal, boolean modal) throws ParseException {
		super(ventanaPrincipal, modal);
		setSize(624, 423);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		iniciarComponentes();
		setTitle("Gestion de Personas");

	}

	private void iniciarComponentes() throws ParseException {
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblTitulo = new JLabel("GESTIONAR PERSONAS");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
		lblTitulo.setBounds(10, 10, 599, 28);
		contentPanel.add(lblTitulo);

		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBounds(10, 49, 588, 324);
		contentPanel.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Documento:");
		lblNewLabel.setBounds(24, 22, 71, 21);
		panel.add(lblNewLabel);

		txtDocumento = new JTextField();
		txtDocumento.setBounds(99, 22, 86, 20);
		panel.add(txtDocumento);
		txtDocumento.setColumns(10);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(195, 22, 71, 21);
		panel.add(lblNombre);

		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(259, 22, 303, 20);
		panel.add(txtNombre);

		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setBounds(24, 54, 71, 21);
		panel.add(lblTelefono);

		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(99, 54, 86, 20);
		panel.add(txtTelefono);

		JLabel lblProfesion = new JLabel("Profesion:");
		lblProfesion.setBounds(195, 54, 71, 21);
		panel.add(lblProfesion);

		txtProfesion = new JTextField();
		txtProfesion.setColumns(10);
		txtProfesion.setBounds(259, 54, 167, 20);
		panel.add(txtProfesion);

		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(439, 54, 71, 21);
		panel.add(lblTipo);

		txtTipo = new JTextField();
		txtTipo.setColumns(10);
		txtTipo.setBounds(476, 54, 86, 20);
		panel.add(txtTipo);

		JPanel panelNacimiento = new JPanel();
		panelNacimiento.setBorder(
				new TitledBorder(null, "Datos de Nacimiento", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelNacimiento.setBounds(24, 99, 538, 109);
		panel.add(panelNacimiento);
		panelNacimiento.setLayout(null);

		JLabel lblFecha = new JLabel("Fecha (dd/mm/aaaa):");
		lblFecha.setBounds(10, 29, 122, 14);
		panelNacimiento.add(lblFecha);

		try {
			mascara1 = new MaskFormatter("##");
			mascara2 = new MaskFormatter("##");
			mascara3 = new MaskFormatter("####");

		} catch (Exception e) {
			// TODO: handle exception
		}

		txtDia = new JTextField();
		txtDia.setBounds(142, 28, 25, 20);
		panelNacimiento.add(txtDia);
		txtDia.setColumns(10);

		txtMes = new JTextField();
		txtMes.setColumns(10);
		txtMes.setBounds(190, 28, 25, 20);
		panelNacimiento.add(txtMes);

		txtAnio = new JTextField();
		txtAnio.setColumns(10);
		txtAnio.setBounds(238, 28, 54, 20);
		panelNacimiento.add(txtAnio);

		JLabel lblNewLabel_1 = new JLabel("/");
		lblNewLabel_1.setBounds(177, 31, 38, 14);
		panelNacimiento.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("/");
		lblNewLabel_1_1.setBounds(224, 31, 38, 14);
		panelNacimiento.add(lblNewLabel_1_1);

		JLabel lblCiudad = new JLabel("Ciudad:");
		lblCiudad.setBounds(10, 59, 71, 21);
		panelNacimiento.add(lblCiudad);

		txtCiudad = new JTextField();
		txtCiudad.setColumns(10);
		txtCiudad.setBounds(74, 59, 86, 20);
		panelNacimiento.add(txtCiudad);

		JLabel lblDepartamento = new JLabel("Departamento:");
		lblDepartamento.setBounds(185, 59, 92, 21);
		panelNacimiento.add(lblDepartamento);

		txtDepartamento = new JTextField();
		txtDepartamento.setColumns(10);
		txtDepartamento.setBounds(281, 59, 86, 20);
		panelNacimiento.add(txtDepartamento);

		JLabel lblPais = new JLabel("Pais:");
		lblPais.setBounds(385, 59, 54, 21);
		panelNacimiento.add(lblPais);

		txtPais = new JTextField();
		txtPais.setColumns(10);
		txtPais.setBounds(424, 59, 86, 20);
		panelNacimiento.add(txtPais);

		btnAgregarMascotas = new JButton("Agregar Mascotas");
		btnAgregarMascotas.setBounds(364, 219, 190, 23);
		btnAgregarMascotas.addActionListener(this);
		panel.add(btnAgregarMascotas);

		JSeparator separator = new JSeparator();
		separator.setBounds(24, 253, 538, 12);
		panel.add(separator);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(463, 276, 89, 23);
		btnCancelar.addActionListener(this);
		panel.add(btnCancelar);

		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(364, 276, 89, 23);
		btnRegistrar.addActionListener(this);
		panel.add(btnRegistrar);
	}

	
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == btnAgregarMascotas) {
			try {
				RegistrarMascotasGui ventanaGestionMascotas = new RegistrarMascotasGui(null, true, txtDocumento.getText());
				miCoordinador.setRegistrarMascotasGui(ventanaGestionMascotas);
				ventanaGestionMascotas.setCoordinador(miCoordinador);
				ventanaGestionMascotas.setVisible(true);
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "A ocurrido un error");
			}
			

			
		}

			if (e.getSource() == btnRegistrar) {
				try {
					registrar();
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "A ocurrido un error");
				}
				
				
			}
	}
	
	public void registrar() {
		

		Persona miPersona = new Persona();
	
		miPersona.setIdPersona(Long.parseLong(txtDocumento.getText()));
		miPersona.setNombre(txtNombre.getText());
		miPersona.setTelefono(txtTelefono.getText());
		miPersona.setTipo(Integer.parseInt(txtTipo.getText()));
		miPersona.setProfesion(txtProfesion.getText());
		miPersona.setNacimiento(miNacimiento);
		Persona p = miCoordinador.buscarPersona(miPersona.getIdPersona());
		
		miPersona.setNacimiento(obtenerDatosNacimiento());
		
		if (p == null) {
			
			String respuesta = miCoordinador.registrarPersonas(miPersona);
			System.out.println("eta persona es: "+miPersona);
			JOptionPane.showMessageDialog(null, "Registro exitoso");
			txtMes.setText("");
			txtAnio.setText("");
			txtDia.setText("");
			
		} else {

			JOptionPane.showMessageDialog(null, "El Numero de Documento ya Existe ");
		}
	}

	private Nacimiento obtenerDatosNacimiento() {
		miNacimiento = new Nacimiento();

		LocalDate date = LocalDate.of(Integer.parseInt(txtAnio.getText()), Integer.parseInt(txtMes.getText()),
				Integer.parseInt(txtDia.getText()));
		miNacimiento.setCiudadNacimiento(txtCiudad.getText());
		miNacimiento.setDepartamentoNacimiento(txtDepartamento.getText());
		miNacimiento.setFechaNacimiento(date);
		miNacimiento.setPaisNacimieno(txtPais.getText());

		
		miNacimiento.setIdNacimiento(null);
		
		
	
		return miNacimiento;
	}
	
	
	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador = miCoordinador;
	}
	
}

