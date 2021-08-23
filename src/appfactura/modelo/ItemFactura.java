package appfactura.modelo;

public class ItemFactura {
	private Producto producto;
	private Integer cantidad;

	public ItemFactura() {

	}

	public ItemFactura(appfactura.modelo.Producto producto, Integer cantidad) {
		this.producto = producto;
		this.cantidad = cantidad;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public float calcularImporte() {
		return this.cantidad * this.producto.getPrecio();
	}

}
