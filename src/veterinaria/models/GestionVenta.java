package veterinaria.models;

import java.util.HashMap;
import java.util.Map;

public class GestionVenta {

	private Map<Integer, Ticket> tickets;
	
	public GestionVenta() {
		this.tickets = new HashMap<Integer, Ticket>();
	}
}
