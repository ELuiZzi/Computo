package ConexionBD;

import java.sql.*;

/**
 *
 * @author billi
 */
public class Conexion {

    private static String direccionIP = "localhost";
    private static String puerto = "3306";
    private static String nombreBD = "computo";

    private static final String url = "jdbc:mysql://" + direccionIP + ":" + puerto + "/" + nombreBD + "?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String user = "root";
    private static final String pass = "admin";

    public static Connection getConnection() {
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
    
   
           

}
