import java.sql.*;

public class Database {

    private static final String URL = "jdbc:h2:./peliculasdb"; // Base de datos local
    private static final String USER = "sa";
    private static final String PASSWORD = "";

    static {
        try {
            Class.forName("org.h2.Driver");
            crearTablaSiNoExiste();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void crearTablaSiNoExiste() throws SQLException {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS peliculas (" +
                            "id VARCHAR(10) PRIMARY KEY, " +
                            "titulo VARCHAR(50), " +
                            "anio VARCHAR(4), " +
                            "autor VARCHAR(30), " +
                            "genero VARCHAR(15))"
            );
        }
    }

    public static void insertarPelicula(Pelicula p) {
        String sql = "INSERT INTO peliculas (id, titulo, anio, autor, genero) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, p.getId());
            stmt.setString(2, p.getTitulo());
            stmt.setString(3, p.getAnio());
            stmt.setString(4, p.getAutor());
            stmt.setString(5, p.getGenero());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void eliminarPelicula(String id) {
        String sql = "DELETE FROM peliculas WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void actualizarPelicula(Pelicula p) {
        String sql = "UPDATE peliculas SET titulo = ?, anio = ?, autor = ?, genero = ? WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, p.getTitulo());
            stmt.setString(2, p.getAnio());
            stmt.setString(3, p.getAutor());
            stmt.setString(4, p.getGenero());
            stmt.setString(5, p.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static java.util.List<Pelicula> cargarPeliculas() {
        java.util.List<Pelicula> lista = new java.util.ArrayList<>();
        String sql = "SELECT * FROM peliculas";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Pelicula p = new Pelicula(
                        rs.getString("id"),
                        rs.getString("titulo"),
                        rs.getString("anio"),
                        rs.getString("autor"),
                        rs.getString("genero")
                );
                lista.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}
