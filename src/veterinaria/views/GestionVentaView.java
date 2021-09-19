package veterinaria.views;

import utils.WithConsoleView;
import utils.YesNoDialog;
import veterinaria.models.Cliente;
import veterinaria.models.Session;
import veterinaria.models.Ticket;

public class GestionVentaView extends WithConsoleView {

	private Session session;
	
	private TicketView ticketView;
	
	public GestionVentaView(Session session) {
		this.session = session;
		this.ticketView = new TicketView(this.session);
	}

	public void vender() {
		new ProductoView(this.session).listarProductos();
		Ticket ticket = this.ticketView.read();
		if(ticket.getLines().size() > 0) {
			boolean deseaGrabar = YesNoDialog.instance().read("Desea grabar la venta");
			if(deseaGrabar) {
				Cliente cliente = new ClienteView(this.session).read();
				ticket.setCliente(cliente);
				this.session.grabarVenta(ticket);
				this.console.writeln("Ticket guardado..");
			}
		}
	}

	public void reporteVentas() {
		this.console.writeln("=================");
		this.console.writeln("REPORTE DE VENTAS");
		this.console.writeln("=================");
		for(Ticket ticket : this.session.getTickets()) {
			this.ticketView.writeln(ticket);
		}
	}
}
