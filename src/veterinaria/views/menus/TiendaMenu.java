package veterinaria.views.menus;

import utils.LimitedIntDialog;
import utils.WithConsoleView;
import veterinaria.models.Session;
import veterinaria.views.GestionVentaView;

public class TiendaMenu extends WithConsoleView {

	private GestionVentaView gestionVentaView;
	
	public TiendaMenu(Session session) {
		this.gestionVentaView = new GestionVentaView(session);
	}

	public void execute() {
		int opcion;
		do {
			opcion = this.getOpcion();
			switch(opcion) {
			case 1:
				this.gestionVentaView.vender();
				break;
			case 2:
				this.console.writeln("Aun no implementado..");
				break;
			case 3:
				this.gestionVentaView.reporteVentas();
				break;
			}
		} while(opcion != 4);
	}

	private int getOpcion() {
		this.console.writeln();
		this.console.writeln("============");
		this.console.writeln("Menu Venta");
		this.console.writeln("============");
		this.console.writeln("1. Venta");
		this.console.writeln("2. Compra");
		this.console.writeln("3. Reporte de Ventas");
		this.console.writeln("4. Atras");
		return LimitedIntDialog.instance().read("Opción?", 4);
	}
	
	
}
