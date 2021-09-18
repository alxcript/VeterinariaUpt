package veterinaria.models;

import java.util.HashMap;
import java.util.Map;

public class GestionCliente {

	private Map<String, Cliente> clientes;

	public GestionCliente() {
		this.clientes = new HashMap<String, Cliente>();
		this.llenarClientes();
	}
	
	private void llenarClientes() {
		this.agregarCliente(new Cliente("00000000", "(Clientes varios)", "", "", ' '));
		this.agregarCliente(new Cliente("71372246", "Alex", "Arhuata", "Turpo", 'M'));
		this.agregarCliente(new Cliente("12345678", "Rene", "Poma", "Manchego", 'M'));
		this.agregarCliente(new Cliente("87654321", "Laura", "Condori", "Ramirez", 'F'));
		this.agregarCliente(new Cliente("14785236", "Jeackory Geilly", "Lima", "Ccosi", 'F'));
	}

	public void agregarCliente(Cliente cliente) {
		this.clientes.put(cliente.getDni(), cliente);
	}
	
	public boolean exists(String dni) {
		return this.clientes.get(dni) != null;
	}
	
	public void remove(String dni) {
		this.clientes.remove(dni);
	}

	public String[][] listaClientes() {
		String[][] listaClientes = new String[this.clientes.values().size()][0];
		int i = 0;
		for(Cliente cliente : this.clientes.values()) {
			listaClientes[i] = cliente.toArray();
			i++;
		}
		return listaClientes;
	}

	public String[] buscarClientePorDni(String dni) {
		return this.clientes.get(dni).toArray();
	}

	public void modificarCliente(String dni, String nombres, String apellidoPaterno, String apellidoMaterno, char sexo) {
		Cliente cliente = this.clientes.get(dni);
		cliente.setNombres(nombres);
		cliente.setApellidoPaterno(apellidoPaterno);
		cliente.setApellidoMaterno(apellidoMaterno);
		cliente.setSexo(sexo);
	}

	public Cliente buscarCliente(String dni) {
		return this.clientes.get(dni);
	}
}
