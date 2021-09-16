package utils;

public class WithConsoleView {
	
	protected Console console;
	
	protected WithConsoleView() {
		this.console = Console.instance();
	}
}
