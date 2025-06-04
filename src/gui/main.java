package gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel; // Importa la subclase necesaria para trabajar con los datos de una tabla
import java.awt.event.*;
import java.util.ArrayList;

public class main {

    //Simula una lista de películas (sin bbdd)
    static ArrayList<String[]> listaPeliculas = new ArrayList();

    public static void main(String[] args) {

        ventanaPrincipal ventana = new ventanaPrincipal();

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
                        String id = String.valueOf(listaPeliculas.size()+1);
                        String titulo = formulario.getTitulo();
                        String anio = formulario.getAnio();
                        String autor = formulario.getAutor();
                        String genero = formulario.getGenero();
                        //Metemos la nurva pelicula en una lista
                        String[] nuevaPelicula = new String[]{id, titulo, anio, autor, genero};
                        listaPeliculas.add(nuevaPelicula);
                        actualizarTabla(ventana.getModeloTabla()); //Actualizamos la tabla
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
                    listaPeliculas.remove(fila); //Eliminamos esa fila
                    actualizarTabla(ventana.getModeloTabla()); //Actualizamos la tabla
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
                    String[] peliculaSeleccionada = listaPeliculas.get(fila);   //Cogemos la fila seleccionada
                    //Creamos el formualario para que se pueda modificar la pelicula (muestra el formulario esta vacio )
                    FormularioPelicula formulario = new FormularioPelicula(ventana);
                    formulario.getTituloFormulario().setText(peliculaSeleccionada[1]);
                    formulario.getAnioFormulario().setText(peliculaSeleccionada[2]);
                    formulario.getAutorFormulario().setText(peliculaSeleccionada[3]);
                    formulario.getGeneroFormulario().setText(peliculaSeleccionada[4]);
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
                            peliculaSeleccionada[1] = formulario.getTitulo();
                            peliculaSeleccionada[2] = formulario.getAnio();
                            peliculaSeleccionada[3] = formulario.getAutor();
                            peliculaSeleccionada[4] = formulario.getGenero();

                            actualizarTabla(ventana.getModeloTabla()); //actualizamos la tabla
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
    public static void actualizarTabla(DefaultTableModel modelo){
        modelo.setRowCount(0);  //borra todo lo que habia en la tabla
        //recorre la lista de peliculas y las va añiediendo
        for (String[] pelicula : listaPeliculas) {
            modelo.addRow(pelicula);    //añade una fila con los datos de la pelicuña
        }
    }
}
