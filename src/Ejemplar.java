/**
 * Copia física de un libro. Cada ejemplar corresponde a un único libro (R10),
 * por eso el Libro es obligatorio en el constructor (multiplicidad 1).
 */
public class Ejemplar {
    private String codigoBarras;
    private Libro libro;

    public Ejemplar(String codigoBarras, Libro libro) {
        if (libro == null) {
            throw new IllegalArgumentException("Un ejemplar debe corresponder a un libro.");
        }
        this.codigoBarras = codigoBarras;
        this.libro = libro;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public Libro getLibro() {
        return libro;
    }
}
