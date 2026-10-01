/**
 * Un Estudiante ES un Usuario de la biblioteca y además puede recibir notificaciones
 * (por ejemplo, renovaciones y vencimientos de sus préstamos).
 */
public class Estudiante extends Usuario implements Notificable {
    private String codigoEstudiantil;
    private String programaAcademico;

    public Estudiante(String identificacion, String nombre, String correo,
                      String codigoEstudiantil, String programaAcademico) {
        super(identificacion, nombre, correo);
        this.codigoEstudiantil = codigoEstudiantil;
        this.programaAcademico = programaAcademico;
    }

    public String getCodigoEstudiantil() {
        return codigoEstudiantil;
    }

    public String getProgramaAcademico() {
        return programaAcademico;
    }

    @Override
    public void notificar(String mensaje) {
        // Simulación por consola: el contrato no define el canal real (correo, push, etc.)
        System.out.println("[NOTIFICACION -> " + getNombre() + " <" + getCorreo() + ">] " + mensaje);
    }
}
