package veterinaria.models;

import java.util.HashMap;
import java.util.Map;

public class GestionVenta {

	private Map<Integer, Ticket> tickets;
	
	private static int id;
	
	public GestionVenta() {
		this.tickets = new HashMap<Integer, Ticket>();
		GestionVenta.id = 1;
	}

	public void agregarTicket(Ticket ticket) {
		ticket.setId(GestionVenta.id);
		this.tickets.put(ticket.getId(), ticket);
		GestionVenta.id++;
	}

	public Ticket[] getTickets() {
		Ticket[] tickets = new Ticket[this.tickets.values().size()];
		int i = 0;
		for(Ticket ticket : this.tickets.values()) {
			tickets[i] = ticket;
			i++;
		}
		return tickets;
	}
	
	
}
