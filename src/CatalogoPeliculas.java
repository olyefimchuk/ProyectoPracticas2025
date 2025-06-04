import java.util.ArrayList;
import java.util.List;

public class CatalogoPeliculas {

    private List<Pelicula> peliculas; // lista temporal de peliculas

    // Constructor
    public CatalogoPeliculas() {
        peliculas = new ArrayList<>();
    }

    public void agregarPelicula(Pelicula pelicula) throws IllegalArgumentException {
        pelicula.validar();
        peliculas.add(pelicula);
    }

    public List<Pelicula> getPeliculas() {
        return peliculas;
    }

}
