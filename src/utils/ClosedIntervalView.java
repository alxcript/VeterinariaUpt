package utils;

public class ClosedIntervalView  extends WithConsoleView {

	private String title;
	
	private ClosedInterval closedInterval;
	
	public ClosedIntervalView(String title, ClosedInterval closedInterval){
		assert title != null;
		assert closedInterval != null;
		this.title = title;
		this.closedInterval = closedInterval;
	}
	
	public void writeln() {
		this.console.writeln(title + " " + this.toString());
	}
	
	@Override
	public String toString() {
		return "[" + closedInterval.getMin() + ", " + closedInterval.getMax() + "]";
	}
}
