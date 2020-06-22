package Model;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDB {
    public static Connection getConnection() {
        Connection conn = null;
        try {
            //load JDBC driver
            Class.forName(DatabaseInfo.driverName);
            //connect to database
            conn = DriverManager.getConnection(DatabaseInfo.dbURL, DatabaseInfo.userDB, DatabaseInfo.passDB);
            System.out.println("Connect successfully!");
        } catch (Exception ex) {
            System.out.println("Connect failure!");
            ex.printStackTrace();
        }
        return conn;
    }
}
