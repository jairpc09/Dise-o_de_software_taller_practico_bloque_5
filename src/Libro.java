import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Obra del catálogo. Agrupa sus ejemplares físicos (R10) mediante AGREGACIÓN:
 * los ejemplares se crean fuera del libro y se le agregan; el Libro no los fabrica.
 */
public class Libro {
    private String isbn;
    private String titulo;
    private String autor;
    private final List<Ejemplar> ejemplares = new ArrayList<>();

    public Libro(String isbn, String titulo, String autor) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
    }

    public void agregarEjemplar(Ejemplar ejemplar) {
        if (ejemplar.getLibro() != this) {
            throw new IllegalArgumentException("El ejemplar pertenece a otro libro.");
        }
        ejemplares.add(ejemplar);
    }

    public List<Ejemplar> getEjemplares() {
        return Collections.unmodifiableList(ejemplares);
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }
}
