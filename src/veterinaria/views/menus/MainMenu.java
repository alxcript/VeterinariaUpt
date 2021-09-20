package veterinaria.views.menus;

import veterinaria.models.Session;
import veterinaria.views.CajaView;

public class MainMenu extends Menu {

	private TiendaMenu tiendaMenu;
	
	private GestionMenu gestionMenu;
	
	private ServiciosMenu serviciosMenu;
	
	private CajaView cajaView;
	
	public MainMenu(Session session) {
		super("Principal");
		this.tiendaMenu = new TiendaMenu(session);
		this.serviciosMenu = new ServiciosMenu(session);
		this.gestionMenu = new GestionMenu(session);
		this.cajaView = new CajaView(session);
	}
	
	@Override
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

	@Override
	protected String[] setOpciones() {
		return new String[] { "Tienda", "Clínica", "Servicios", "Total de ganancia", "Mantenimiento", "Salir" };
	}
}
