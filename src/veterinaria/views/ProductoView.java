package veterinaria.views;

import utils.WithConsoleView;
import veterinaria.models.Session;

public class ProductoView extends WithConsoleView {

	private Session session;
	
	public ProductoView(Session session) {
		this.session = session;
	}
	
	public void agregar() {
		int id = this.console.readInt("Ingrese el id del producto: ");
		if(!this.session.existProducto(id)) {
			String descripcion = this.console.readString("Ingrese la descripción del producto: ");
			double precioUnitario = this.console.readDouble("Ingrese el precio de venta unitario del producto: ");
			int stock = this.console.readInt("Ingrese el stock del producto: ");
			this.session.agregarProducto(id, descripcion, precioUnitario, stock);
			this.console.writeln("Producto agregado correctamente..");
		}
		else {
			this.console.writeln("Ya existe un producto con ese Id!!");
		}
	}

	public void buscarProductoPorId() {
		this.listarProductos();
		int id = this.console.readInt("Ingrese el id del producto buscado: ");
		String[] producto = this.session.buscarProductoPorId(id);
		if(producto != null) {
			this.console.writeln("Id: " + producto[0]);
			this.console.writeln("Descripción: " + producto[1]);
			this.console.writeln("Precio Unitario: " + producto[2]);
			this.console.writeln("Stock: " + producto[3]);
		}
		else {
			this.console.writeln("No existe el producto buscado..");
		}
	}

	public void listarProductos() {
		this.console.writeln();
		this.console.writeln("LISTA DE PRODUCTOS");
		this.console.writeln("------------------");
		this.console.writeln("Id || Descripcion || Precio Unitario || Stock");
		String[][] listaProductos = this.session.listaProductos();
		for(String[] producto : listaProductos) {
			this.console.writeln(producto[0] + " || " + producto[1] + " || " + producto[2] + " || " + producto[3]);
		}
	}

	public void modificarProducto() {
		this.listarProductos();
		int id = this.console.readInt("Ingrese el id del producto buscado: ");
		if(this.session.existProducto(id)) {
			String descripcion = this.console.readString("Ingrese la descripción del producto: ");
			double precioUnitario = this.console.readDouble("Ingrese el precio de venta unitario del producto: ");
			this.session.modificarProducto(id, descripcion, precioUnitario);
			this.console.writeln("Producto modificado correctamente..");
		}
		else {
			this.console.writeln("No existe un producto con ese Id!!");
		}
	}
}
