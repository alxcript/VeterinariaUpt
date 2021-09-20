package veterinaria.views.menus;

import veterinaria.models.Session;
import veterinaria.views.GestionVentaView;

public class TiendaMenu extends Menu {

	private GestionVentaView gestionVentaView;
	
	public TiendaMenu(Session session) {
		super("Venta");
		this.gestionVentaView = new GestionVentaView(session);
	}

	@Override
	protected void execute() {
		int opcion;
		do {
			opcion = super.getOpcion();
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

	@Override
	protected String[] setOpciones() {
		return new String[] { "Venta", "Compra", "Reporte de Ventas", "Atras" };
	}
	
	
}
