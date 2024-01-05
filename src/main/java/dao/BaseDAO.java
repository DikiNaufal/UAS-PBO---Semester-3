package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author administrator
 */
public class BaseDAO {

    private static String DB_NAME = "foodshare";
    private static String DB_HOST = "localhost";
    private static String DB_USER = "root";
    private static String DB_PASS = "";

    public static Connection getCon() throws SQLException { // Note the addition here
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/" + DB_NAME, DB_USER, DB_PASS);
        } catch (SQLException e) {
            e.printStackTrace(); // Log the exception for debugging.
            throw e; // Rethrow the exception to the caller.
        }
    }

    public static void closeCon(Connection con) {
        try {
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}