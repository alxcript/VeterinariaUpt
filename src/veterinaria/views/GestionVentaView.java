package veterinaria.views;

import utils.WithConsoleView;
import utils.YesNoDialog;
import veterinaria.models.LineaVenta;
import veterinaria.models.Session;
import veterinaria.models.Ticket;

public class GestionVentaView extends WithConsoleView {

	private Session session;
	
	public GestionVentaView(Session session) {
		this.session = session;
	}

	public void vender() {
		new ProductoView(this.session).listarProductos();
		Ticket ticket = new Ticket();
		do {
			int id = this.console.readInt("Ingrese el id del producto a vender: ");
			if(this.session.existProducto(id)) {
				int unidades = this.console.readInt("Ingrese la unidades a vender: ");
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
			boolean ingresarMas = YesNoDialog.instance().read("Otro producto");
			if(!ingresarMas) {
				ticket.close();
			}
		} while(!ticket.isClosed());
		if(ticket.getLines().size() > 0) {
			boolean deseaGrabar = YesNoDialog.instance().read("Desea grabar la venta");
			if(deseaGrabar) {
				for(LineaVenta lineaVenta : ticket.getLines()) {
					this.session.salidaAlmacen(lineaVenta.getIdProducto(), lineaVenta.getUnidades());
					this.session.entradaCaja(lineaVenta.getPrecio());
				}
				this.session.agregarTicket(ticket);
				this.console.writeln("Ticket guardado..");
			}
		}
	}

	public void reporteVentas() {
		this.console.writeln("=================");
		this.console.writeln("REPORTE DE VENTAS");
		this.console.writeln("=================");
		for(Ticket ticket : this.session.getTickets()) {
			this.console.writeln();
			this.console.writeln("==================================================================");
			this.console.writeln("Ticket id: " + ticket.getId() + " || Fecha y Hora: " + ticket.getDate());
			this.console.writeln("==================================================================");
			this.console.writeln("Id Producto || Descripcion \t\t|| Unidades || Precio");
			this.console.writeln("------------------------------------------------");
			for(LineaVenta lineaVenta : ticket.getLines()) {
				String[] producto = this.session.buscarProductoPorId(lineaVenta.getIdProducto());
				this.console.writeln(lineaVenta.getIdProducto() + "\t"  + producto[1] + "\t" + lineaVenta.getUnidades() + "\t" + lineaVenta.getPrecio());
			}
		}
	}
}
