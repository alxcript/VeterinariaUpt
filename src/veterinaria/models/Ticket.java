package veterinaria.models;

import java.util.ArrayList;
import java.util.List;

public class Ticket {

	private int codigo;
	
	private List<LineaVenta> lineas;
	
	public Ticket() {
		this.lineas = new ArrayList<LineaVenta>();
	}
	
	public void add(LineaVenta linea) {
		this.lineas.add(linea);
	}
	
}
