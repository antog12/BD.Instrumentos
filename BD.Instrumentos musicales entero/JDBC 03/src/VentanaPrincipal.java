import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class VentanaPrincipal extends JFrame {
    JButton btnAltas, btnModificar, btnEliminar;
    Connection conexion;
    VentanaAltas ventanaAltas;
    VentanaModificar ventanaModificar;

    public VentanaPrincipal(Connection conexion){
        this.conexion=conexion;
        setBounds(50, 50, 400, 250);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new FlowLayout());

        ventanaAltas=new VentanaAltas(conexion);
        ventanaModificar=new VentanaModificar(conexion);

        btnAltas=new JButton("Altas usuario");
        add(btnAltas);
        btnAltas.addActionListener(new CallBackVentanaAltas());

        btnModificar=new JButton("Modificar");
        add(btnModificar);
        btnModificar.addActionListener(new CallBackVentanaModificar());

        btnEliminar=new JButton("Eliminar");
        add(btnEliminar);

    }
    private class CallBackVentanaAltas implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            ventanaAltas.setVisible(true);
        }
    }

    private class CallBackVentanaModificar implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            ventanaModificar.setVisible(true);
        }
    }

}


