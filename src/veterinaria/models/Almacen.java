package veterinaria.models;

import java.util.HashMap;
import java.util.Map;

public class Almacen {

	private Map<Integer, Producto> productos;
	
	public Almacen() {
		this.productos = new HashMap<Integer, Producto>();
		this.llenarAlmacen();
	}
	
	private void llenarAlmacen() {
		this.add(new Producto(1, "GALLETAS DOG CHOW X 5K", 25.50, 300));
		this.add(new Producto(2, "GALLETAS WHISKAS X 5K", 20.0, 200));
		this.add(new Producto(3, "CASITA DE PERRO SCOOBY DOO STYLE", 150.0, 10));
		this.add(new Producto(4, "PEZ SALTARIN DE PLASTICO PARA GATOS", 10.0, 40));
	}
	
	public void add(Producto producto) {
		this.productos.put(producto.getId(), producto);
	}
	
	public void add(int codigo, int unidades) {
		this.productos.get(codigo).add(unidades);
	}
	
	public void remove(int codigo) {
		this.productos.remove(codigo);
	}
	
	public void remove(int id, int unidades) {
		this.productos.get(id).remove(unidades);
	}
	
	public double getPrecio(int id, int unidades) {
		return this.productos.get(id).getPrecio(unidades);
	}

	public String[] buscarProductoPorId(int id) {
		return this.productos.get(id).toArray();
	}

	public boolean exists(int id) {
		return this.productos.get(id) != null;
	}

	public String[][] listaProductos() {
		String[][] listaProductos = new String[this.productos.values().size()][0];
		int i = 0;
		for(Producto producto : this.productos.values()) {
			listaProductos[i] = producto.toArray();
			i++;
		}
		return listaProductos;
	}

	public void modificarProducto(int id, String descripcion, double precioUnitario) {
		Producto producto = this.productos.get(id);
		producto.setDescripcion(descripcion);
		producto.setPrecioUnitario(precioUnitario);
	}

	public boolean hayStock(int id, int unidades) {
		return this.productos.get(id).hayStock(unidades);
	}

	public Producto getProductoById(int id) {
		return this.productos.get(id);
	}
}
