package veterinaria;


import veterinaria.models.Session;
import veterinaria.views.View;

public class Veterinaria {

	private Session session;
	
	private View view;
	
	public Veterinaria() {
		this.session = new Session();
		this.view = new View(this.session);
	}

	private void run() {
		this.view.interact();
	}

	public static void main(String[] args) {
		new Veterinaria().run();
	}
}
