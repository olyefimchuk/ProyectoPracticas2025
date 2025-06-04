package gui;

import javax.swing.*;
import java.awt.*;

public class FormularioPelicula extends JDialog{

    //Campos del formulario
    private JTextField titulo;
    private JTextField anio;
    private JTextField autor;
    private JTextField genero;
    private JButton botonConfirmar; //Boton para que el usuario confirme los datos despues de haber rellenado los campos

    //Contructor
    public FormularioPelicula(JFrame frame){
        super(frame, "Pelicula", true); //Crea otra ventana
        setSize(300,250);   //Tamaño de la ventana
        setLocationRelativeTo(frame);   //Centra la ventana respecto a la principal
        JPanel panel = new JPanel();    //Panel para los campos de texto y etiquetas
        panel.setLayout(new GridLayout(5,2,5,5));   //5 filas, 2 columnas, con 5px de espacio entre componentes
        //Campo título
        panel.add(new JLabel("Titulo:"));   //Etiqueta
        titulo = new JTextField();  //Campo de texto vacío
        panel.add(titulo);  //Lo añadimos al panel
        //Campo año
        panel.add(new JLabel("Anio:"));
        anio = new JTextField();
        panel.add(anio);
        //Campo autor
        panel.add(new JLabel("Autor:"));
        autor = new JTextField();
        panel.add(autor);
        //Campo género
        panel.add(new JLabel("Genero:"));
        genero = new JTextField();
        panel.add(genero);
        //Boton añadir
        botonConfirmar = new JButton("Confirmar");  //Boton
        panel.add(new JLabel());    //Espacio vacio para que el boton ste a la derecha
        panel.add(botonConfirmar);  //Boton confirmar
        //Todos los campos deben rellenarse, sino sale un error
        botonConfirmar.addActionListener(e -> {
            if (titulo.getText().isEmpty() || anio.getText().isEmpty() ||
                    autor.getText().isEmpty() || genero.getText().isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Rellena todos los campos!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    //Métodos para obtener los datos escritos por el usuario
    public String getTitulo(){
        return titulo.getText();
    }

    public String getAnio(){
        return anio.getText();
    }

    public String getAutor(){
        return autor.getText();
    }

    public String getGenero(){
        return genero.getText();
    }

    //Borra los datos del formulario
    public void limpiarFormulario(){
        titulo.setText("");
        anio.setText("");
        autor.setText("");
        genero.setText("");
    }
}
