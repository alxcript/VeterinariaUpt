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
		this.add(new Producto(1, "Producto 1", 15.50, 10));
		this.add(new Producto(2, "Producto 2", 20, 10));
		this.add(new Producto(3, "Producto 3", 70, 10));
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
	
	public void remove(int id, int units) {
		this.productos.get(id).remove(units);
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
}
