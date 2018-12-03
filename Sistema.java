import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner; 

public class Sistema {
    
    public static void main(String[] args) {
        
        Boolean salir = true;
        int opcion = 0;
        Scanner entrada = new Scanner(System.in);
        ArrayList<Producto> productos = null;
        //Solo carga inicial.
        //ArrayList<Producto> productos = new ArrayList<Producto>();
        //productos.add(new Producto("Coca Cola", 1, 19.00f, "Bebida", 10));
        //productos.add(new Producto("Chetos", 2, 12.00f, "Chatarra", 20));
        //guardar(productos);
        
        System.out.println("\n========================================");
        System.out.println("Iniciando programa...");
        System.out.println("========================================\n");
        //mostrarProductos(productos);
        
        do {
            productos = cargar();
            if ( (productos != null) && (productos.size() != 0) ) {
                System.out.println("Menu\n");
                System.out.println("1) Mostrar inventario.");
                System.out.println("2) Agregar producto.");
                System.out.println("3) Modificar producto.");
                System.out.println("4) Eliminar producto");
                System.out.println("5) Salir.");
                System.out.print("\nIngrese la opcion deseada: ");
                try {
                    opcion = Integer.parseInt(entrada.nextLine());
                } catch ( NumberFormatException nfe ) {
                    opcion = 0;
                }
                switch ( opcion ) {
                    case 1:
                            System.out.println("\n========================================");
                            mostrarProductos(productos);
                            System.out.println("========================================\n");
                            break;
                    case 2:
                            System.out.println("\n========================================");
                            agregarProducto(productos);
                            System.out.println("========================================\n");
                            break;
                    case 3:
                            System.out.println("\n========================================");
                            modificarProducto(productos);
                            System.out.println("========================================\n");
                            break;
                    case 4:
                            System.out.println("\n========================================");
                            eliminarProducto(productos);
                            System.out.println("========================================\n");
                            break;
                    case 5:
                            System.out.println("\n========================================");
                            System.out.println("Saliendo del programa...");
                            System.out.println("========================================\n");
                            salir = false;
                            break;
                    default:
                            System.out.println("\n========================================");
                            System.out.println("Opcion no valida, intente de nuevo.");
                            System.out.println("========================================\n");
                            break;
                }
            } else {
                System.out.println("Menu\n");
                System.out.println("1) Agregar producto.");
                System.out.println("2) Salir.");
                System.out.print("\nIngrese la opcion deseada: ");
                try {
                    opcion = Integer.parseInt(entrada.nextLine());
                } catch ( NumberFormatException nfe ) {
                    opcion = 0;
                }
                switch ( opcion ) {
                    case 1:
                            System.out.println("\n========================================");
                            agregarProducto();
                            System.out.println("========================================\n");
                            break;
                    case 2:
                            System.out.println("\n========================================");
                            System.out.println("Saliendo del programa...");
                            System.out.println("========================================\n");
                            salir = false;
                            break;
                    default:
                            System.out.println("\n========================================");
                            System.out.println("Opcion no valida, intente de nuevo.");
                            System.out.println("========================================\n");
                            break;
                }
            }
        } while ( salir );

    }
    
    private static void guardar(ArrayList<Producto> productos) {
        GuardarProductos gp = new GuardarProductos();
        try {
            gp.abrir();
            gp.escribir(productos);
            gp.cerrar();
        } catch (IOException e) {
            System.out.println(e);
        }
        gp = null;
    }

    private static ArrayList<Producto> cargar() {
        CargarProductos cp = new CargarProductos();
        ArrayList<Producto> productos = null;
        try {
            cp.abrir();
            productos = cp.cargar();
            cp.cerrar();
        } catch (Exception e) {
            System.out.println("========================================");
            System.out.println("Nota: No existe el archivo productos.ser");
            System.out.println("Posiblemente se trata de una instanacia nueva.");
            System.out.println("Solucion: Agregue un producto al inventario.");
            System.out.println("========================================\n");
        }
        cp = null;
        return productos;
    }
    
    private static void mostrarProductos(ArrayList<Producto> productos) {
        System.out.println("Mostrando los productos del inventario: ");
        if ( productos != null ) {
            for (Producto prodtmp : productos) {
                System.out.println("====================");
                System.out.println(prodtmp.toString());
            }
            System.out.println("====================");
        } else {
            System.out.println("El inventarios esta limpio o no existe el archivo productos.ser.");
        }
    }
    
    private static void agregarProducto(ArrayList<Producto> productos){
        Producto producto = new Producto();
        Boolean exiteProducto = false;
        Scanner entrada = new Scanner(System.in);
        try {
            System.out.print("\nIngrese la clave del nuevo producto: ");
            producto.setClave(Integer.parseInt(entrada.nextLine()));
            for (Producto prodtmp : productos) {
                if ( prodtmp.getClave() == producto.getClave() ) {
                    System.out.println("\n====================");
                    System.out.println("La clave que ingreso ya existe en el inventario.");
                    System.out.println("====================");
                    System.out.println(prodtmp.toString());
                    System.out.println("====================\n");
                    exiteProducto = true;
                    break;
                }
            }
            if ( exiteProducto == false ) {
                System.out.print("\nIngrese el nombre del producto: ");
                producto.setNombre(entrada.nextLine());
                System.out.print("\nIngrese el precio del producto: ");
                producto.setPrecio(Float.parseFloat(entrada.nextLine()));
                System.out.print("\nIngrese el tipo del producto: ");
                producto.setTipo(entrada.nextLine());
                System.out.print("\nIngrese la cantidad disponible del producto: ");
                producto.setCantidad(Integer.parseInt(entrada.nextLine()));
                productos.add(producto);
                guardar(productos);
                System.out.println("\n========================================");
                System.out.println("El producto " + producto.getNombre() + " se ha agregado al inventario de manera exitosa.");
                System.out.println("========================================\n");
            }
        } catch ( NumberFormatException nfe ) {
            System.out.println("\n========================================");
            System.out.println("Usted ingreso un valor no adecuado para el campo solicitado.");
            //System.out.println("Ocurrio un error durante el proceso de agregar el nuevo producto.");
            System.out.println("========================================\n");
        }
    }
    
