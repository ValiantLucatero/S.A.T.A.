import java.io.*;
public class EliminarProducto
{
	//Elimina un producto
	//@[in] recibe la clave de un objeto tipo producto
	public void eliminarProducto(String name)
	{
		File file= new File(name+".txt");
		if(file.delete())
		{
			System.out.println("El producto fue eliminado");
		}
		else
		{
			System.out.println("El producto no se encontro");
		}
	}
}
