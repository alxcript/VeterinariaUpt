package veterinaria.models;

public class Paciente {

	private int id;
	
	private String nombre;
	
	private String tipoAnimal;
	
	private char sexo;
	
	private Cliente cliente;

	public Paciente(int id, String nombre, String tipoAnimal, char sexo, Cliente cliente) {
		this.id = id;
		this.nombre = nombre;
		this.tipoAnimal = tipoAnimal;
		this.sexo = sexo;
		this.cliente = cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public int getId() {
		return this.id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getTipoAnimal() {
		return tipoAnimal;
	}

	public char getSexo() {
		return sexo;
	}
	
	public String getNombreCliente() {
		return this.cliente.getNombreCompleto();
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setTipoAnimal(String tipoAnimal) {
		this.tipoAnimal = tipoAnimal;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	
	
	
	
}
