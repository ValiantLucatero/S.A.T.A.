public class Consola
{
	//Clase que contendra el main
	public static void main(String[] args)
	{
		Producto coca = new Producto();
		Producto tryy = new Producto();
		coca.setNombre("coca");
		coca.setClave(1);
		coca.setMarca("coca Cola");
		coca.setCantidad(10);
		coca.setPrecio(18);
		System.out.println(coca.getNombre());
		System.out.println(coca.getClave());
		System.out.println(coca.getMarca());
		System.out.println(coca.getCantidad());
		System.out.println(coca.getPrecio());

		//Guarda objeto tipo producto en un .txt
		EscribirYLeerObjetoEnFichero fichero= new EscribirYLeerObjetoEnFichero();
		fichero.escribirObjetoEnFichero(coca);

		//lee archivo de texto
		tryy=fichero.leerArchivoEnFichero("1");
		System.out.println(tryy.getNombre());
		System.out.println(tryy.getClave());
		System.out.println(tryy.getMarca());
		System.out.println(tryy.getCantidad());
		System.out.println(tryy.getPrecio());
		EliminarProducto del= new EliminarProducto();
		del.eliminarProducto("1");
	}
}
