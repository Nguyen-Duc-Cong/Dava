import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;

import static java.lang.Class.forName;

//public class openConnection1 {
//    private String driver = "sum.jdbc.odbc.JdbcOdbcDriver";
//    String url = "jdbc:odbc:KZone";
//    String uid = "sa", pwd = "";
//    Connection conn = null;
//    try
//
//    {
//        class.forName(driver);
//        conn = DriverManager.getConnection(url, uid, pwd);
//
//    }catch(
//    Exception ex)
//
//    {
//        JOptionPane.showConfirmDialog(this, ex);
//    }
//    return conn;
//}

public class openConnection1 {
    String IP = "127.0.0.1";
    String instanceName = "SQLSERVER2013";
    String db = "KidzoneDB";
    String uid = "sa";
    String pwd = "";
    String port = "1433";
    Connection c = null;
    String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    String url = "jdbc:sqlserver://" + IP + "\\" + instanceName + ":" + port + ";databaseName" + db + ";user=" + uid + ";password" + pwd;
       try{
        Class.forName(driverName);
        c = DriverManager.getConnection(url, uid, pwd);
    } catch(Exception e){
        JOptionPane.showConfirmDialog(this, e);
        System.exit(0);
        e.printStackTrace();
    }
       try{
        Class.forName(driverName);
        c = DriverManager.getConnection(url, uid, pwd);
    } catch(Exception e){
        JOptionPane.showConfirmDialog(this, e);
        System.exit(0);
        e.printStackTrace();
    }
}
