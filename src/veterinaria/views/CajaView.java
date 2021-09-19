package veterinaria.views;

import utils.WithConsoleView;
import veterinaria.models.Session;

public class CajaView extends WithConsoleView {

	private Session session;
	
	public CajaView(Session session) {
		this.session = session;
	}
	
	public void writeln() {
		this.console.writeln("====");
		this.console.writeln("CAJA");
		this.console.writeln("====");
		this.console.writeln("Acualmente hay : " + this.session.getCapital() + " Soles en caja");
	}
	
}
