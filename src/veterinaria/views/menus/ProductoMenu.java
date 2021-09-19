package veterinaria.views.menus;

import utils.LimitedIntDialog;
import utils.WithConsoleView;
import veterinaria.models.Session;
import veterinaria.views.ProductoView;

public class ProductoMenu extends WithConsoleView {

	private Session session;
	
	private ProductoView productoView;
	
	public ProductoMenu(Session session) {
		this.session = session;
		this.productoView = new ProductoView(this.session);
	}

	public void execute() {
		int opcion;
		do {
			opcion = this.getOpcion();
			switch(opcion) {
			case 1:
				this.productoView.agregar();
				break;
			case 2:
				this.productoView.buscarProductoPorId();
				break;
			case 3:
				this.productoView.modificarProducto();
				break;
			case 4:
				this.productoView.listarProductos();
				break;
			case 5:
				break;
			}
		} while(opcion != 5);
	}
	
	private int getOpcion() {
		this.console.writeln();
		this.console.writeln("=============");
		this.console.writeln("Menú Producto");
		this.console.writeln("=============");
		this.console.writeln("1. Agregar producto");
		this.console.writeln("2. Buscar producto");
		this.console.writeln("3. Modificar producto");
		this.console.writeln("4. Listar productos");
		this.console.writeln("5. Atras");
		return LimitedIntDialog.instance().read("Opción?", 5);
	}
}
