package veterinaria.models;

public class LineaVenta {

	private int id;
	
	private int unidades;
	
	private double precio;
	
	public LineaVenta(int id, int unidades) {
		this.id= id;
		this.unidades = unidades;
	}
	
	public int getIdProducto() {
		return this.id;
	}
	
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	public int getUnidades() {
		return this.unidades;
	}

	public double getPrecio() {
		return this.precio;
	}
	
}
