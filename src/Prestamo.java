import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Prestamo {
    // ASOCIACION: el estudiante y el ejemplar existen antes y después del préstamo
    private Estudiante estudiante;
    private Ejemplar ejemplar;
    private LocalDate fechaPrevistaDevolucion;
    // COMPOSICION: las renovaciones las crea y las posee el propio préstamo
    private List<Renovacion> renovaciones = new ArrayList<>();

    public Prestamo(Estudiante estudiante, Ejemplar ejemplar, LocalDate fechaPrevistaDevolucion) {
        this.estudiante = estudiante;
        this.ejemplar = ejemplar;
        this.fechaPrevistaDevolucion = fechaPrevistaDevolucion;
    }

    /**
     * Regla protegida aquí (no en quien llama): la nueva fecha debe ser estrictamente
     * posterior a la fecha prevista vigente. Si no, lanza IllegalArgumentException y
     * el préstamo queda exactamente como estaba.
     */
    public void renovar(LocalDate nuevaFecha) {
        // 1. validar que nuevaFecha sea posterior a la fecha actual prevista
        if (nuevaFecha == null || !nuevaFecha.isAfter(fechaPrevistaDevolucion)) {
            throw new IllegalArgumentException(
                "Renovación inválida: la nueva fecha (" + nuevaFecha
                + ") debe ser posterior a la fecha prevista vigente (" + fechaPrevistaDevolucion + ").");
        }
        // 2. crear la Renovacion (conserva fecha anterior, nueva fecha y fecha de la renovación)
        Renovacion renovacion = new Renovacion(LocalDate.now(), fechaPrevistaDevolucion, nuevaFecha);
        // 3. almacenarla
        renovaciones.add(renovacion);
        // 4. actualizar fechaPrevistaDevolucion
        fechaPrevistaDevolucion = nuevaFecha;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public Ejemplar getEjemplar() {
        return ejemplar;
    }

    public LocalDate getFechaPrevistaDevolucion() {
        return fechaPrevistaDevolucion;
    }

    /** Vista de solo lectura: nadie de afuera puede alterar el historial. */
    public List<Renovacion> getRenovaciones() {
        return Collections.unmodifiableList(renovaciones);
    }
}
