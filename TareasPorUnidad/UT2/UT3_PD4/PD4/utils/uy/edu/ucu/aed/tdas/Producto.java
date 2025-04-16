package uy.edu.ucu.aed.tdas;

public class Producto {
    private String codProd;
    private String nombre;
    private double precio;
    private int stock;
    

    public Producto(String codProd,String nombre, double precio, int stock ) {
        this.codProd = codProd;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        
    }

    public String getCodProd() {
        return codProd;
    }  

    public String getNombre() {
        return nombre;
    }
    
    public double getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }   
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "uy.edu.ucu.aed.tdas.Producto nombre=" + nombre + ", precio=" + precio + ", stock=" + stock + ", codigo del producto:"+ codProd;
    }

}  
