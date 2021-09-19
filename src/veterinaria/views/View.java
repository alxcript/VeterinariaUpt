package veterinaria.views;

import veterinaria.models.Session;
import veterinaria.views.menus.MainMenu;

public class View {

	private MainMenu mainMenu;
	
	public View(Session session) {
		this.mainMenu = new MainMenu(session);
	}

	public void interact() {
		this.mainMenu.execute();
	}
}
