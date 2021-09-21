package veterinaria.views.menus;

import veterinaria.models.Session;

public class ClinicaMenu extends Menu {

	private VacunacionMenu vacunacionMenu;
	
	private HistoriaClinicaMenu historiaClinicaMenu;
	
	public ClinicaMenu(Session session) {
		super("Clínica");
		this.vacunacionMenu = new VacunacionMenu(session);
		this.historiaClinicaMenu = new HistoriaClinicaMenu(session);
	}

	@Override
	protected void execute() {
		int opcion;
		do {
			opcion = super.getOpcion();
			switch(opcion) {
			case 1:
				this.vacunacionMenu.execute();
				break;
			case 2:
				this.console.writeln("Aun no implementado");
				break;
			case 3:
				this.historiaClinicaMenu.execute();
				break;
			}
		} while(opcion != 4);
	}

	@Override
	protected String[] setOpciones() {
		return new String[] { "Vacunación", "Operaciones", "Historia Clinica", "Atras "};
	}

}
