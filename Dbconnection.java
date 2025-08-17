import java.sql.*;

public class Dbconnection {
    Connection con = null;
      public static Connection ConnectionDB(){
        try {
            Class.forName("org.sqlite.JDBC");
            Connection con = DriverManager.getConnection("jdbc:sqlite:foodDatabase.db");
            System.out.println("Opened database successfully");
            return con;
         } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            return null;
         }
         
      }
        
}
