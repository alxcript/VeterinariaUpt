package veterinaria.views.menus;

import veterinaria.models.Session;

public class GroomingMenu extends Menu {

	private Session session;
	
	public GroomingMenu(Session session) {
		super("Grooming");
		this.session = session;
	}
	
	@Override
	protected void execute() {
		int opcion = getOpcion();
		switch(opcion) {
		case 1:
			this.session.entradaCaja(15);
			break;
		case 2:
			this.session.entradaCaja(25);
			break;
		case 3:
			this.session.entradaCaja(35);
			break;
		case 4:
			this.session.entradaCaja(10);
			break;
		}
		if(opcion!=5) {
			this.console.writeln("Servicio de grooming registrado");
		}
	}

	@Override
	protected String[] setOpciones() {
		String[] opciones = new String[5];
		opciones[0] = "BAÑO BASICO  S/. 15";
		opciones[1] = "BAÑO BASICO Y CORTE DE PELO  S/. 25";
		opciones[2] = "BAÑO MEDICINAL  S/. 35";
		opciones[3] = "CORTE DE PELO  S/. 10";
		opciones[4] = "Atras";
		return opciones;
	}
}
