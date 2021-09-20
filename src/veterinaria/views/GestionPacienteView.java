package veterinaria.views;

import utils.WithConsoleView;
import veterinaria.models.Cliente;
import veterinaria.models.Paciente;
import veterinaria.models.Session;

public class GestionPacienteView extends WithConsoleView {
	
	private Session session;

	public GestionPacienteView(Session session) {
		this.session = session;
	}

	public void agregar() {
		int id = this.console.readInt("Ingrese el id del paciente: ");
		if(!this.session.existsPaciente(id)) {
			String nombre = this.console.readString("Ingrese el nombre del animal: ");
			String tipoAnimal = this.console.readString("Ingrese el tipo de animal: ");
			char sexo = this.console.readSexo("Ingrese el sexo del animal: ");
			Cliente cliente = new ClienteView(this.session).read();
			this.session.agregarPaciente(id, nombre, tipoAnimal, sexo, cliente);
			this.console.writeln("Paciente registrado correctamente..");
		}
		else {
			this.console.writeln("Ya existe una paciente con ese id!!");
		}
	}

	public void buscarPacientPorId() {
		int id = this.console.readInt("Ingrese el id del paciente a buscar: ");
		if(this.session.existsPaciente(id)) {
			Paciente paciente = this.session.buscarPacientePorId(id);
			this.console.writeln();
			this.console.writeln("Id: " + paciente.getId());
			this.console.writeln("Nombres: " + paciente.getNombre());
			this.console.writeln("Tipo Animal: " + paciente.getTipoAnimal());
			this.console.writeln("Sexo: " + paciente.getSexo());
			this.console.writeln("Dueño: " + paciente.getNombreCliente());
		}
		else {
			this.console.writeln("No existe una paciente con ese id!!");
		}
	}

	public void modificarPaciente() {
		this.listarPacientes();
		int id = this.console.readInt("Ingrese el id del paciente a modificar: ");
		if(this.session.existsPaciente(id)) {
			String nombre = this.console.readString("Ingrese el nombre del animal: ");
			String tipoAnimal = this.console.readString("Ingrese el tipo de animal: ");
			char sexo = this.console.readSexo("Ingrese el sexo del animal: ");
			Cliente cliente = new ClienteView(this.session).read();
			this.session.modificarPaciente(id,  nombre, tipoAnimal, sexo, cliente);
			this.console.writeln("Paciente modificado correctamente..");
		}
		else {
			this.console.writeln("No existe una paciente con ese id!!");
		}
		
	}

	public void listarPacientes() {
		this.console.writeln();
		this.console.writeln("LISTA DE PACIENTES");
		this.console.writeln("------------------");
		this.console.writeln("Id || Nombre || tipo Animal || sexo || Dueño");
		for(Paciente paciente : this.session.listaPacientes()){
			this.console.writeln(paciente.getId() + " || " + paciente.getNombre() + " || " + paciente.getTipoAnimal() + " || " + paciente.getSexo() + " || " + paciente.getNombreCliente());
		}
	}

}
