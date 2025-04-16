package uy.edu.ucu.aed.tdas;

public class Almacen implements uy.edu.ucu.aed.tdas.IAlmacen {
    private class Nodo {

    }

    private ILista<Producto> lista;

    public Almacen() {
        this.lista = new Lista<Producto>();
    }

    @Override
    public boolean agregarProducto(Producto producto) {
        lista.insertar(producto,producto.getCodProd());
        return true;
    }

    @Override
    public boolean agregarStock(Comparable clave, int cantidad) {
      Producto producto = lista.buscar(clave);
      producto.setStock(producto.getStock() + cantidad);
      return true;
    }

    @Override
    public Producto venta(Comparable clave, int cantidad) {
      Producto producto = lista.buscar(clave);
      if (producto == null){return null;}

      producto.setStock(producto.getStock() - cantidad);
      return producto;
    }

    @Override
    public Producto eliminarProducto(Comparable clave) {
        Producto producto = lista.buscar(clave);
        lista.eliminar(clave);
        return producto;
    }

    @Override
    public boolean existe(Comparable clave) {
        return lista.buscar(clave) != null;
    }

    @Override
    public void listar() {
        System.out.println(lista.imprimir());
    }
}
