package veterinaria.views.menus;

import veterinaria.models.Session;
import veterinaria.views.GestionPacienteView;

public class PacienteMenu extends Menu {

	private GestionPacienteView gestionPacienteView;
	
	public PacienteMenu(Session session) {
		super("Paciente");
		this.gestionPacienteView = new GestionPacienteView(session);
	}

	@Override
	protected void execute() {
		int opcion;
		do {
			opcion = this.getOpcion();
			switch(opcion) {
			case 1:
				this.gestionPacienteView.agregar();
				break;
			case 2:
				this.gestionPacienteView.buscarPacientPorId();
				break;
			case 3:
				this.gestionPacienteView.modificarPaciente();
				break;
			case 4:
				this.gestionPacienteView.listarPacientes();
				break;
			case 5:
				break;
			}
		} while(opcion != 5);
	}

	@Override
	protected String[] setOpciones() {
		return new String[] { "Agregar paciente", "Buscar paciente", "Modificar paciente", "Listar pacientes", "Atras" };
	}

}
