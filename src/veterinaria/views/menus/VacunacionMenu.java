package veterinaria.views.menus;

import veterinaria.models.Session;
import veterinaria.views.GestionClinicaView;

public class VacunacionMenu extends Menu {

	private GestionClinicaView gestionClinicaView;
	
	public VacunacionMenu(Session session) {
		super("Vacunación");
		this.gestionClinicaView = new GestionClinicaView(session);
	}

	@Override
	protected void execute() {
		int opcion;
		do {
			opcion = super.getOpcion();
			switch(opcion) {
			case 1:
				this.gestionClinicaView.registrarVacuna(25);
				break;
			case 2:
				this.gestionClinicaView.registrarVacuna(20);
				break;
			case 3:
				this.gestionClinicaView.registrarVacuna(30);
				break;
			case 4:
				break;
			}
		} while(opcion != 4);
	}

	@Override
	protected String[] setOpciones() {
		String[] opciones = new String[4];
		opciones[0] = "ANTIRRABICA  S/. 25";
		opciones[1] = "DESPARASITARIA  S/. 20";
		opciones[2] = "PARVOVIROSIS  S/. 30";
		opciones[3] = "Atras";
		return opciones;
	}

	
}
