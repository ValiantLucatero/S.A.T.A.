import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class EscribirYLeerObjetoEnFichero
{
	// Guarda un objeto en un archivo de texto que tiene de nombre el serial del producto
	// @[in] recibe un objeto tipo Producto
	public void escribirObjetoEnFichero(Producto guardandoProducto)
	{
		FileOutputStream fichero =null;
		try
		{
			fichero = new FileOutputStream(guardandoProducto.getClave()+".txt");
			ObjectOutputStream tuberia = new ObjectOutputStream(fichero);
			tuberia.writeObject(guardandoProducto);
		}
		catch(IOException ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			try
			{
				fichero.close();
			}
			catch(IOException ex)
			{
				ex.printStackTrace();
			}
		}
	}

	// Carga Objetos de un archivo
	// @[in] recibe una cadena de texto con el serial del producto
	// @[out] regresa un objeto tipo producto
	public Producto leerArchivoEnFichero(String a)
	{
		FileInputStream fichero=null;
		Producto temp=new Producto();
		try
		{
			fichero=new FileInputStream(a+".txt");
			ObjectInputStream tuberia = new ObjectInputStream(fichero);
			temp= (Producto)tuberia.readObject();
		}
		catch(IOException ex)
		{
			ex.printStackTrace();
		}
		catch(ClassNotFoundException ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			try
			{
				fichero.close();
			}
			catch(IOException ex)
			{
				ex.printStackTrace();		
			}
			return temp;
		}
	}
}
