import java.util.ArrayList;
import java.util.List;

public class LibroDAOImpl implements LibroDAO {
    private List<Libro> libros = new ArrayList<>();

    @Override
    public void crearLibro(Libro libro) {
        libros.add(libro);
        System.out.println("Libro añadido: " + libro);
    }

    @Override
    public Libro obtenerLibroPorId(int id) {
        for (Libro libro : libros) {
            if (libro.getId() == id) {
                return libro;
            }
        }
        return null;
    }

    @Override
    public List<Libro> obtenerTodosLosLibros() {
        return libros;
    }

    @Override
    public void actualizarLibro(Libro libroActualizado) {
        for (Libro libro : libros) {
            if (libro.getId() == libroActualizado.getId()) {
                libro.setTitulo(libroActualizado.getTitulo());
                libro.setAutor(libroActualizado.getAutor());
                libro.setAñoPublicacion(libroActualizado.getAñoPublicacion());
                System.out.println("Libro actualizado: " + libro);
                return;
            }
        }
    }

    @Override
    public void eliminarLibro(int id) {
        libros.removeIf(libro -> libro.getId() == id);
        System.out.println("Libro con id " + id + " eliminado.");
    }
}
