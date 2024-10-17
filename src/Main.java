import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LibroDAO libroDAO = new LibroDAOImpl();
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        // Agregar libros por defecto
        Libro libro1 = new Libro (1, "Cien Años de Soledad", "Gabriel García Márquez", 1967);
        Libro libro2 = new Libro (2, "Don Quijote de la Mancha", "Miguel de Cervantes", 1605);
        Libro libro3 = new Libro (3, "1984", "George Orwell", 1949);
        Libro libro4 = new Libro (4, "Orgullo y Prejuicio", "Jane Austen", 1813);

        libroDAO.crearLibro(libro1);
        libroDAO.crearLibro(libro2);
        libroDAO.crearLibro(libro3);
        libroDAO.crearLibro(libro4);

        while (continuar) {
            System.out.println("\n--- Menú de Gestión de Libros ---");
            System.out.println("1. Ver todos los libros");
            System.out.println("2. Crear un libro");
            System.out.println("3. Leer un libro por ID");
            System.out.println("4. Actualizar libro");
            System.out.println("5. Eliminar libro");
            System.out.println("0. Salir");
            System.out.print("Selecciona una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:

                    // Ver todos los libros

                    System.out.println("Lista de todos los libros:");
                    List<Libro> libros = libroDAO.obtenerTodosLosLibros();
                    if (libros.isEmpty()) {
                        System.out.println("No hay libros en el sistema.");
                    } else {
                        for (Libro libro : libros) {
                            System.out.println(libro);
                        }
                    }
                    break;

                case 2:

                    // Crear un libro

                    System.out.print("Introduce el ID del libro: ");
                    int nuevoId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Introduce el título del libro: ");
                    String titulo = scanner.nextLine();

                    System.out.print("Introduce el autor del libro: ");
                    String autor = scanner.nextLine();

                    System.out.print("Introduce el año de publicación: ");
                    int año = scanner.nextInt();

                    Libro nuevoLibro = new Libro(nuevoId, titulo, autor, año);
                    libroDAO.crearLibro(nuevoLibro);
                    System.out.println("Libro añadido: " + nuevoLibro);
                    break;

                case 3:

                    // Leer un libro por ID

                    System.out.print("Introduce el ID del libro a leer: ");
                    int id = scanner.nextInt();
                    Libro libroPorId = libroDAO.obtenerLibroPorId(id);
                    if (libroPorId != null) {
                        System.out.println("Libro encontrado: " + libroPorId);
                    } else {
                        System.out.println("Libro con ID " + id + " no encontrado.");
                    }
                    break;

                case 4:

                    // Actualizar libro

                    System.out.print("Introduce el ID del libro a actualizar: ");
                    int idActualizar = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Introduce el nuevo título del libro: ");
                    String nuevoTitulo = scanner.nextLine();

                    System.out.print("Introduce el nuevo autor del libro: ");
                    String nuevoAutor = scanner.nextLine();

                    System.out.print("Introduce el nuevo año de publicación: ");
                    int nuevoAño = scanner.nextInt();

                    Libro libroActualizado = new Libro(idActualizar, nuevoTitulo, nuevoAutor, nuevoAño);
                    libroDAO.actualizarLibro(libroActualizado);
                    System.out.println("Libro actualizado: " + libroActualizado);
                    break;

                case 5:

                    // Eliminar libro
                    System.out.print("Introduce el ID del libro a eliminar: ");
                    int idEliminar = scanner.nextInt();
                    libroDAO.eliminarLibro(idEliminar);
                    break;

                case 0:

                    // Salir
                    continuar = false;
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
                    break;
            }
        }

        scanner.close();
    }
}
