package veterinaria.views;

import veterinaria.models.Session;

public class View {

	private Session session;
	
	private MainMenu mainMenu;
	
	public View(Session session) {
		this.session = session;
		this.mainMenu = new MainMenu(this.session);
	}

	public void interact() {
		this.mainMenu.execute();
	}
}
