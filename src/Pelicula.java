public class Pelicula {
    private String id;
    private String titulo;
    private String anio; // año
    private String autor;
    private String genero;


    // Constructor
    public Pelicula(String id, String titulo, String anio, String autor, String genero) {
        this.id = id;
        this.titulo = titulo;
        this.anio = anio;
        this.autor = autor;
        this.genero = genero;
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
    public void validar() throws IllegalArgumentException {
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new IllegalArgumentException("El título no puede estar vacío");
        }
        int numAnio = Integer.parseInt(anio);
        if (numAnio < 1900 || numAnio > 2025) {
            throw new IllegalArgumentException("Año inválido");
        }
        if (autor == null || autor.trim().isEmpty()) {
            throw new IllegalArgumentException("Autor no puede estar vacío");
        }
        if (genero == null || genero.trim().isEmpty()) {
            throw new IllegalArgumentException("Genero no puede estar vacío");
        }
    }

}
