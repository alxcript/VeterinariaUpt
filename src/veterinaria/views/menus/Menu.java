package veterinaria.views.menus;

import utils.LimitedIntDialog;
import utils.WithConsoleView;

public abstract class Menu extends WithConsoleView {

	protected String titulo;
	
	public Menu(String titulo) {
		this.titulo = titulo;
	}

	protected abstract void execute();
	
	protected int getOpcion() {
		this.console.writeln();
		this.console.writeln("=".repeat(this.titulo.length() + 5));
		this.console.writeln("Menú " + titulo);
		this.console.writeln("=".repeat(this.titulo.length() + 5));
		String[] opciones = this.setOpciones();
		for(int i = 0; i < opciones.length; i++) {
			this.console.writeln((i + 1) + ". " + opciones[i]);
		}
		return LimitedIntDialog.instance().read("Opción?", opciones.length);
	}
	
	protected abstract String[] setOpciones();
}
