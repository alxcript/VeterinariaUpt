package veterinaria.views.menus;

import utils.LimitedIntDialog;
import utils.WithConsoleView;
import veterinaria.models.Session;

public class GroomingMenu extends WithConsoleView {
	
	private Session session;
	
	public GroomingMenu(Session session) {
		this.session = session;
	}
	
	public void execute() {
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

	private int getOpcion() {
		this.console.writeln();
		this.console.writeln("==============");
		this.console.writeln("Menú Servicios");
		this.console.writeln("==============");
		this.console.writeln("1. BAÑO BASICO  S/. 15");
		this.console.writeln("2. BAÑO BASICO Y CORTE DE PELO  S/. 25");
		this.console.writeln("3. BAÑO MEDICINAL  S/. 35");
		this.console.writeln("4. CORTE DE PELO  S/. 10");
		this.console.writeln("5. Atras");
		return LimitedIntDialog.instance().read("Opción?", 5);
	}
}
