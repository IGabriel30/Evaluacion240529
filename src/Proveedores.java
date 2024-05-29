import java.util.ArrayList;

public class Proveedores implements IFileLectura {
    private String nombre;
    private int telefono;
    private String email;
    private String descripcion;
    public Proveedores() {
    }

    private ArrayList<Proveedores> proveeedoresEmigrados = new ArrayList<Proveedores>();

    private int indexNombre = -1;
    private int indexTelefono = -1;
    private int indexDescripcion = -1;
    private int indexEmail = -1;

    
    public ArrayList<Proveedores> getProveeedoresEmigrados() {
        return proveeedoresEmigrados;
    }
    public Proveedores(String nombre, int telefono, String email, String descripcion) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.descripcion = descripcion;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getTelefono() {
        return telefono;
    }
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    private void asignarIndices(String linea) {
        String[] splitNameCampo = linea.split(",");
        for (int i = 0; i < splitNameCampo.length; i++) {
            String campo = splitNameCampo[i];
            switch (campo) {
                case "Nombre":
                    indexNombre = i;
                    break;
                case "Teléfono":
                    indexTelefono = i;
                    break;
                case "Email":
                    indexEmail = i;
                    break;
                    case "Descripción":
                    indexDescripcion = i;
                    break;
            }
        }
    }


    @Override
    public void leerLinea(String linea, int numLinea) {
        if (numLinea == 1) {
            asignarIndices(linea);
        } else {
            Proveedores proveedores = new Proveedores();
            proveeedoresEmigrados.add(proveedores);
            String[] splitValueCampo = linea.split(",");
            for (int i = 0; i < splitValueCampo.length; i++) {
                String valor = splitValueCampo[i].trim();
                if (i == indexNombre) {
                    proveedores.setNombre(valor);
                }
                else if (i == indexTelefono) {
                    proveedores.setTelefono(Integer.parseInt(valor));
                }
                else if (i == indexEmail) {
                    proveedores.setEmail(valor);
                }
                else if (i == indexDescripcion) {
                    proveedores.setEmail(valor);
                }
            }
        }
    }
        
    }
    

