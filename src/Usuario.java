/**
 * Abstracción de "usuario de biblioteca" (R12). Es abstracta: en SmartLibrary
 * nunca existe un usuario "genérico", siempre es un estudiante o un bibliotecario.
 */
public abstract class Usuario {
    private String identificacion;
    private String nombre;
    private String correo;

    public Usuario(String identificacion, String nombre, String correo) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.correo = correo;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }
}
