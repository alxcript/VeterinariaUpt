package veterinaria.models;

public class Caja {

	private double capital;

	public Caja() {
		this.capital = 0;
	}
	
	public void add(double monto) {
		this.capital += monto;
	}
	
	public void remove(double monto) {
		this.capital -= monto;
	}
	
	public double getCapital() {
		return this.capital;
	}
	
}
