package veterinaria.models;

public class Session {

	//private Caja caja;
	
	private Almacen almacen;
	
	private GestionCliente gestionCliente;

	public Session() {
		//this.caja = new Caja();
		this.almacen = new Almacen();
		this.gestionCliente = new GestionCliente();
	}

	public void agregarProducto(int id, String descripcion, double precioUnitario, int stock) {
		this.almacen.add(new Producto(id, descripcion, precioUnitario, stock));
	}

	public String[] buscarProductoPorId(int id) {
		if(this.almacen.exists(id)) {
			return this.almacen.buscarProductoPorId(id);
		}
		return null;
	}

	public String[][] listaProductos() {
		return this.almacen.listaProductos();
	}

	public boolean existProducto(int id) {
		return this.almacen.exists(id);
	}

	public void modificarProducto(int id, String descripcion, double precioUnitario) {
		this.almacen.modificarProducto(id, descripcion, precioUnitario);
	}

	public boolean existCliente(String dni) {
		return this.gestionCliente.exists(dni);
	}

	public void agregarCliente(String dni, String nombres, String apellidoPaterno, String apellidoMaterno, char sexo) {
		this.gestionCliente.agregarCliente(new Cliente(dni, nombres, apellidoPaterno, apellidoMaterno, sexo));
	}

	public String[][] listaClientes() {
		return this.gestionCliente.listaClientes();
	}

	public String[] buscarClientePorDni(String dni) {
		return this.gestionCliente.buscarClientePorDni(dni);
	}

	public void modificarCliente(String dni, String nombres, String apellidoPaterno, String apellidoMaterno, char sexo) {
		this.gestionCliente.modificarCliente(dni, nombres, apellidoPaterno, apellidoMaterno, sexo);
	}
}
