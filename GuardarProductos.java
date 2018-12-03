import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class GuardarProductos {
    
    private FileOutputStream   file;  
    private ObjectOutputStream output; 
    
    // Abrir el archivo 
    public void abrir() throws IOException { 
         file = new FileOutputStream( "productos.ser" ); 
         output = new ObjectOutputStream(file); 
    }
    
    // Cerrar el fichero 
    public void cerrar() throws IOException {
        if ( output != null ) { 
            output.close(); 
        }
    }
    
    // Escribir en el fichero 
    public void escribir(ArrayList<Producto> productos) throws IOException { 
        if ( output != null ) {
            output.writeObject(productos);
        }
    } 
    
}
