package veterinaria.views.menus;

import utils.LimitedIntDialog;
import utils.WithConsoleView;
import veterinaria.models.Session;

public class ServiciosMenu extends WithConsoleView {

	private GroomingMenu groomingMenu;
	
	public ServiciosMenu(Session session) {
		this.groomingMenu = new GroomingMenu(session);
	}

	public void execute() {
		int opcion;
		do {
			opcion = this.getOpcion();
			switch(opcion) {
			case 1:
				this.groomingMenu.execute();
				break;
			case 2:
				this.console.writeln("Aun no implementado..");
				break;
			case 3:
				//this.gestionVentaView.reporteVentas();
				break;
			}
		} while(opcion != 4);
	}
	
	private int getOpcion() {
		this.console.writeln();
		this.console.writeln("==============");
		this.console.writeln("Menu Servicios");
		this.console.writeln("==============");
		this.console.writeln("1. Grooming");
		this.console.writeln("2. Hospedaje");
		this.console.writeln("3. Paseo de mascotas");
		this.console.writeln("4. Atras");
		return LimitedIntDialog.instance().read("Opción?", 4);
	}

}
