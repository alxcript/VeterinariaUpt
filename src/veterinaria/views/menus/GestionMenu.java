package veterinaria.views.menus;

import veterinaria.models.Session;

public class GestionMenu extends Menu {

	private ProductoMenu productoMenu;
	
	private ClienteMenu clienteMenu;
	
	private PacienteMenu pacienteMenu;

	public GestionMenu(Session session) {
		super("Gestión");
		this.productoMenu = new ProductoMenu(session);
		this.clienteMenu = new ClienteMenu(session);
		this.pacienteMenu = new PacienteMenu(session);
	}
	
	@Override
	protected void execute() {
		int opcion;
		do {
			opcion = this.getOpcion();
			switch(opcion) {
			case 1:
				this.productoMenu.execute();
				break;
			case 2:
				this.clienteMenu.execute();
				break;
			case 3:
				this.pacienteMenu.execute();
				break;
			}
		} while(opcion != 4);
	}

	@Override
	protected String[] setOpciones() {
		return new String[] { "Producto", "Cliente", "Paciente", "Atras" };
	}


}