    private static void agregarProducto(){
        Producto producto = new Producto();
        Scanner entrada = new Scanner(System.in);
        try {
            System.out.print("\nIngrese la clave del nuevo producto: ");
            producto.setClave(Integer.parseInt(entrada.nextLine()));
            System.out.print("\nIngrese el nombre del producto: ");
            producto.setNombre(entrada.nextLine());
            System.out.print("\nIngrese el precio del producto: ");
            producto.setPrecio(Float.parseFloat(entrada.nextLine()));
            System.out.print("\nIngrese el tipo del producto: ");
            producto.setTipo(entrada.nextLine());
            System.out.print("\nIngrese la cantidad disponible del producto: ");
            producto.setCantidad(Integer.parseInt(entrada.nextLine()));
            ArrayList<Producto> productos = new ArrayList<Producto>();;
            productos.add(producto);
            guardar(productos);
            System.out.println("\n========================================");
            System.out.println("El producto " + producto.getNombre() + " se ha agregado al inventario de manera exitosa.");
            System.out.println("========================================\n");
        } catch ( NumberFormatException nfe ) {
            System.out.println("\n========================================");
            System.out.println("Usted ingreso un valor no adecuado para el campo solicitado.");
            //System.out.println("Ocurrio un error durante el proceso de agregar el nuevo producto.");
            System.out.println("========================================\n");
        }
    }
    
    private static void modificarProducto(ArrayList<Producto> productos){
        Boolean exiteProducto = false;
        Scanner entrada = new Scanner(System.in);
        try {
            System.out.print("\nIngrese la clave del producto a modificar: ");
            int clave = Integer.parseInt(entrada.nextLine());
            int indice;
            for (Producto prodtmp : productos) {
                if ( prodtmp.getClave() == clave ) {
                    exiteProducto = true;
                    indice = productos.indexOf(prodtmp);
                    System.out.println("\n====================");
                    System.out.println("Valores actuales del producto.");
                    System.out.println("====================");
                    System.out.println(prodtmp.toString());
                    System.out.println("====================\n");
                    System.out.print("\nIngrese el nombre del producto: ");
                    prodtmp.setNombre(entrada.nextLine());
                    System.out.print("\nIngrese el precio del producto: ");
                    prodtmp.setPrecio(Float.parseFloat(entrada.nextLine()));
                    System.out.print("\nIngrese el tipo del producto: ");
                    prodtmp.setTipo(entrada.nextLine());
                    System.out.print("\nIngrese la cantidad disponible del producto: ");
                    prodtmp.setCantidad(Integer.parseInt(entrada.nextLine()));
                    productos.remove(indice);
                    productos.add(indice,prodtmp);
                    guardar(productos);
                    System.out.println("\n========================================");
                    System.out.println("El producto " + prodtmp.getNombre() + " con clave " + prodtmp.getClave() + " se ha actualizado correctamente.");
                    System.out.println("========================================\n");
                    break;
                }
            }
            if ( exiteProducto == false ) {
                System.out.println("\n====================");
                System.out.println("La clave que ingreso no existe en el inventario.");
                System.out.println("====================\n");
            }
        } catch ( NumberFormatException nfe ) {
            System.out.println("\n========================================");
            System.out.println("Usted ingreso un valor no adecuado para el campo solicitado.");
            //System.out.println("Ocurrio un error durante el proceso de eliminar el producto.");
            System.out.println("========================================\n");
        }
    }
    
    private static void eliminarProducto(ArrayList<Producto> productos){
        Boolean exiteProducto = false;
        Scanner entrada = new Scanner(System.in);
        try {
            System.out.print("\nIngrese la clave del nuevo producto: ");
            int clave = Integer.parseInt(entrada.nextLine());
            for (Producto prodtmp : productos) {
                if ( prodtmp.getClave() == clave ) {
                    exiteProducto = true;
                    System.out.println("\n====================");
                    System.out.println("La clave que ingreso existe en el inventario.");
                    System.out.println("====================");
                    System.out.println(prodtmp.toString());
                    System.out.println("====================\n");
                    productos.remove(prodtmp);
                    guardar(productos);
                    System.out.println("\n========================================");
                    System.out.println("El producto " + prodtmp.getNombre() + " se ha eliminado del inventario correctamente.");
                    System.out.println("========================================\n");
                    break;
                }
            }
            if ( exiteProducto == false ) {
                System.out.println("\n====================");
                System.out.println("La clave que ingreso no existe en el inventario.");
                System.out.println("====================\n");
            }
        } catch ( NumberFormatException nfe ) {
            System.out.println("\n========================================");
            System.out.println("Usted ingreso un valor no adecuado para el campo solicitado.");
            //System.out.println("Ocurrio un error durante el proceso de eliminar el producto.");
            System.out.println("========================================\n");
        }
    }
    
}
