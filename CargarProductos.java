import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class CargarProductos {

    private FileInputStream   file;  
    private ObjectInputStream input; 
    
    // Abrir el archivo 
    public void abrir() throws IOException { 
         file = new FileInputStream( "productos.ser" ); 
         input = new ObjectInputStream(file); 
    }
    
    // Cerrar el fichero 
    public void cerrar() throws IOException {
        if ( input != null ) { 
            input.close(); 
        }
    }
    
    // Escribir en el fichero 
    public ArrayList<Producto> cargar() throws IOException, ClassNotFoundException, EOFException { 
        ArrayList<Producto> productos = null; 
        if ( input != null ) { 
            productos = (ArrayList<Producto>) input.readObject(); 
        } 
        return productos; 
    } 

}
