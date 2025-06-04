public class Pelicula {
    private String titulo;
    private int anio; // año
    private String director;
    private String genero;


    // Constructor
    public Pelicula(String titulo, int anio, String director, String genero) {
        this.titulo = titulo;
        this.anio = anio;
        this.director = director;
        this.genero = genero;
    }


    /*** Setters ***/

    // setter para titulo
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    // setter para año
    public void setAnio(int anio) {
        this.anio = anio;
    }

    // setter para director
    public void setDirector(String director) {
        this.director = director;
    }

    // setter para genero
    public void setGenero(String genero) {
        this.genero = genero;
    }


    /*** Getters ***/

    // getter para titulo
    public String getTitulo() {
        return titulo;
    }

    // getter para año
    public int getAnio() {
        return anio;
    }

    // getter para director
    public String getDirector() {
        return director;
    }

    // getter para genero
    public String getGenero() {
        return genero;
    }


    // Metodo para validar los campos
    public void validar() throws IllegalArgumentException {
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new IllegalArgumentException("El título no puede estar vacío");
        }
        if (anio < 1900 || anio > 2025) {
            throw new IllegalArgumentException("Año inválido");
        }
        if (director == null || director.trim().isEmpty()) {
            throw new IllegalArgumentException("Director no puede estar vacío");
        }
        if (genero == null || genero.trim().isEmpty()) {
            throw new IllegalArgumentException("Genero no puede estar vacío");
        }
    }

}
