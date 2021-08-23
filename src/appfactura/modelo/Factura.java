package appfactura.modelo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Factura {
	private Cliente cliente;
	private ItemFactura[] items;
	private Integer folio;
	private static int ultimoFolio;
	private String descripcion;
	private Date fecha;
	private int indiceItems;
	public static final int MAX_ITEMS = 2; // CONSTANTE

	public Factura(Cliente cliente, String descripcion) {
		this.cliente = cliente;
		this.descripcion = descripcion;
		this.items = new ItemFactura[MAX_ITEMS];
		this.folio = ++ultimoFolio;
		this.fecha = new Date();
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public ItemFactura[] getItems() {
		return items;
	}

	public void setItems(ItemFactura[] items) {
		this.items = items;
	}

	public Integer getFolio() {
		return folio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public void addItemsFactura(ItemFactura item) {
		if (indiceItems < MAX_ITEMS) {
			this.items[indiceItems++] = item;
		}

	}

	public float calcularTotal() {
		float total = 0.0f;
		for (ItemFactura item : this.items) {
			if (item == null) {
				continue;
			}
			total += item.calcularImporte();
		}
		return total;

	}

	public String generarDetalles() {
		StringBuilder sb = new StringBuilder("Factura N°: ");
		sb.append(folio).append("\nCliente ").
		append(this.cliente.getNombre())
		.append("\t NIF: ").
		append(cliente.getNif()).
		append("\nDescripción: ").
		append(this.descripcion).append("\n");
		
		SimpleDateFormat df = new SimpleDateFormat("dd 'de' MMMM, YYYY");
		sb.append("Fecha de emisión: ")
		.append(df.format(fecha))
		.append("\n").append("\n#\tNombre\t$\tcant.\ntotal\n");
		for(ItemFactura item : this.items) {
			if(item == null) {
				continue;
			}
			sb.append("\t")
			.append(item.getProducto().getNombre())
			.append("\t")
			.append(item.getProducto().getPrecio())
			.append("\t")
			.append(item.getCantidad())
			.append("\t")
			.append(item.calcularImporte())
			.append("\n");
		}
		sb.append("\nGran total: ")
		.append(calcularTotal());
		
		return sb.toString();
		}
}
