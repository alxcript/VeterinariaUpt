package veterinaria.views.menus;

import veterinaria.models.Session;

public class ServiciosMenu extends Menu {

	private GroomingMenu groomingMenu;
	
	public ServiciosMenu(Session session) {
		super("Servicios");
		this.groomingMenu = new GroomingMenu(session);
	}
	
	@Override
	protected void execute() {
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
				this.console.writeln("Aun no implementado..");
				break;
			}
		} while(opcion != 4);
	}

	@Override
	protected String[] setOpciones() {
		return new String[] { "Grooming", "Hospedaje", "Paseo de mascotas", "Atras" };
	}

}
