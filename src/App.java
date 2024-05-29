import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        Proveedores proveedores = new Proveedores();
        leerArchivo("datos.csv", proveedores);
        System.out.println("********* PROVEEDORES *********");
        for (Proveedores item : proveedores.getProveeedoresEmigrados()) {
            String msg = "Nombre: " + item.getNombre();
            msg += " Teléfono: " + item.getTelefono();
            msg += " Email: " + item.getEmail();
            msg += " Descripción: " + item.getDescripcion();
            System.out.println(msg);
        }
    }

    static void leerArchivo(String ruta, IFileLectura iFileLectura) {
        try {
            File myObj = new File(ruta);
            Scanner myReader = new Scanner(myObj);
            int numLinea = 1;
            while (myReader.hasNextLine()) {
                String linea = myReader.nextLine();
                iFileLectura.leerLinea(linea, numLinea);
                numLinea++;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
