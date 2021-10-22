import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class VentanaModificar extends JFrame {
    JTextField txtNombre, txtDNI, txtTelefono, txtEmail;
    JLabel lblId;
    Connection conexion;

    public VentanaModificar(Connection conexion) {

        this.conexion = conexion;
        setBounds(100, 100, 500, 300);
        getContentPane().setLayout(new FlowLayout());

        lblId=new JLabel("0");
        add(lblId);

        txtNombre=new JTextField("", 40);
        add(txtNombre);

        txtDNI=new JTextField("DNI", 40);
        add(txtDNI);

        txtTelefono=new JTextField("Teléfono", 40);
        add(txtTelefono);

        txtEmail=new JTextField("Email", 40);
        add(txtEmail);

        /*JButton btnAnterior=new JButton("Anterior");
        add(btnAnterior);
        btnAnterior.addActionListener(new CallBackAnterior());

        JButton btnSiguiente=new JButton("Siguiente");
        add(btnSiguiente);
        btnSiguiente.addActionListener(new CallBackSiguiente());*/

        String consulta="SELECT * FROM usuarios";
        try {
            //Creamos un statemen y realizamos la consulta
            Statement statement = conexion.createStatement();
            ResultSet resultSet=statement.executeQuery(consulta);

            //Nos colocamos en el primer elemento de la BBDD que devuelve la consulta
            resultSet.next();

            //Actualizamos los controles con los datos del primer registro
            lblId.setText(String.valueOf(resultSet.getInt("id")));
            txtNombre.setText(resultSet.getString("nombre"));
            txtDNI.setText(resultSet.getString("dni"));
            txtTelefono.setText(resultSet.getString("telefono"));
            txtEmail.setText(resultSet.getString("email"));

        }catch (SQLException sqle){
            sqle.printStackTrace();
        }

    }
}
