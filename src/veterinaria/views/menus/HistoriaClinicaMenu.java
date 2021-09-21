package veterinaria.views.menus;

import veterinaria.models.Session;
import veterinaria.views.GestionClinicaView;

public class HistoriaClinicaMenu extends Menu {

	private GestionClinicaView gestionClinicaView;
	
	public HistoriaClinicaMenu(Session session) {
		super("Historia Clínica");
		this.gestionClinicaView = new GestionClinicaView(session);
	}

	@Override
	protected void execute() {
		int opcion;
		do {
			opcion = super.getOpcion();
			switch(opcion) {
			case 1:
				this.gestionClinicaView.verHistoriaPaciente();
				break;
			case 2:
				break;
			case 3:
				break;
			}
		} while(opcion != 3);
	}

	@Override
	protected String[] setOpciones() {
		return new String[] { "Ver historia de paciente", "Listar todos las historias clinicas", "Atras" };
	}

}
