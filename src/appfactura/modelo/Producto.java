package appfactura.modelo;

public class Producto {
	private Integer codigo;
	private String nombre;
	private float Precio;
	private static int ultimoCodigo;

	public Producto() {
		this.codigo = ++ultimoCodigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getPrecio() {
		return Precio;
	}

	public void setPrecio(float precio) {
		Precio = precio;
	}

	public Integer getCodigo() {
		return codigo;
	}

}
