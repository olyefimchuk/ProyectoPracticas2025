import gui.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel; // Importa la subclase necesaria para trabajar con los datos de una tabla
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        CatalogoPeliculas catalogo = new CatalogoPeliculas();

        VentanaPrincipal ventana = new VentanaPrincipal();

        //Cuando se pulse el boton de añadir:
        ventana.getBotonAnadir().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FormularioPelicula formulario = new FormularioPelicula(ventana);    //Abrimos el formulario para rellenar los datos
                //Cuando se pulse el boton del formulario:
                formulario.getBotonConfirmar().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //Recogemos los datos que ha escrito el usuario
                        String id = String.valueOf(catalogo.getPeliculas().size()+1);
                        String titulo = formulario.getTitulo();
                        String anio = formulario.getAnio();
                        String autor = formulario.getAutor();
                        String genero = formulario.getGenero();
                        //Metemos la nueva pelicula en una lista
                        Pelicula pelicula = new Pelicula(id, titulo, anio, autor, genero);
                        catalogo.agregarPelicula(pelicula);
                        actualizarTabla(ventana.getModeloTabla(), catalogo.getPeliculas()); //Actualizamos la tabla
                        formulario.dispose(); //Cerramos el formulario
                    }
                });
                formulario.setVisible(true);    //Miestra el formulario
            }
        });
        //Cuando se pulse el boton de eliminar:
        ventana.getBotonEliminar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int fila = ventana.getTablaPeliculas().getSelectedRow(); //Para obtener la fila que el usuario ha seleccionado
                if (fila != -1){    //Si ha seleccionado alguna fila
                    catalogo.getPeliculas().remove(fila); //Eliminamos esa fila
                    actualizarTabla(ventana.getModeloTabla(), catalogo.getPeliculas()); //Actualizamos la tabla
                } else {    //Si no selecciona nada, muestra un aviso
                    JOptionPane.showMessageDialog(null, "Seleccione una Fila");
                }
            }
        });
        //Cuando se pulse el boton de modificar
        ventana.getBotonModificar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int fila = ventana.getTablaPeliculas().getSelectedRow();
                if (fila != -1){    //Si ha seleccionado alguna pelicula
                    Pelicula peliculaSeleccionada = catalogo.getPeliculas().get(fila);   //Cogemos la fila seleccionada
                    //Creamos el formualario para que se pueda modificar la pelicula (muestra el formulario esta vacio )
                    FormularioPelicula formulario = new FormularioPelicula(ventana);
                    formulario.getTituloFormulario().setText(peliculaSeleccionada.getTitulo());
                    formulario.getAnioFormulario().setText(String.valueOf(peliculaSeleccionada.getAnio()));
                    formulario.getAutorFormulario().setText(peliculaSeleccionada.getAutor());
                    formulario.getGeneroFormulario().setText(peliculaSeleccionada.getGenero());
                    formulario.getBotonConfirmar().setText("Guardar"); //Cambiamos el texto del boton
                    //Elimina los liteners anteiores antes de poner el nuevo
                    for (ActionListener al : formulario.getBotonConfirmar().getActionListeners()){
                        formulario.getBotonConfirmar().removeActionListener(al);
                    }
                    //Cuando pulsemos el boton de guardar:
                    formulario.getBotonConfirmar().addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            //Recogemos los datos nuevos
                           /* String id = peliculaSeleccionada[0];
                            String titulo = formulario.getTitulo();
                            String anio = formulario.getAnio();
                            String autor = formulario.getAutor();
                            String genero = formulario.getGenero();
                            //Reemplazamos los datos viejos por los nuevos
                            String[] peliculaNueva = new String[]{id, titulo, anio, autor, genero};
                            listaPeliculas.set(fila, peliculaNueva);*/
                            peliculaSeleccionada.setTitulo(formulario.getTitulo());
                            peliculaSeleccionada.setAnio(formulario.getAnio());
                            peliculaSeleccionada.setAutor(formulario.getAutor());
                            peliculaSeleccionada.setGenero(formulario.getGenero());

                            actualizarTabla(ventana.getModeloTabla(), catalogo.getPeliculas()); //actualizamos la tabla
                            formulario.dispose(); //cerramos el formulario
                        }
                    });
                    formulario.setVisible(true); //Muestra el formulario
                } else {    //Si no selecciona ninguna pelicula, muestra un mensaje
                    JOptionPane.showMessageDialog(null, "Seleccione una pelicula");
                }
            }
        });
    }
    //Metodo para actualizar la tabla
    public static void actualizarTabla(DefaultTableModel modelo, List<Pelicula> peliculas) {
        modelo.setRowCount(0);  //borra todo lo que habia en la tabla
        //recorre la lista de peliculas y las va añiediendo
        for (Pelicula pelicula : peliculas) {
            String[] fila = {
                    String.valueOf(pelicula.getId()),
                    pelicula.getTitulo(),
                    String.valueOf(pelicula.getAnio()),
                    pelicula.getAutor(),
                    pelicula.getGenero()
            };
            modelo.addRow(fila);    //añade una fila con los datos de la pelicula
        }
    }
}
