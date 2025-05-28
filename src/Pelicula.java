public class Pelicula {
    private String titulo;
    private String anio; // año
    private String director;
    private String genero;


    // Constructor
    public Pelicula(String titulo, String anio, String director, String genero) {
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
    public void setAnio(String anio) {
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
    public String getAnio() {
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



}
