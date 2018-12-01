public class Producto
{
	private String nombre;
	private int clave;
	private String marca;
	private int cantidad;
	private float precio;
	public void setNombre(String nombre)
	{
		this.nombre=nombre;
	}
	public String getNombre()
	{
		return nombre;
	}
	public void setClave(int clave)
	{
		this.clave=clave;
	}
	public int getClave()
	{
		return clave;
	}
	public void setMarca(String marca)
	{
		this.marca=marca;
	}
	public String getMarca()
	{
		return marca;
	}
	public void setCantidad(int cantidad)
	{
		this.cantidad=cantidad;
	}
	public int getCantidad()
	{
		return cantidad;
	}
	public void setPrecio(float precio)
	{
		this.precio=precio;
	}
	public float getPrecio()
	{
		return precio;
	}
}
