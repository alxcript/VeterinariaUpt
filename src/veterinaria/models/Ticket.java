package veterinaria.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Ticket {

	private int id;
	
	private Date date;
	
	private List<LineaVenta> lineas;
	
	private boolean closed;
	
	public Ticket() {
		this.date = new Date();
		this.lineas = new ArrayList<LineaVenta>();
		this.closed = false;
	}
	
	public void agregarLineaVenta(LineaVenta linea) {
		this.lineas.add(linea);
	}
	
	void setId(int id) {
		this.id = id;
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

	public Date getDate() {
		return this.date;
	}
	
}
