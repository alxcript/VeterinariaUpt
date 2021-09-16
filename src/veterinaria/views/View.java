package veterinaria.views;

import veterinaria.models.Session;

public class View {

	private Session session;
	
	private GestionView gestionView;
	
	public View(Session session) {
		this.session = session;
		this.gestionView = new GestionView(this.session);
	}

	public void interact() {
		this.gestionView.interact();
	}
}
