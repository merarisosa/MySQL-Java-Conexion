package org.example;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private String bd_name = "BD_Prueba1";
    private String url = "jdbc:mysql://localhost:3306/" + bd_name;
    private String user = "root";
    private String pswd = "root";
    private String driver = "com.mysql.cj.jdbc.Driver";
    private Connection conn;

    public Conexion() {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, pswd);
            JOptionPane.showMessageDialog(null,
                    "Conexión establecida correctamente");
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null,
                    "Error al establecer la conexión " + e.getMessage());
        }
    }

    public Connection getConn() {
        return conn;
    }

    public void closeConn() {
        try {
            conn.close();
            JOptionPane.showMessageDialog(null,
                    "Conexión cerrada correctamente");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,
                    "Error al cerrar la conexión " + e.getMessage());
        }
    }
}


