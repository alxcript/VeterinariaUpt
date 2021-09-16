package veterinaria.models;

public class Producto {

	private int id;
	
	private String descripcion;
	
	private double precioUnitario;
	
	private int stock;

	public Producto(int id, String descripcion, double precioUnitario, int stock) {
		this.id = id;
		this.descripcion = descripcion;
		this.precioUnitario = precioUnitario;
		this.stock = stock;
	}
	
	public double getPrecio(int unidades) {
		return this.precioUnitario * unidades;
	}
	
	public void add(int unidades) {
		this.stock += unidades;
	}
	
	public void remove(int unidades) {
		this.stock -= unidades;
	}
	
	public int getId() {
		return this.id;
	}
	
	public String[] toArray() {
		String[] producto = new String[4];
		producto[0] = Integer.toString(this.id);
		producto[1] = this.descripcion;
		producto[2] = Double.toString(this.precioUnitario);
		producto[3] = Integer.toString(this.stock);
		return producto;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
}
