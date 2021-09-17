package veterinaria.models;

public class LineaVenta {

	private int idProducto;
	
	private int unidades;
	
	private double precio;
	
	public LineaVenta(int idProducto, int unidades) {
		this.idProducto = idProducto;
		this.unidades = unidades;
	}
	
	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getIdProducto() {
		return idProducto;
	}

	public int getUnidades() {
		return unidades;
	}

	public double getPrecio() {
		return precio;
	}
	
}
