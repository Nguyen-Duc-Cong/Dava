package Model;

public interface DatabaseInfo {
    public static String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

    public static String IP = "127.0.0.1";
    public static String instanceName = "SQLEXPRESS";
    public static String db = "FULib";
    public static String uid = "sa";
    public static String pwd = "cong123";
    public static String port = "1433";
    //public static String dbURL = "jdbc:sqlserver://" + IP + "\\" + instanceName + ":" + port + ";databaseName" + db + ";user=" + uid + ";password" + pwd;
    public static String dbURL="jdbc:sqlserver://localhost:1433;databaseName=FULib;";

    public static String userDB = "sa";
    public static String passDB = "cong123";
}
