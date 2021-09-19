package veterinaria.views.menus;

import utils.LimitedIntDialog;
import utils.WithConsoleView;
import veterinaria.models.Session;

public class GestionMenu extends WithConsoleView {

	private ProductoMenu productoMenu;
	
	private ClienteMenu clienteMenu;
	
	public GestionMenu(Session session) {
		this.productoMenu = new ProductoMenu(session);
		this.clienteMenu = new ClienteMenu(session);
	}

	public void execute() {
		int opcion;
		do {
			opcion = this.getOpcion();
			switch(opcion) {
			case 1:
				this.productoMenu.execute();
				break;
			case 2:
				this.clienteMenu.execute();
				break;
			case 3:
				this.console.writeln("Aun no implementado..");
				break;
			}
		} while(opcion != 4);
	}
	
	private int getOpcion() {
		this.console.writeln();
		this.console.writeln("============");
		this.console.writeln("Men� Gesti�n");
		this.console.writeln("============");
		this.console.writeln("1. Producto");
		this.console.writeln("2. Cliente");
		this.console.writeln("3. Paciente");
		this.console.writeln("4. Atras");
		return LimitedIntDialog.instance().read("Opci�n?", 4);
	}

}
