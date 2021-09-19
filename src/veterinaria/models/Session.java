package veterinaria.models;

public class Session {

	private Caja caja;
	
	private Almacen almacen;
	
	private GestionCliente gestionCliente;
	
	private GestionVenta gestionVenta;

	public Session() {
		this.caja = new Caja();
		this.almacen = new Almacen();
		this.gestionCliente = new GestionCliente();
		this.gestionVenta = new GestionVenta();
	}
	
	public void entradaCaja(double monto) {
		this.caja.add(monto);
	}
	
	public void grabarVenta(Ticket ticket) {
		for(LineaVenta lineaVenta : ticket.getLines()) {
			this.salidaAlmacen(lineaVenta.getIdProducto(), lineaVenta.getUnidades());
			this.entradaCaja(lineaVenta.getPrecio());
		}
		this.agregarTicket(ticket);
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
	
	public double getPrecio(int id, int unidades) {
		return this.almacen.getPrecio(id, unidades);
	}

	public boolean existProducto(int id) {
		return this.almacen.exists(id);
	}
	
	public void salidaAlmacen(int id, int unidades) {
		this.almacen.remove(id, unidades);
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
	
	public Cliente buscarCliente(String dni) {
		return this.gestionCliente.buscarCliente(dni);
	}

	public void modificarCliente(String dni, String nombres, String apellidoPaterno, String apellidoMaterno, char sexo) {
		this.gestionCliente.modificarCliente(dni, nombres, apellidoPaterno, apellidoMaterno, sexo);
	}

	public boolean hayStock(int id, int unidades) {
		return this.almacen.hayStock(id, unidades);
	}
	
	public void agregarTicket(Ticket ticket) {
		this.gestionVenta.agregarTicket(ticket);
	}

	public Ticket[] getTickets() {
		return this.gestionVenta.getTickets();
	}

	public Producto getProductoById(int id) {
		return this.almacen.getProductoById(id);
	}

	public double getCapital() {
		return this.caja.getCapital();
	}
}
