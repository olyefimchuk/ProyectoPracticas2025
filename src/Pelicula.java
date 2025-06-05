import gui.FormularioPelicula;

public class Pelicula {
    private String id;
    private String titulo;
    private String anio; // año
    private String autor;
    private String genero;


    // Constructor
    public Pelicula(String id, String titulo, String anio, String autor, String genero) {
        this.id = id.trim();
        this.titulo = titulo.trim();
        this.anio = anio.trim();
        this.autor = autor.trim();
        this.genero = genero.trim();
    }


    /*** Setters ***/

    // setter para id
    public void setId(String id) {
        this.id = id;
    }

    // setter para titulo
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    // setter para año
    public void setAnio(String anio) {
        this.anio = anio;
    }

    // setter para autor
    public void setAutor(String autor) {
        this.autor = autor;
    }

    // setter para genero
    public void setGenero(String genero) {
        this.genero = genero;
    }


    /*** Getters ***/

    // getter para id
    public String getId() {
        return id;
    }

    // getter para titulo
    public String getTitulo() {
        return titulo;
    }

    // getter para año
    public String getAnio() {
        return anio;
    }

    // getter para Autor
    public String getAutor() {
        return autor;
    }

    // getter para genero
    public String getGenero() {
        return genero;
    }


    // Metodo para validar los campos
    public boolean valido(FormularioPelicula formulario) {

        try {
            formulario.limpiarError(); // para quitar texto de error

            if (titulo == null || titulo.trim().isEmpty()) {
                formulario.mostrarError("El título no puede estar vacío");
                return false;
            }

            try {
                int numAnio = Integer.parseInt(anio);
                if (numAnio < 1900 || numAnio > 2025) {
                    formulario.mostrarError("Año inválido");
                    return false;
                }
            }
            catch (NumberFormatException ex) {
                formulario.mostrarError("El año debe ser un numero entero entre 1900 y 2025");
                return false;
            }
            if (autor == null || autor.trim().isEmpty()) {
                formulario.mostrarError("El autor no puede estar vacío");
                return false;
            }
            if (genero == null || genero.trim().isEmpty()) {
                formulario.mostrarError("El genero no puede estar vacío");
                return false;
            }
            return true;
        }
        catch (Exception ex) {
            formulario.mostrarError("Error inesperado: " + ex.getMessage());
            return false;
        }
    }



}
