package veterinaria.views;

import utils.WithConsoleView;
import veterinaria.models.Documento;
import veterinaria.models.HistoriaClinica;
import veterinaria.models.Paciente;
import veterinaria.models.Session;

public class GestionClinicaView extends WithConsoleView {
	
	private Session session;

	public GestionClinicaView(Session session) {
		this.session = session;
	}

	public void registrarVacuna(double monto) {
		Paciente paciente = new GestionPacienteView(this.session).readPaciente();
		if(paciente != null) {
			HistoriaClinica historiaClinica = this.session.getHistoriaClinica(paciente);
			String nombreVeterinario = this.console.readString("Ingrese el nombre del veterinario que atiende: ");
			String tratamiento = this.console.readString("Describa el tratamiento realizado: ");
			Documento documento = new Documento(nombreVeterinario, tratamiento);
			if(historiaClinica != null) {
				historiaClinica.setDocumento(documento);
			}
			else {
				HistoriaClinica newHistoriaClinica = new HistoriaClinica(paciente);
				newHistoriaClinica.setDocumento(documento);
				this.session.grabarHistoriaClinica(newHistoriaClinica);
			}
			this.console.writeln("Documento registrado en la historia clinica del paciente");
			this.session.entradaCaja(monto);
			this.console.writeln("Pago de vacunación registrado.." + "Monto: S/. " + monto);
		}
		else {
			this.console.writeln("El paciente no existe en los registros.. Debe registrarlo antes de iniciar una historia clínica");
		}
	}

	public void verHistoriaPaciente() {
		Paciente paciente = new GestionPacienteView(this.session).readPaciente();
		if(paciente != null) {
			HistoriaClinica historiaClinica = this.session.getHistoriaClinica(paciente);
			if(historiaClinica != null) {
				this.console.writeln();
				this.console.writeln("HISTORIA CLINICA DEL PACIENTE: '" + paciente.getNombre().toUpperCase() + "' || " + paciente.getTipoAnimal());
				for(Documento documento : historiaClinica.getDocumentos()) {
					this.console.writeln();
					this.console.writeln("ID documento: " + documento.getId());
					this.console.writeln("Fecha y Hora: " + documento.getHoraFecha());
					this.console.writeln("Veterinario: " + documento.getNombreVeterinario());
					this.console.writeln("Tratamiento realizado: " + documento.getTratamiento());
				}
			}
			else {
				this.console.writeln("Este paciente aún no cuenta con una historia clínica creada..");
			}
		}
		else {
			this.console.writeln("El paciente no existe en los registros.. Debe registrarlo antes de ver su historia clínica");
		}
	}
}
