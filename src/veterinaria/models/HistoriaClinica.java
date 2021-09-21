package veterinaria.models;

import java.util.ArrayList;
import java.util.List;

public class HistoriaClinica {

	private Paciente paciente;
	
	private List<Documento> documentos;
	
	private int idDocumento;

	public HistoriaClinica(Paciente paciente) {
		this.paciente = paciente;
		this.documentos = new ArrayList<Documento>();
		this.idDocumento = 1;
	}
	
	public void setDocumento(Documento documento) {
		documento.setId(idDocumento);
		this.idDocumento++;
		this.documentos.add(documento);
	}

	public Paciente getPaciente() {
		return this.paciente;
	}
	
	public List<Documento> getDocumentos(){
		return this.documentos;
	}
}
