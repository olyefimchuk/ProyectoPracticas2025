import gui.FormularioPelicula;

import java.util.ArrayList;
import java.util.List;

public class CatalogoPeliculas {

    private List<Pelicula> peliculas; // lista temporal de peliculas

    // Constructor
    public CatalogoPeliculas() {
        peliculas = new ArrayList<>();
    }

    public boolean agregarPelicula(Pelicula pelicula, FormularioPelicula formulario) {
        if (pelicula.valido(formulario)) {
            peliculas.add(pelicula);
            return true;
        }
        return false;
    }

    public List<Pelicula> getPeliculas() {
        return peliculas;
    }

}
