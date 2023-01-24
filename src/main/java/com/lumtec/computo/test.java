package com.lumtec.computo;

import java.sql.*;

/**
 *
 * @author billi
 */
public class test {

    private static final String url = "jdbc:mysql://127.0.0.1:3306/computo?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String user = "root";
    private static final String pass = "admin";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, pass);
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
