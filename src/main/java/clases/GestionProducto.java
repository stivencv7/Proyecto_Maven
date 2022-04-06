package clases;

import java.util.List;

import javax.swing.JOptionPane;

import com.ejercicio.dao.ProductoDao;
import com.ejercicio.entidades.Mascota;
import com.ejercicio.entidades.Persona;
import com.ejercicio.entidades.PersonasProductos;
import com.ejercicio.entidades.Producto;

public class GestionProducto {
	
	ProductoDao miProductoDao=new ProductoDao();
	Persona p;
	public GestionProducto() {
		String menu= "MENU DE OPCIONES - GESTION PRODUCTOS\n\n";
		menu += "1. Registrar Producto\n";
		menu += "2. Consultar Producto\n";
		menu += "3. Consultar Lista Productos\n";
		menu += "4.	Comprar Producto\n";
		menu += "5. Actualizar Producto\n";
		menu += "6. Eliminar Producto\n";
		menu += "7. Salir\n";

		int opc = 0;
		while (opc != 7) {
			opc=Integer.parseInt(JOptionPane.showInputDialog(menu));
			switch (opc) {
			
			case 1:registrar();break;
			case 2:consultar(); break;
			case 3:consultarLista(); break;
			case 4:comprarProductos(); break;
			case 5:actualizar(); break;
			case 6:eliminar(); break;
			case 7:miProductoDao.close(); break;

			}

		}

	}
	
	
	
	private void registrar() {
		Producto miProducto=new Producto();
		miProducto.setIdProducto(null);
		miProducto.setNombreProducto(JOptionPane.showInputDialog("Ingrese el nombre del producto"));
		miProducto.setPrecioProducto(Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio del producto ")));
		
	
		
		System.out.println(miProductoDao.registrarProducto(miProducto));
		System.out.println();
	}

	
	private void consultar() {
		Long idProducto=Long.parseLong(JOptionPane.showInputDialog("Ingrese el id del producto"));
	
	Producto miProducto=miProductoDao.consultarProducto(idProducto);
	
	if(miProducto!=null) {
		System.out.println(miProducto);
		System.out.println();
	}else {
		System.out.println();
		System.out.println("No se encontro el producto");
	}
	System.out.println();
	
	}
	
	private  void consultarLista() {
		System.out.println("Lista de Productos");
		List<Producto>listaProductos=miProductoDao.consultarListaProductos();
		
		for(Producto producto:listaProductos) {
			
			System.out.println(producto);
		
					}
	}
	
	public void comprarProductos() {
		PersonasProductos producto;
		
		Long personaId;
		Long productoId;
		int opc=0;
		
		do {
			producto=new PersonasProductos();
			personaId=Long.parseLong(JOptionPane.showInputDialog("Ingrese"+
						"el documento de la persona"));
			productoId=Long.parseLong(JOptionPane.showInputDialog("Ingrese"+
					"el codigo del producto"));
			
			producto.setPersonaId(personaId);
			producto.setProductoId(productoId);
			
			System.out.println(miProductoDao.registrarCompra(producto));
			System.out.println();
			opc=Integer.parseInt(JOptionPane.showInputDialog("Ingrese 1 si "+
					"desea agregar otro producto"));
		
		}while(opc==1);
	}
	
	private void actualizar() {
		Long idProducto=Long.parseLong(JOptionPane.showInputDialog("Ingrese el id del producto para actualizar"));
		Producto miProducto=miProductoDao.consultarProducto(idProducto);
		if(miProducto!=null) {
			System.out.println(miProducto);
			System.out.println();
			miProducto.setNombreProducto(JOptionPane.showInputDialog("Ingese el nombre del producto"));
			miProducto.setPrecioProducto(Double.parseDouble(JOptionPane.showInputDialog("Ingese el precio del producto")));
			
			System.out.println(miProductoDao.actualizarProducto(miProducto));
		}else {
			System.out.println();
			System.out.println("No se encontro el Producto");
		}
		System.out.println();
	}
	
	private void eliminar() {
		Long idProducto=Long.parseLong(JOptionPane.showInputDialog("Ingrese el id del producto para eliminar "));
		Producto miProducto=miProductoDao.consultarProducto(idProducto);
		if(miProducto!=null) {
			System.out.println(miProducto);
			System.out.println();
		
			System.out.println(miProductoDao.eliminarProducto(miProducto));
			System.out.println();
		}else {
			System.out.println();
			System.out.println("No se encontro el producto");
		}
		System.out.println();
	}
}

