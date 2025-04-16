package uy.edu.ucu.aed.tdas;

public interface IAlmacen {
    /**
     * Agrega un producto al almacen.
     *
     * @param producto - El producto a agregar.
     * @return True si el producto fue agregado con éxito, false en caso contrario.
     */
    boolean agregarProducto(Producto producto);

    /**
     * Busca un producto en el almacen utilizando su nombre.
     *
     * @param clave - El nombre del producto a buscar.
     * @return El producto si se encuentra, null en caso contrario.
     */
    boolean agregarStock(Comparable clave, int cantidad);

    /**
     * Busca un producto en el almacen utilizando su nombre.
     *
     * @param clave - El nombre del producto a buscar.
     * @return El producto si se encuentra, null en caso contrario.
     */
    Producto venta(Comparable clave, int cantidad);

    /**
     * Busca un producto en el almacen utilizando su nombre.
     *
     * @param clave - El nombre del producto a buscar.
     * @return El producto si se encuentra, null en caso contrario.
     */
    Producto eliminarProducto(Comparable clave);

    /**
     * Busca un producto en el almacen utilizando su nombre.
     *
     * @param clave - El nombre del producto a buscar.
     * @return El producto si se encuentra, null en caso contrario.
     */
    boolean existe (Comparable clave);

    /**
     * Genera una representación en cadena de los productos en el almacen.
     *
     * @return Una cadena que contiene los productos en el almacen.
     */
    void listar();
}
