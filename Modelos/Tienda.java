import java.util.Scanner;
public class Tienda{
	public static void main(String[] args){
		Scanner xd = new Scanner(System.in);
		Scanner x = new Scanner(System.in);
		int resp = 0;
		String g;
		System.out.println("\t-----Bienvenido.-----");
		do {
			System.out.println("1 ---> Crear Producto");
			System.out.println("2 ---> Editar Producto");
			System.out.println("3 ---> Ver Almacen");
			System.out.println("4 ---> Borrar Producto");
			System.out.println("5 ---> Vender");
			System.out.println("6 ---> Corte de caja");
			System.out.println("7 ---> Salir");
			resp = xd.nextInt();
			switch (resp) {
				case 1:
					System.out.println("---------------------------");
					System.out.println("Selecciono Crear Producto");
					System.out.println("---------------------------");
					Producto a = new Producto();
					a.crearProducto();
					break;
				case 2:
					System.out.println("---------------------------");
					System.out.println("Selecciono Editar Producto");
					System.out.println("---------------------------");
					Producto q = new Producto();
					System.out.println("Ingrese el nombre del producto a editar:");
					g = x.next();
					q.obtenerProducto(g);
					x.reset();
					break;
				case 3:
					System.out.println("Selecciono Ver Almacen");
					break;
				case 4:
					System.out.println("Selecciono Borrar Producto");
					break;
				case 5:
					System.out.println("Selecciono Vender");
					break;
				case 6:
					System.out.println("Selecciono Corte de caja");
					break;
				case 7:
					System.out.println("Hasta luego");
					break;
				default:
					System.out.println("Seleccione una opcion...");
			}
		}while(resp!=7);
	}
}