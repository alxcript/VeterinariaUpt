package veterinaria.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Ticket {

	private int id;
	
	private Date date;
	
	private Cliente cliente;
	
	private List<LineaVenta> lineas;
	
	private boolean closed;
	
	public Ticket() {
		this.date = new Date();
		this.lineas = new ArrayList<LineaVenta>();
		this.closed = false;
		this.id = GestionVenta.id;
	}
	
	public void agregarLineaVenta(LineaVenta linea) {
		this.lineas.add(linea);
	}
	
	void setId(int id) {
		this.id = id;
	}
	
	public void setDniCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public int getId() {
		return id;
	}

	public boolean isClosed() {
		return this.closed;
	}

	public void close() {
		this.closed = true;
	}

	public List<LineaVenta> getLines() {
		return this.lineas;
	}
	
	public double getTotal() {
		double total = 0;
		for(LineaVenta lineaVenta : this.lineas) {
			total += lineaVenta.getPrecio();
		}
		return total;
	}

	public Date getDate() {
		return this.date;
	}
	
}
