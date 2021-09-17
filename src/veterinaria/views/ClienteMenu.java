package veterinaria.views;

import utils.LimitedIntDialog;
import utils.WithConsoleView;
import veterinaria.models.Session;

public class ClienteMenu extends WithConsoleView {

	private Session session;
	
	private ClienteView clienteView;

	public ClienteMenu(Session session) {
		this.session = session;
		this.clienteView = new ClienteView(this.session);
	}
	
	public void execute() {
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
	
	private int getOpcion() {
		this.console.writeln();
		this.console.writeln("============");
		this.console.writeln("Menu Cliente");
		this.console.writeln("============");
		this.console.writeln("1. Agregar cliente");
		this.console.writeln("2. Buscar cliente");
		this.console.writeln("3. Modificar cliente");
		this.console.writeln("4. Listar clientes");
		this.console.writeln("5. Atras");
		return LimitedIntDialog.instance().read("Opción?", 5);
	}
}
