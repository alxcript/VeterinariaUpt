package veterinaria.views.menus;

import veterinaria.models.Session;
import veterinaria.views.ProductoView;

public class ProductoMenu extends Menu {

	private ProductoView productoView;
	
	public ProductoMenu(Session session) {
		super("Producto");
		this.productoView = new ProductoView(session);
	}
	
	@Override
	protected void execute() {
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


	@Override
	protected String[] setOpciones() {
		return new String[] { "Agregar producto", "Buscar producto", "Modificar producto", "Listar productos", "Atras" };
	}
	
	
}
