package veterinaria.views;

import veterinaria.models.Session;

public class GestionView {

	private Session session;

	public GestionView(Session session) {
		this.session = session;
	}
	
	public void interact() {
		new GestionMenu(this.session).execute();
	}
	
}
