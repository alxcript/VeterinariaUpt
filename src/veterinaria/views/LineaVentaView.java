package veterinaria.views;

import utils.WithConsoleView;
import veterinaria.models.LineaVenta;
import veterinaria.models.Session;
import veterinaria.models.Ticket;

public class LineaVentaView extends WithConsoleView {

	private Session session;
	
	public LineaVentaView(Session session) {
		this.session = session;
	}
	
	public void read(Ticket ticket) {
		int id = this.console.readInt("Ingrese el id del producto a vender: ");
		if(this.session.existProducto(id)) {
			int unidades = this.console.readInt("Ingrese las unidades a vender: ");
			if(this.session.hayStock(id, unidades)) {
				LineaVenta lineaVenta = new LineaVenta(id, unidades);
				double precio = this.session.getPrecio(id, unidades);
				lineaVenta.setPrecio(precio);
				ticket.agregarLineaVenta(lineaVenta);
				this.console.writeln("producto agregado al ticket..");
			}
			else {
				this.console.writeln("No hay suficiente stock..");
			}
		}
		else{
			this.console.writeln("No existe el producto indicado..");
		}
	}
	
	public void writeln(Ticket ticket) {
		for(LineaVenta lineaVenta : ticket.getLines()) {
			String[] producto = this.session.buscarProductoPorId(lineaVenta.getIdProducto());
			this.console.writeln(lineaVenta.getIdProducto() + "\t"  + producto[1] + "\t" + lineaVenta.getUnidades() + "\t" + lineaVenta.getPrecio());
		}
	}
}
