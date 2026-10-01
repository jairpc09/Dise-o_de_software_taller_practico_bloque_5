import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Libro libro = new Libro("978-0-13-468599-1", "Clean Code", "Robert C. Martin");
        Ejemplar ejemplar = new Ejemplar("EJ-0001", libro);
        libro.agregarEjemplar(ejemplar);

        Estudiante estudiante = new Estudiante("1085000001", "Cristian", "cristian@correo.edu.co",
                "EST-2024-001", "Ingeniería de Software");
        Bibliotecario bibliotecario = new Bibliotecario("1085000002", "Marta Ruiz", "marta@biblioteca.edu.co",
                "EMP-014", "Mañana");

        Prestamo prestamo = new Prestamo(estudiante, ejemplar, LocalDate.of(2026, 10, 7));

        System.out.println("=== PRUEBA 1: renovación válida ===");
        System.out.println("Fecha prevista antes : " + prestamo.getFechaPrevistaDevolucion());
        prestamo.renovar(LocalDate.of(2026, 10, 15));
        estudiante.notificar("Su préstamo fue renovado.");
        System.out.println("Nueva fecha prevista : " + prestamo.getFechaPrevistaDevolucion());
        System.out.println("Cantidad renovaciones: " + prestamo.getRenovaciones().size());
        Renovacion r = prestamo.getRenovaciones().get(0);
        System.out.println("Historial            : anterior=" + r.getFechaAnterior()
                + ", nueva=" + r.getNuevaFecha() + ", realizada=" + r.getFechaRenovacion());

        System.out.println();
        System.out.println("=== PRUEBA 2: renovación inválida (fecha igual a la vigente) ===");
        intentarRenovar(prestamo, LocalDate.of(2026, 10, 15));

        System.out.println();
        System.out.println("=== PRUEBA 3: renovación inválida (fecha anterior a la vigente) ===");
        intentarRenovar(prestamo, LocalDate.of(2026, 10, 10));

        System.out.println();
        System.out.println("=== PRUEBA 4: Notificable es una capacidad, no una superclase ===");
        Usuario[] usuarios = { estudiante, bibliotecario };
        for (Usuario u : usuarios) {
            if (u instanceof Notificable n) {
                n.notificar("Aviso del sistema para " + u.getNombre());
            } else {
                System.out.println(u.getNombre() + " es Usuario pero no es Notificable (no recibe avisos).");
            }
        }
    }

    private static void intentarRenovar(Prestamo prestamo, LocalDate fecha) {
        try {
            prestamo.renovar(fecha);
            System.out.println("ERROR: debía rechazarse y no se rechazó.");
        } catch (IllegalArgumentException e) {
            System.out.println("Rechazada -> " + e.getMessage());
        }
        System.out.println("Fecha prevista sigue : " + prestamo.getFechaPrevistaDevolucion());
        System.out.println("Cantidad renovaciones: " + prestamo.getRenovaciones().size() + " (sin cambios)");
    }
}
