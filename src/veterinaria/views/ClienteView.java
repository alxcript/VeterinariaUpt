package veterinaria.views;

import utils.WithConsoleView;
import veterinaria.models.Cliente;
import veterinaria.models.Session;
import utils.YesNoDialog;

public class ClienteView extends WithConsoleView {

	private Session session;

	public ClienteView(Session session) {
		super();
		this.session = session;
	}

	public void agregar() {
		String dni = this.console.readDni("Ingrese el numero de dni: ");
		if(!this.session.existCliente(dni)) {
			String nombres = this.console.readString("Ingrese el nombre: ");
			String apellidoPaterno = this.console.readString("Ingrese el apellido paterno: ");
			String apellidoMaterno = this.console.readString("Ingrese el apellido materno: ");
			char sexo = this.console.readSexo("Ingrese el sexo [m - f]: ");
			this.session.agregarCliente(dni, nombres, apellidoPaterno, apellidoMaterno, sexo);
			this.console.writeln("Cliente agregado correctamente..");
		}
		else {
			this.console.writeln("Ya existe un cliente con este dni!!");
		}
	}

	public void listarClientes() {
		this.console.writeln();
		this.console.writeln("LISTA DE CLIENTES");
		this.console.writeln("-----------------");
		this.console.writeln("Dni || Nombres || Apellido Paterno || Apellido Materno || Sexo");
		String[][] listaClientes = this.session.listaClientes();
		for(String[] cliente : listaClientes) {
			this.console.writeln(cliente[0] + " || " + cliente[1] + " || " + cliente[2] + " || " + cliente[3]+ " || " + cliente[4]);
		}
	}

	public void buscarClientePorDni() {
		String dni = this.console.readDni("Ingrese el numero de dni: ");
		if(this.session.existCliente(dni)) {
			String[] cliente = this.session.buscarClientePorDni(dni);
			this.console.writeln();
			this.console.writeln("Dni: " + cliente[0]);
			this.console.writeln("Nombres: " + cliente[1]);
			this.console.writeln("Apellido Paterno: " + cliente[2]);
			this.console.writeln("Apellido Materno: " + cliente[3]);
			this.console.writeln("Sexo: " + cliente[4]);
		}
		else {
			this.console.writeln("No existe el cliente buscado..");
		}
	}

	public void modificarCliente() {
		this.listarClientes();
		String dni = this.console.readDni("Ingrese el numero de dni: ");
		if(this.session.existCliente(dni)) {
			String nombres = this.console.readString("Ingrese el nombre: ");
			String apellidoPaterno = this.console.readString("Ingrese el apellido paterno: ");
			String apellidoMaterno = this.console.readString("Ingrese el apellido materno: ");
			char sexo = this.console.readSexo("Ingrese el sexo [m - f]: ");
			this.session.modificarCliente(dni, nombres, apellidoPaterno, apellidoMaterno, sexo);
		}
		else {
			this.console.writeln("No existe el cliente buscado..");
		}
	}

	public Cliente read() {
		boolean ok = false;
		Cliente cliente = this.session.buscarCliente("00000000");
		do {
			String dni = this.console.readDni("Ingrese el dni del cliente: ");
			if(this.session.existCliente(dni)) {
				cliente = this.session.buscarCliente(dni);
				ok = true;
			}
			else {
				this.console.writeln("No existe el cliente buscado..");
				boolean crearCliente = YesNoDialog.instance().read("desea registrar cliente");
				if(crearCliente) {
					this.agregar();
				}
				else {
					ok = !YesNoDialog.instance().read("desea asignar cliente");
				}
			}
		} while(!ok);
		return cliente;
	}
	
}
