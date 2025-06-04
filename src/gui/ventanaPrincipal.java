package gui;

import javax.swing.*;   // Importa las clases de Swing
import javax.swing.table.DefaultTableModel; // Importa la subclase necesaria para trabajar con los datos de una tabla
import java.awt.*;  // Para poder usas cosas de diseño

public class ventanaPrincipal extends JFrame {

    //Atributos necesarios
    private JTable tablaPeliculas;  //Tabla donde estarán las películas
    private DefaultTableModel modeloTabla;  //El modelo de los datos de la tabla
    private JButton botonAnadir;    //Botón para añadir una película
    private JButton botonModificar; //Botón para modificar una película
    private JButton botonEliminar;  //Botón para eliminar una película

    //Constructor
    public ventanaPrincipal() {
        setTitle("Peliculas");  //Título de la ventana
        setSize(800,400);   //Tamaño de la ventana
        setDefaultCloseOperation(EXIT_ON_CLOSE);    //Para que se termine el programa cuando se cierre la ventana
        setLocationRelativeTo(null);    //Centra la ventana
        modeloTabla = new DefaultTableModel();  //crea el modelo de la tabla
        modeloTabla.setColumnIdentifiers(new String[]{"Id", "Titulo", "Año", "Autor", "Genero"});   //Las columnas de la tabla
        tablaPeliculas = new JTable(modeloTabla);   //Crea la tabla y le pasamos el modelo
        JScrollPane scrollPane = new JScrollPane(tablaPeliculas);   //Añadimos scroll a la tabla, por si hay varias películas
        //Creamos los botones
        botonAnadir = new JButton("Añadir");
        botonModificar = new JButton("Modificar");
        botonEliminar = new JButton("Eliminar");
        //Creamos un panel donde irán los botones y los añadimos al panel
        JPanel panel = new JPanel();
        panel.add(botonAnadir);
        panel.add(botonModificar);
        panel.add(botonEliminar);
        add(scrollPane, BorderLayout.CENTER); //Añade la tabla en el centro de la ventana
        add(panel, BorderLayout.SOUTH); //Añade el panel de botones abajo
        setVisible(true);   //Para que se vea la ventana
    }

    //Métodos get para los atributos
    public  JTable getTablaPeliculas() {
        return tablaPeliculas;
    }

    public DefaultTableModel getModeloTabla() {
        return modeloTabla;
    }

    public JButton getBotonAnadir() {
        return botonAnadir;
    }

    public JButton getBotonModificar() {
        return botonModificar;
    }

    public JButton getBotonEliminar() {
        return botonEliminar;
    }
}

