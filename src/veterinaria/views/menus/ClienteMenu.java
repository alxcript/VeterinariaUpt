package veterinaria.views.menus;

import veterinaria.models.Session;
import veterinaria.views.ClienteView;

public class ClienteMenu extends Menu {

	private ClienteView clienteView;

	public ClienteMenu(Session session) {
		super("Cliente");
		this.clienteView = new ClienteView(session);
	}

	@Override
	protected void execute() {
		int opcion;
		do {
			opcion = this.getOpcion();
			switch(opcion) {
			case 1:
				this.clienteView.agregar();
				break;
			case 2:
				this.clienteView.buscarClientePorDni();
				break;
			case 3:
				this.clienteView.modificarCliente();
				break;
			case 4:
				this.clienteView.listarClientes();
				break;
			case 5:
				break;
			}
		} while(opcion != 5);
	}
	
	@Override
	protected String[] setOpciones() {
		return new String[] { "Agregar cliente", "Buscar cliente", "Modificar cliente", "Listar clientes", "Atras" };
	}
}
