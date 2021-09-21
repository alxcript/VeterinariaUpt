package veterinaria.models;

import java.util.HashMap;
import java.util.Map;

public class GestionClinica {

	private Map<Paciente, HistoriaClinica> historiasClinicas;
	
	public GestionClinica() {
		this.historiasClinicas = new HashMap<Paciente, HistoriaClinica>();
	}
	
	public void agregarHistoriaClinica(HistoriaClinica historiaClinica) {
		this.historiasClinicas.put(historiaClinica.getPaciente(), historiaClinica);
	}
	
	public HistoriaClinica getHistoriaClinica(Paciente paciente) {
		return this.historiasClinicas.get(paciente);
	}
	
}
