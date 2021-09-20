package veterinaria.views;

import utils.WithConsoleView;
import veterinaria.models.LineaVenta;
import veterinaria.models.Session;

public class LineaVentaView extends WithConsoleView {

	private Session session;
	
	public LineaVentaView(Session session) {
		this.session = session;
	}

	public void writeln(LineaVenta lineaVenta) {
		String[] producto = this.session.buscarProductoPorId(lineaVenta.getIdProducto());
		this.console.writeln(lineaVenta.getIdProducto() + "\t"  + producto[1] + "\t" + lineaVenta.getUnidades() + "\t" + lineaVenta.getPrecio());
	}

	public LineaVenta read() {
		LineaVenta lineaVenta = null;
		this.console.writeln();
		int id = this.console.readInt("Ingrese el id del producto a vender: ");
		if(this.session.existProducto(id)) {
			int unidades = this.console.readInt("Ingrese las unidades a vender: ");
			if(this.session.hayStock(id, unidades)) {
				lineaVenta = new LineaVenta(id, unidades);
				double precio = this.session.getPrecio(id, unidades);
				lineaVenta.setPrecio(precio);
				this.console.writeln("producto agregado al ticket..");
			}
			else {
				this.console.writeln("No hay suficiente stock..");
			}
		}
		else {
			this.console.writeln("No existe el producto indicado..");
		}
		return lineaVenta;
	}
}
