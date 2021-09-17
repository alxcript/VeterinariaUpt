package veterinaria.views;

import utils.LimitedIntDialog;
import utils.WithConsoleView;
import veterinaria.models.Session;

public class MainMenu extends WithConsoleView {
	
	private TiendaMenu tiendaMenu;
	
	private GestionMenu gestionMenu;

	public MainMenu(Session session) {
		this.tiendaMenu = new TiendaMenu(session);
		this.gestionMenu = new GestionMenu(session);
	}
	
	public void execute() {
		int opcion;
		do {
			opcion = this.getOpcion();
			switch(opcion) {
			case 1:
				this.tiendaMenu.execute();
				break;
			case 2:
				this.console.writeln("Aun no implementado..");
				break;
			case 3:
				this.gestionMenu.execute();
				break;
			case 4:
				this.console.writeln("Programa terminado");
				break;
			}
		} while(opcion != 4);
	}

	private int getOpcion() {
		this.console.writeln();
		this.console.writeln("============");
		this.console.writeln("Menú Principal");
		this.console.writeln("============");
		this.console.writeln("1. Tienda");
		this.console.writeln("2. Clínica");
		this.console.writeln("3. Mantenimiento");
		this.console.writeln("4. Salir");
		return LimitedIntDialog.instance().read("Opción?", 4);
	}
	
}
