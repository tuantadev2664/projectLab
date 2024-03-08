package database;

//Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static String urlDB = "jdbc:sqlserver://localhost:1433;databaseName=LABClass; encrypt = false";
    private static String userDB = "sa";
    private static String passDB = "123";

    public static Connection getConnect() {
        Connection con=null;
        try {
            Class.forName(driverName);
            con = DriverManager.getConnection(urlDB, userDB, passDB);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
    public static void main(String[] args) {
        try(Connection con=DBConnection.getConnect()) {
            if(con!=null)
                System.out.println("Connect success");
            else
                System.out.println("Connect fail");

        } catch (Exception e) {
        }
    }
}
