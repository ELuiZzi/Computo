package com.lumtec.computo.ConexionBD;

import javax.sql.DataSource;
import java.sql.*;

/**
 * @author billi
 */
public class ConexionAntigua {

    private static String direccionIP = "localhost";
    private static String puerto = "3306";
    private static String nombreBD = "computo";

    private static final String url = "jdbc:mysql://" + direccionIP + ":" + puerto + "/" + nombreBD + "?useTimezone=true&serverTimezone=UTC";
    private static final String user = "root";
    private static final String pass = "admin";

    private DataSource dataSource;

    /*public static Connection getConnection() {

        Connection con = null;
        var pooledDataSource = new ComboPooledDataSource();
        pooledDataSource.setJdbcUrl(url);
        pooledDataSource.setUser(user);
        pooledDataSource.setPassword(pass);
        pooledDataSource.setMaxPoolSize(10);

        try {
            con = pooledDataSource.getConnection();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return con;

    }*/

    public static Connection getConnection()  {
        Connection con = null;

        try {
            con = DriverManager.getConnection(url, user, pass);
        } catch (SQLException ex) {
            System.out.println("Error: Conexión con la Base de Datos");
        }
        return con;

    }

    public static void close(PreparedStatement pps) {
        try {
            pps.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }

    public static void close(Connection con) {
        try {
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }

    public static void close(ResultSet rs) {
        try {
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
    public static void verificarConexion() {
        //Accedemos a  la base de datos, para precargar
        Connection con = null;
        con = ConexionAntigua.getConnection();
        ConexionAntigua.close(con);
    }

}
