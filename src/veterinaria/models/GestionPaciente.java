package veterinaria.models;

import java.util.HashMap;
import java.util.Map;

public class GestionPaciente {

	private Map<Integer, Paciente> pacientes;

	public GestionPaciente() {
		this.pacientes = new HashMap<Integer, Paciente>();
	}
	
	
	
	public void agregar(int id, String nombre, String tipoAnimal, char sexo, Cliente cliente) {
		this.pacientes.put(id, new Paciente(id, nombre, tipoAnimal, sexo, cliente));
	}
	
	public boolean exist(int id) {
		return this.pacientes.get(id) != null;
	}

	public Paciente buscarPorId(int id) {
		return this.pacientes.get(id);
	}

	public Paciente[] listar() {
		Paciente[] listaPacientes = new Paciente[this.pacientes.values().size()];
		int i = 0;
		for(Paciente paciente : this.pacientes.values()) {
			listaPacientes[i] = paciente;
			i++;
		}
		return listaPacientes;
	}

	public void modificarPaciente(int id, String nombre, String tipoAnimal, char sexo, Cliente cliente) {
		Paciente paciente = this.pacientes.get(id);
		paciente.setNombre(nombre);
		paciente.setTipoAnimal(tipoAnimal);
		paciente.setSexo(sexo);
		paciente.setCliente(cliente);
	}

}
