import java.io.Serializable;

public class Producto implements Serializable{
    
    private String nombre;
    private int clave;
    private float precio;
    private String tipo;
    private int cantidad;

    public Producto(){
    }
    
    public Producto(String nombre, int clave, Float precio, String tipo, int cantidad){
        this.nombre = nombre;
        this.clave = clave;
        this.precio = precio;
        this.tipo = tipo;
        this.cantidad = cantidad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setClave(int clave) {
        this.clave = clave;
    }

    public int getClave() {
        return clave;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public float getPrecio() {
        return precio;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public String toString(){
        return "Nombre: " + nombre + "\nClave: " + clave + "\nPrecio: " + precio + "\nTipo: " + tipo + "\nCantidad: " + cantidad;
    }

}
