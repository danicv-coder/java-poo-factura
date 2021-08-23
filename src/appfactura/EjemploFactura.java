package appfactura;

import java.util.Scanner;

import appfactura.modelo.*;

public class EjemploFactura {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cliente cliente = new Cliente();
		cliente.setNif("96082920-20-5");
		cliente.setNombre("Daniel Calderon");

		Scanner s = new Scanner(System.in);
		System.out.print("Ingrese una descripcion de la factura: ");
		String desc = s.nextLine();
		Factura factura = new Factura(cliente, desc);

		Producto producto;
		String nombre;
		float precio;
		int cantidad;

		System.out.println();

		for (int i = 0; i < 2; i++) {
			producto = new Producto();
			System.out.print("Ingrese producto n° " + producto.getCodigo() + ": ");
			nombre = s.next();
			producto.setNombre(nombre);

			System.out.print("Ingrese el precio: ");
			precio = s.nextFloat();
			producto.setPrecio(precio);

			System.out.print("Ingrese la cantidad");
			cantidad = s.nextInt();
			ItemFactura item = new ItemFactura(producto, cantidad);
			factura.addItemsFactura(item);
			
			System.out.println();
		}
			System.out.println(factura.generarDetalles());
	}

}
