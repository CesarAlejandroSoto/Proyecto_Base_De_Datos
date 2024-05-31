package uis.edu.co.banco_de_sangre.controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Conexion {
    private static Connection conect;

    static Statement createStatement() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
    public void conectar(){
        try {
            String url = "jdbc:mysql://localhost:3306/banco_de_sangre?serverTimezone=UTC";
            String usuario = "root";
            String contraseña = "admin";
            
            conect = DriverManager.getConnection(url, usuario, contraseña);
            JOptionPane.showMessageDialog(null, "Conexión exitosa a la base de datos.", "Conexión Exitosa", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al intentar conectarse a la base de datos: " + e.getMessage(), "Error de Conexión", JOptionPane.ERROR_MESSAGE);
        }  
    
    }
    public static Connection getConect () {
        return conect;
    }
}

