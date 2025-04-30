package uy.edu.ucu.aed.tdas;

public class Main {
    public static void main(String[] args) {
        Almacen almacen = new Almacen();
        int dineroGastado = 0;
        String[] lista = ManejadorArchivosGenerico.leerArchivo("PD4/altas.TXT");
        String[] lista1 = ManejadorArchivosGenerico.leerArchivo("PD4/ventas.txt");
        for (String linea : lista) {
            String[] partes = linea.split(",");
            if (partes.length == 4) {

                String codProd = partes[0];
                String nombre = partes[1];
                double precio = Double.parseDouble(partes[2]);
                int stock = Integer.parseInt(partes[3]);
                dineroGastado += (stock * precio);
                Producto producto = new Producto(codProd, nombre, precio, stock);
                almacen.agregarProducto(producto);
            } else {
                System.out.println("Formato incorrecto en la línea: " + linea);
            }
        }
        System.out.println("Productos cargados:");
        almacen.listar();
        System.out.println("Se han gastado: " + dineroGastado);
        int contadorVenta = 0;
        for (String linea : lista1) {
            String[] partes = linea.split(",");
            if (partes.length == 2) {
                String codProd = partes[0];
                Producto producto = almacen.venta(codProd, 0);
                if (producto!= null){
                int cantidad = Integer.parseInt(partes[1]);

                int cantidadVendible = Integer.min(cantidad, producto.getStock());
                if (cantidadVendible == 0) {
                    System.out.println("No hay stock suficiente para el producto: " + codProd);
                    continue;
                }

                almacen.venta(codProd, cantidadVendible);
                contadorVenta += producto.getPrecio() * cantidadVendible;
            } else {
                System.out.println("Formato incorrecto en la línea: " + linea);
            }
        }
        almacen.listar();
        System.out.println("Se han vendido: " + contadorVenta);
    }}

}
