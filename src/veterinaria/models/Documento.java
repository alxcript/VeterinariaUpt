package veterinaria.models;

import java.util.Date;

public class Documento {

	private int id;
	
	private Date horaFecha;
	
	private String nombreVeterinario;
	
	private String tratamiento;

	public Documento(String nombreVeterinario, String tratamiento) {
		this.horaFecha = new Date();
		this.nombreVeterinario = nombreVeterinario;
		this.tratamiento = tratamiento;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return this.id;
	}

	public Date getHoraFecha() {
		return horaFecha;
	}

	public String getNombreVeterinario() {
		return nombreVeterinario;
	}

	public String getTratamiento() {
		return tratamiento;
	}
	
	
}
