/**
 * Un Bibliotecario ES un Usuario de la biblioteca (R12).
 *
 * Decisión: NO implementa Notificable. Supuesto: las notificaciones del sistema (R13 dice que
 * "algunos" usuarios las reciben) se dirigen a quien tiene préstamos y reservas, es decir,
 * al estudiante. Si mañana se necesitan alertas para el personal, basta con agregar
 * "implements Notificable" aquí, sin tocar Usuario ni Estudiante.
 */
public class Bibliotecario extends Usuario {
    private String codigoEmpleado;
    private String turno;

    public Bibliotecario(String identificacion, String nombre, String correo,
                         String codigoEmpleado, String turno) {
        super(identificacion, nombre, correo);
        this.codigoEmpleado = codigoEmpleado;
        this.turno = turno;
    }

    public String getCodigoEmpleado() {
        return codigoEmpleado;
    }

    public String getTurno() {
        return turno;
    }
}
