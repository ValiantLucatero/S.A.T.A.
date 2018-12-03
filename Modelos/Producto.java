import java.util.Scanner;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.Serializable;
public class Producto implements Serializable{
	private String nombre;
	private String tipo;
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

	public void setTipo(String tipo)
	{
		this.tipo=tipo;
	}

	public String getTipo()
	{
		return tipo;
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

	public void crearProducto(){
		Scanner d = new Scanner(System.in);
		String n,b;
		float p;
		int i;
		System.out.println("Ingrese el nombre:");
		n = d.next();
		b=n;
		this.setNombre(n);
		System.out.println("---------------------------");
		System.out.println("Ingrese el tipo:");
		n = d.next();
		this.setTipo(n);
		System.out.println("---------------------------");
		System.out.println("Ingrese la clave:");
		i = d.nextInt();
		this.setClave(i);
		System.out.println("---------------------------");
		System.out.println("Ingrese la marca:");
		n = d.next();
		this.setMarca(n);
		System.out.println("---------------------------");
		System.out.println("Ingrese la cantidad:");
		i = d.nextInt();
		this.setCantidad(i);
		System.out.println("---------------------------");
		System.out.println("Ingrese el Precio:");
		p = d.nextFloat();
		this.setPrecio(p);
		System.out.println("---------------------------");
		try{
			ObjectOutput out = new ObjectOutputStream(new FileOutputStream(b+".ser"));
		    out.writeObject(this);
		    out.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		System.out.println("Producto creado.");
	}
	public void imprimirProducto(){
		System.out.println("Nombre: "+this.getNombre());
		System.out.println("Tipo: "+this.getTipo());
		System.out.println("Clave: "+this.getClave());
		System.out.println("Marca: "+this.getMarca());
		System.out.println("Cantidad: "+this.getCantidad());
		System.out.println("Precio: "+this.getPrecio());
	}

	public void obtenerProducto(String nombre){
		Producto p = new Producto();
		try{
			ObjectInput s = new ObjectInputStream(new FileInputStream(nombre+".ser"));
			p = (Producto) s.readObject();
			s.close();
		}catch(FileNotFoundException exc){
	      System.out.println("El archivo no existe, es la primera vez que se ejecuta");
	      System.out.println("----------------------------");
	    }catch(IOException e){
			e.printStackTrace();
		}catch(Exception m){
			m.printStackTrace();
		}
		p.imprimirProducto();
	}
}