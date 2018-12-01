public class VistaProducto
{
  public void imprimirProducto(int clave, String nombre, String marca, int cantidad, int precio)
  {
    System.out.println("Producto: " + nombre);
    System.out.println("Clave: " + clave);
    System.out.println("Existencias: " + cantidad);
    System.out.println("Precio: $" + precio);
  }
}
