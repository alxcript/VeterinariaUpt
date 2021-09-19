package veterinaria.models;

public class Cliente {

	private String dni;
	
	private String nombres;
	
	private String apellidoPaterno;
	
	private String apellidoMaterno;
	
	private char sexo;

	public Cliente(String dni, String nombres, String apellidoPaterno, String apellidoMaterno, char sexo) {
		this.dni = dni;
		this.nombres = nombres;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.sexo = sexo;
	}

	public String[] toArray() {
		String[] producto = new String[5];
		producto[0] = this.dni;
		producto[1] = this.nombres;
		producto[2] = this.apellidoPaterno;
		producto[3] = this.apellidoMaterno;
		producto[4] = Character.toString(this.sexo);
		return producto;
	}
	
	public String getDni() {
		return this.dni;
	}
	
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public String getNombreCompleto() {
		return this.nombres + " " + this.apellidoPaterno + " " + this.apellidoMaterno;
	}
}
