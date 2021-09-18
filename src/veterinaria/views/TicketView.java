package veterinaria.views;

import utils.WithConsoleView;
import utils.YesNoDialog;
import veterinaria.models.Session;
import veterinaria.models.Ticket;

public class TicketView extends WithConsoleView {

	private Session session;
	
	private LineaVentaView lineaVentaView;
	
	public TicketView(Session session) {
		this.session = session;
		this.lineaVentaView = new LineaVentaView(this.session);
	}
	
	public Ticket read() {
		Ticket ticket = new Ticket();
		do {
			this.lineaVentaView.read(ticket);
			this.writeln(ticket);
			boolean ingresarMas = YesNoDialog.instance().read("Otro producto");
			if(!ingresarMas) {
				ticket.close();
			}
		} while(!ticket.isClosed());
		return ticket;
	}
	
	public void writeln(Ticket ticket) {
		this.console.writeln();
		this.console.writeln("==================================================================");
		this.console.writeln("Ticket id: " + ticket.getId() + " || Fecha y Hora: " + ticket.getDate());
		this.console.writeln("==================================================================");
		this.console.writeln("Id Producto || Descripcion \t\t|| Unidades || Precio");
		this.console.writeln("------------------------------------------------");
		this.lineaVentaView.writeln(ticket);
		this.console.writeln("Total: " + ticket.getTotal());
	}
}
