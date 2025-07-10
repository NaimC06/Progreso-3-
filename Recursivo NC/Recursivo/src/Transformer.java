public class Transformer {
    private int id;
    private String faccion;
    private String nombre;
    private float poder;

    public Transformer(int id, String faccion, String nombre, float poder) {
        this.id = id;
        this.faccion = faccion;
        this.nombre = nombre;
        this.poder = poder;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFaccion() {
        return faccion;
    }

    public void setFaccion(String faccion) {
        this.faccion = faccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPoder() {
        return poder;
    }

    public void setPoder(float poder) {
        this.poder = poder;
    }

    @Override
    public String toString() {
        return "Transformer: " +
                "id: " + id +
                "faccion: " + faccion +
                "nombre: " + nombre +
                "poder: " + poder;
    }
}