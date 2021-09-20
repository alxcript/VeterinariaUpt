package veterinaria.views;

import utils.WithConsoleView;
import utils.YesNoDialog;
import veterinaria.models.LineaVenta;
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
		Ticket ticket = new Ticket(this.session.buscarCliente("00000000"));
		do {
			new ProductoView(this.session).listarProductos();
			LineaVenta lineaVenta = this.lineaVentaView.read();
			if(lineaVenta != null) {
				ticket.agregarLineaVenta(lineaVenta);
			}
			boolean ingresarMas = YesNoDialog.instance().read("Otro producto");
			if(!ingresarMas) {
				ticket.close();
			}
			this.writeln(ticket);
		} while(!ticket.isClosed());
		return ticket;
	}
	
	public void writeln(Ticket ticket) {
		this.console.writeln();
		this.console.writeln("==================================================================");
		this.console.writeln("Ticket id: " + ticket.getId() + " || Fecha y Hora: " + ticket.getDate());
		this.console.writeln("Cliente id: " + ticket.getDniCliente() + " || Nombre Cliente: " + ticket.getClienteNombreCompleto());
		this.console.writeln("==================================================================");
		this.console.writeln("Id Producto || Descripcion \t\t|| Unidades || Precio");
		this.console.writeln("------------------------------------------------------------");
		for(LineaVenta lineaVenta : ticket.getLines()) {
			this.lineaVentaView.writeln(lineaVenta);
		}
		this.console.writeln("Total: " + ticket.getTotal());
	}
}
