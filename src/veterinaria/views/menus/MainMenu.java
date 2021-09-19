package veterinaria.views.menus;

import utils.LimitedIntDialog;
import utils.WithConsoleView;
import veterinaria.models.Session;
import veterinaria.views.CajaView;

public class MainMenu extends WithConsoleView {
	
	private TiendaMenu tiendaMenu;
	
	private GestionMenu gestionMenu;
	
	private ServiciosMenu serviciosMenu;
	
	private CajaView cajaView;

	public MainMenu(Session session) {
		this.tiendaMenu = new TiendaMenu(session);
		this.serviciosMenu = new ServiciosMenu(session);
		this.gestionMenu = new GestionMenu(session);
		this.cajaView = new CajaView(session);
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
				this.serviciosMenu.execute();
				break;
			case 4:
				this.cajaView.writeln();
				break;
			case 5:
				this.gestionMenu.execute();
				break;
			case 6:
				this.console.writeln("Programa terminado");
				break;
			}
		} while(opcion != 6);
	}

	private int getOpcion() {
		this.console.writeln();
		this.console.writeln("==============");
		this.console.writeln("Menú Principal");
		this.console.writeln("==============");
		this.console.writeln("1. Tienda");
		this.console.writeln("2. Clínica");
		this.console.writeln("3. Servicios");
		this.console.writeln("4. Total de ganancia");
		this.console.writeln("5. Mantenimiento");
		this.console.writeln("6. Salir");
		return LimitedIntDialog.instance().read("Opción?", 6);
	}
}
